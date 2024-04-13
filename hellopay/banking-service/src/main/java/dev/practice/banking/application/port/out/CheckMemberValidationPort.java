package dev.practice.banking.application.port.out;

import dev.practice.banking.domain.RegisteredBankAccount;

public interface CheckMemberValidationPort {

    Boolean isValid(RegisteredBankAccount.MemberId memberId);
}
