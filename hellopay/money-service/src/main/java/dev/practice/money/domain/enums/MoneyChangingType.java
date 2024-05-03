package dev.practice.money.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MoneyChangingType {

    INCREASE("증액"),
    DECREASE("감액");

    private final String text;
}
