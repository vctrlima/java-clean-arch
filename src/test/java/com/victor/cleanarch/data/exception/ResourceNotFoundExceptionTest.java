package com.victor.cleanarch.data.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceNotFoundExceptionTest {

    @Test
    void resourceNotFoundException_Catch_ThrowsException() {
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            throw new ResourceNotFoundException("Resource not found exception message");
        });

        assertEquals("Resource not found exception message", exception.getMessage());
    }

}