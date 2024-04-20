package dev.practice.banking.adapter.out.api.external;

import dev.practice.banking.adapter.out.api.external.request.GetExternalBankAccountRequest;
import dev.practice.banking.adapter.out.api.external.response.ExternalBankAccountResponse;
import dev.practice.banking.application.port.out.GetExternalBankAccountPort;
import dev.practice.banking.application.port.out.result.GetExternalBankAccountResult;
import dev.practice.banking.domain.RegisteredBankAccount;
import dev.practice.common.WebClientAdapter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@WebClientAdapter
@RequiredArgsConstructor
public class BankAccountClientAdapter implements GetExternalBankAccountPort {


    @Override
    public GetExternalBankAccountResult get(
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber
    ) {

        GetExternalBankAccountRequest request = GetExternalBankAccountRequest.builder()
                .bankName(bankName.getBankNameValue())
                .bankAccountNumber(bankAccountNumber.getBankAccountNumberValue())
                .build();

        // todo, external banking interaction
        ExternalBankAccountResponse response = ExternalBankAccountResponse.builder()
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(Boolean.TRUE)
                .openAt(LocalDateTime.of(2022, 2, 22, 2, 22))
                .build();

        return response.toDomain();
    }
}
