package com.globan.automation.models;

import java.math.BigInteger;


public record OrderDTO(
        int id,
        BigInteger petId,
        int quantity,
        String shipDate,
        String status,
        Boolean complete) {
}
