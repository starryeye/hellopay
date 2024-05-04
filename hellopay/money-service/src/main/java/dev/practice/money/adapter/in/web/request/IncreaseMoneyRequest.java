package dev.practice.money.adapter.in.web.request;

import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;

@Getter
public class IncreaseMoneyRequest {

    @Positive
    private final Long targetMemberId;
    @Positive
    private final Integer amount;

    @Builder
    private IncreaseMoneyRequest(Long targetMemberId, Integer amount) {
        this.targetMemberId = targetMemberId;
        this.amount = amount;
    }
}
