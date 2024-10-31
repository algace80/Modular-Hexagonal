package org.alejandro.hexagonal.offer.model.entity;

import org.alejandro.hexagonal.offer.model.exception.OfferArgumentNotValidException;
import org.alejandro.hexagonal.offer.model.exception.util.ErrorCatalog;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EndDateTest {

    @Test
    void testEndDateFromTimestamp() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);

        // Act
        EndDate endDate = new EndDate(timestamp);

        // Assert
        assertEquals(timestamp.toLocalDateTime(), endDate.returnEndDateForEntity().toLocalDateTime());
    }

    @Test
    void testEndDateFromValidString() {
        // Arrange
        String validDateString = "01/01/2024 10:15";

        // Act
        EndDate endDate = new EndDate(validDateString);

        // Assert
        assertEquals(validDateString, endDate.returnEndDateForDto());
    }

    @Test
    void testEndDateFromNullString() {
        // Act & Assert
        OfferArgumentNotValidException exception = assertThrows(OfferArgumentNotValidException.class, () -> {
            new EndDate((String) null);
        });

        assertEquals(ErrorCatalog.INVALID_NULL_PARAMETER_OFFER.getCode(), exception.getErrorCode());
        assertEquals("Invalid offer parameter. EndDate can't be null", exception.getErrorMessage());
    }

    @Test
    void testEndDateFromInvalidString() {
        // Act & Assert
        OfferArgumentNotValidException exception = assertThrows(OfferArgumentNotValidException.class, () -> {
            new EndDate("invalid-date");
        });

        assertEquals(ErrorCatalog.INVALID_DATE_FORMAT_OFFER.getCode(), exception.getErrorCode());
        assertEquals("Invalid offer parameter. The EndDate format should be dd/MM/yyyy HH:mm", exception.getErrorMessage());
    }
}
