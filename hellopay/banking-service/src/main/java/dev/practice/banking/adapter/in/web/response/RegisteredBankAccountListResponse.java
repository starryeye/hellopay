package dev.practice.banking.adapter.in.web.response;

import dev.practice.banking.domain.RegisteredBankAccount;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class RegisteredBankAccountListResponse {

    private final String memberId;
    private final List<RegisteredBankAccountDetailResponse> registeredBankAccounts;

    @Builder
    private RegisteredBankAccountListResponse(String memberId, List<RegisteredBankAccountDetailResponse> registeredBankAccounts) {
        this.memberId = memberId;
        this.registeredBankAccounts = registeredBankAccounts;
    }

    public static RegisteredBankAccountListResponse of(String memberId, List<RegisteredBankAccount> domains) {
        return RegisteredBankAccountListResponse.builder()
                .memberId(memberId)
                .registeredBankAccounts(
                        domains.stream()
                                .map(RegisteredBankAccountDetailResponse::of)
                                .toList()
                )
                .build();

    }
}
