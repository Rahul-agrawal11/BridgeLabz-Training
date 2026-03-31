package com.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    UserRegistration userRegistration = new UserRegistration();

    // Test Valid Registration
    @Test
    void testValidUserRegistration() {
        String result = userRegistration.registerUser("Rahul", "rahul@gmail.com", "password123");
        assertEquals("User registered successfully", result);
    }

    // Test Invalid Username
    @Test
    void testInvalidUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("", "rahul@gmail.com", "password123");
        });
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    // Test Invalid Email
    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("Rahul", "rahulgmail.com", "password123");
        });
        assertEquals("Invalid email format", exception.getMessage());
    }

    // Test Invalid Password
    @Test
    void testInvalidPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("Rahul", "rahul@gmail.com", "123");
        });
        assertEquals("Password must be at least 6 characters", exception.getMessage());
    }
}
