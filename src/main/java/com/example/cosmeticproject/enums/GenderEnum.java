package com.example.cosmeticproject.enums;

public enum GenderEnum {
    MALE("MALE"),
    FEMALE("FEMALE");

    private final String displayValue;

    GenderEnum(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
