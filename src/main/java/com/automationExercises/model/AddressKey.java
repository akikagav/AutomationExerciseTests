package com.automationExercises.model;

public enum AddressKey {
    FULL_NAME(1),
    COMPANY(2),
    ADDRESS1(3),
    ADDRESS2(4),
    STATE(5),
    COUNTRY(6),
    PHONE(7);

    private final int index;

    AddressKey(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
