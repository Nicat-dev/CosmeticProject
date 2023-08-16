package com.example.cosmeticproject.enums;

public enum MaritalStatus {
    MARRIED("MARRIED"),
    SINGLE("SINGLE"),
    DIVORCED("DIVORCED"),
    WIDOW("WIDOW");

    private final String displayValue;

    MaritalStatus(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
