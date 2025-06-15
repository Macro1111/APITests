package com.globan.automation.models;

public record UserDTO(
        long id,
        String username,
        String firstName,
        String lastName,
        String email,
        String password,
        String phone,
        long userStatus) {
}
