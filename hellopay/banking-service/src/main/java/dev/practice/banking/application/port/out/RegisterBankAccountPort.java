package dev.practice.banking.application.port.out;

import dev.practice.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccount register(
            RegisteredBankAccount.MemberId memberId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
    );
}
