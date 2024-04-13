package dev.practice.banking.application.port.in;

import dev.practice.banking.application.port.in.source.RegisterBankAccountSource;
import dev.practice.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {

    RegisteredBankAccount execute(RegisterBankAccountSource registerBankAccountSource);
}
