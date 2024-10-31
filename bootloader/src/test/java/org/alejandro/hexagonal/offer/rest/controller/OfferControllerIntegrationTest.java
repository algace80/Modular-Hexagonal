package org.alejandro.hexagonal.offer.rest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.alejandro.hexagonal.offer.model.dto.OfferDto;
import org.alejandro.hexagonal.offer.model.dto.command.OfferCommand;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "/insert-test-data.sql", config = @SqlConfig(encoding = "utf-8"), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OfferControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private MvcResult performGet(String url) throws Exception {
        return mockMvc.perform(get(url)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    private MvcResult performPost(String url, OfferCommand offerCommand) throws Exception {
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        return mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ow.writeValueAsString(offerCommand)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    private MvcResult performPut(String url, OfferCommand offerCommand) throws Exception {
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        return mockMvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ow.writeValueAsString(offerCommand)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    @Order(1)
    void testGetAll() throws Exception {
        MvcResult mockReturn = performGet("/api/v1/offers");

        List<OfferDto> offerDtoList = objectMapper.readValue(mockReturn.getResponse().getContentAsString(), new TypeReference<List<OfferDto>>() {});
        offerDtoList.forEach(offerDto -> System.out.println(offerDto.getProductPartNumber()));
        assertEquals(10, offerDtoList.size());
    }

    @Test
    @Order(2)
    void testGetById() throws Exception {
        MvcResult mockReturn = performGet("/api/v1/offers/1");

        OfferDto offerDto = objectMapper.readValue(mockReturn.getResponse().getContentAsString(), new TypeReference<OfferDto>() {});
        assertOfferDto(offerDto, 1, "01/06/2024 00:00", "30/06/2024 23:59", "004034002", BigDecimal.valueOf(99.99), "USD", 1, 1);
    }

    @Test
    @Order(3)
    void testCreateOffer() throws Exception {
        OfferCommand offerCommand = new OfferCommand(1, "14/06/2024 00:00", "14/06/2024 00:00", 1, "000100233", 0, BigDecimal.valueOf(35.5), "EUR");

        MvcResult mockReturn = performPost("/api/v1/offers", offerCommand);

        OfferDto offerDto = objectMapper.readValue(mockReturn.getResponse().getContentAsString(), new TypeReference<OfferDto>() {});
        assertOfferDto(offerDto, null, "14/06/2024 00:00", "14/06/2024 00:00", "000100233", BigDecimal.valueOf(35.5), "EUR", 0, 1);
    }

    @Test
    @Order(4)
    void testEditOffer() throws Exception {
        OfferCommand offerCommand = new OfferCommand(1, "14/06/2024 00:00", "14/06/2024 00:00", 1, "010120233", 0, BigDecimal.valueOf(33.5), "USD");

        MvcResult mockReturn = performPut("/api/v1/offers/1", offerCommand);

        OfferDto offerDto = objectMapper.readValue(mockReturn.getResponse().getContentAsString(), new TypeReference<OfferDto>() {});
        assertOfferDto(offerDto, 1, "14/06/2024 00:00", "14/06/2024 00:00", "010120233", BigDecimal.valueOf(33.5), "USD", 0, 1);
    }

    @Test
    @Order(5)
    void testDeleteOfferById() throws Exception {
        mockMvc.perform(delete("/api/v1/offers/1"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(6)
    void testDeleteAllOffers() throws Exception {
        mockMvc.perform(delete("/api/v1/offers"))
                .andExpect(status().isOk());
    }

    private void assertOfferDto(OfferDto offerDto, Integer expectedOfferId, String expectedStartDate, String expectedEndDate,
                                String expectedProductPartNumber, BigDecimal expectedPrice, String expectedCurrencyIso,
                                int expectedPriority, int expectedPriceListId) {
        if (expectedOfferId != null) {
            assertNotNull(offerDto.getOfferId());
            assertEquals(expectedOfferId.intValue(), offerDto.getOfferId().intValue());
        }
        assertEquals(expectedStartDate, offerDto.getStartDate());
        assertEquals(expectedEndDate, offerDto.getEndDate());
        assertEquals(expectedPriceListId, offerDto.getPriceListId());
        assertEquals(expectedProductPartNumber, offerDto.getProductPartNumber());
        assertEquals(expectedPriority, offerDto.getPriority());
        assertEquals(expectedPrice, offerDto.getPrice());
        assertEquals(expectedCurrencyIso, offerDto.getCurrencyIso());
    }
}
