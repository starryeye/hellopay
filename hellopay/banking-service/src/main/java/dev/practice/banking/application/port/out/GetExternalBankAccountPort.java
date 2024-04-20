package dev.practice.banking.application.port.out;

import dev.practice.banking.application.port.out.result.GetExternalBankAccountResult;
import dev.practice.banking.domain.RegisteredBankAccount;

public interface GetExternalBankAccountPort {

    GetExternalBankAccountResult get(
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber
    );
}
