package dev.practice.banking.adapter.in.web.response;

import dev.practice.banking.domain.RegisteredBankAccount;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisteredBankAccountDetailResponse {

    private final String registeredBankAccountId;
    private final String memberId;
    private final String bankName;
    private final Long bankAccountNumber;
    private final Boolean linkedStatusIsValid;

    @Builder
    private RegisteredBankAccountDetailResponse(String registeredBankAccountId, String memberId, String bankName, Long bankAccountNumber, Boolean linkedStatusIsValid) {
        this.registeredBankAccountId = registeredBankAccountId;
        this.memberId = memberId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;
    }

    public static RegisteredBankAccountDetailResponse of(RegisteredBankAccount domain) {
        return RegisteredBankAccountDetailResponse.builder()
                .registeredBankAccountId(domain.getRegisteredBankAccountId())
                .memberId(domain.getMemberId())
                .bankName(domain.getBankName())
                .bankAccountNumber(domain.getBankAccountNumber())
                .linkedStatusIsValid(domain.getLinkedStatusIsValid())
                .build();
    }
}
