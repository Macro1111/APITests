package com.globan.automation.models;

import java.math.BigInteger;

/**
 * Data Transfer Object representing an order in the pet store.
 * Contains the order ID, pet ID, quantity, ship date, status, and completion status.
 */

public record OrderDTO(
        int id,
        BigInteger petId,
        int quantity,
        String shipDate,
        String status,
        Boolean complete) {
}
