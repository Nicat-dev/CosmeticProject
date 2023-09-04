package com.example.cosmeticproject.enums;

public enum PaymentDetail {
    CARD("CARD"),
    CASH("CASH");

    private final String displayValue;

    PaymentDetail(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
