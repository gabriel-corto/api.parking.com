package com.api.parking.domain.exceptions;

public class DomainError extends RuntimeException {
    public DomainError(String message) {
        super(message);
    }
}