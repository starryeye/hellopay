package dev.practice.banking.application.port.in;

import dev.practice.banking.domain.RegisteredBankAccount;

import java.util.List;

public interface FindBankAccountUseCase {

    List<RegisteredBankAccount> execute(String memberId);
}
