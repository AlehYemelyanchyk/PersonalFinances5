package com.alehyem.personalfinances.rest.exceptions;

public class PortfolioNotFoundException extends RuntimeException {
    public PortfolioNotFoundException(String message) {
        super(message);
    }
}
