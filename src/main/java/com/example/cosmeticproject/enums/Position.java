package com.example.cosmeticproject.enums;

public enum Position {
    Doctor("Hekim"),
    Administrator("adminstrasiya"),
    Worker("isci");

    private final String displayValue;

    Position(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
