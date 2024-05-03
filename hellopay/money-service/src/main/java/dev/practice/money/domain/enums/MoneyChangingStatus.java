package dev.practice.money.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MoneyChangingStatus {

    REQUESTED("요청중"),
    COMPLETED("완료"),
    FAILED("실패");

    private final String text;
}
