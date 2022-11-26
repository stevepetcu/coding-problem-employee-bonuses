package com.stefanpetcu.api.employeebonuses.presentation.responses;

public class BonusesDto {
    private final int[] bonuses;

    public BonusesDto(int[] bonuses) {
        this.bonuses = bonuses;
    }

    public int[] getBonuses() {
        return bonuses;
    }
}
