package dev.practice.banking.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RequestedFirmBankingType {

    REQUESTED("요청중"),
    COMPLETED("완료"),
    FAILED("실패");

    private final String text;
}
