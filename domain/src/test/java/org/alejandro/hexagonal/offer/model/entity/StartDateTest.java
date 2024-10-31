package org.alejandro.hexagonal.offer.model.entity;

import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StartDateTest {

    @Test
    void testStartDateFromTimestamp() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);

        // Act
        StartDate startDate = new StartDate(timestamp);

        // Assert
        assertEquals(timestamp.toLocalDateTime(), startDate.returnStartDateForEntity().toLocalDateTime());
    }

    @Test
    void testStartDateFromValidString() {
        // Arrange
        String validDateString = "01/01/2024 10:15";

        // Act
        StartDate startDate = new StartDate(validDateString);

        // Assert
        assertEquals(validDateString, startDate.returnStartDateForDto());
    }

    @Test
    void testStartDateFromNullString() {
        // Act & Assert
        OfferArgumentNotValidException exception = assertThrows(OfferArgumentNotValidException.class, () -> {
            new StartDate((String) null);
        });

        assertEquals(ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getCode(), exception.getErrorCode());
        assertEquals("Invalid offer parameter. StartDate can't be null", exception.getErrorMessage());
    }

    @Test
    void testStartDateFromInvalidString() {
        // Act & Assert
        OfferArgumentNotValidException exception = assertThrows(OfferArgumentNotValidException.class, () -> {
            new StartDate("invalid-date");
        });

        assertEquals(ErrorCatalog.INVALID_DATE_FORMAT_OFFER.getCode(), exception.getErrorCode());
        assertEquals("Invalid offer parameter. The StartDate format should be dd/MM/yyyy HH:mm", exception.getErrorMessage());
    }
}
