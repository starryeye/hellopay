package dev.practice.banking.adapter.out.api;

import dev.practice.banking.application.port.out.CheckMemberValidationPort;
import dev.practice.banking.domain.RegisteredBankAccount;
import dev.practice.common.WebClientAdapter;
import lombok.RequiredArgsConstructor;

@WebClientAdapter
@RequiredArgsConstructor
public class CheckMemberValidationAdapter implements CheckMemberValidationPort {
    @Override
    public Boolean isValid(RegisteredBankAccount.MemberId memberId) {

        //todo, member-service interaction
        return true;
    }
}
