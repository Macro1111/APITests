package com.globan.automation.models.pet;

import java.math.BigInteger;

/**
 * Data Transfer Object representing a pet category.
 * Contains the ID and name of the category.
 */

public record PetCategoryDTO(
        BigInteger id,
        String name
) {
}
