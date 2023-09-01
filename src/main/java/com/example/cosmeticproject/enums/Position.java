package com.example.cosmeticproject.enums;

public enum Position {
    DOCTOR("Hekim"),
    ADMINISTRATOR("adminstrasiya"),
    WORKER("isci");

    private final String displayValue;

    Position(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
