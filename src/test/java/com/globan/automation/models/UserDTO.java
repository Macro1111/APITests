package com.globan.automation.models;

/**
 * Data Transfer Object representing a user in the pet store.
 * Contains user details such as ID, username, first name, last name, email, password, phone, and user status.
 */

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
