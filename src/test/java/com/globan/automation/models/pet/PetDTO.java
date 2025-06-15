package com.globan.automation.models.pet;

import java.math.BigInteger;
import java.util.List;

/**
 * Data Transfer Object representing a pet.
 * Contains the ID, category, name, photo URLs, tags, and status of the pet.
 */

public record PetDTO(
    BigInteger id,
    PetCategoryDTO category,
    String name,
    List<String> photoUrls,
    List<PetCategoryDTO> tags,
    String status) {
}
