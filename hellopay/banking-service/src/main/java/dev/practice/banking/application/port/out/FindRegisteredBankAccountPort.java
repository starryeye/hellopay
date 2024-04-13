package dev.practice.banking.application.port.out;

import dev.practice.banking.domain.RegisteredBankAccount;

import java.util.List;

public interface FindRegisteredBankAccountPort {

    List<RegisteredBankAccount> get(
            RegisteredBankAccount.MemberId memberId
    );
}
