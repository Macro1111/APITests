package com.globan.automation.models.pet;

import java.math.BigInteger;
import java.util.List;

public record PetDTO(
    BigInteger id,
    PetCategoryDTO category,
    String name,
    List<String> photoUrls,
    List<PetCategoryDTO> tags,
    String status) {
}
