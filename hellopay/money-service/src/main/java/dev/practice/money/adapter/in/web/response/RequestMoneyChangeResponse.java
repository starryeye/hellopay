package dev.practice.money.adapter.in.web.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RequestMoneyChangeResponse {

    private final String requestedMoneyChangeId;

    private final Integer amount;
    private final String type;
    private final String status;

    private final String transactionId;
    private final LocalDateTime createdAt;

    @Builder
    private RequestMoneyChangeResponse(String requestedMoneyChangeId, Integer amount, String type, String status, String transactionId, LocalDateTime createdAt) {
        this.requestedMoneyChangeId = requestedMoneyChangeId;
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.transactionId = transactionId;
        this.createdAt = createdAt;
    }
}
