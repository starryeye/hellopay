package dev.practice.banking.application.service;

import dev.practice.banking.application.port.in.FindBankAccountUseCase;
import dev.practice.banking.application.port.out.CheckMemberValidationPort;
import dev.practice.banking.application.port.out.FindRegisteredBankAccountPort;
import dev.practice.banking.domain.RegisteredBankAccount;
import dev.practice.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindRegisteredBankAccount implements FindBankAccountUseCase {

    private final CheckMemberValidationPort checkMemberValidationPort;
    private final FindRegisteredBankAccountPort findRegisteredBankAccountPort;

    @Override
    public List<RegisteredBankAccount> execute(String memberId) {
        /**
         * hellopay 에 등록된 외부 실물 계좌 정보를 조회한다.
         *
         * 0. 요청한 회원에 대해, member-service 에 회원이 유효한지 확인 todo
         *
         * 1. RegisteredBankAccount 리스트 리턴
         */

        RegisteredBankAccount.MemberId memberIdDomain = new RegisteredBankAccount.MemberId(memberId);

        Boolean memberIdIsValid = checkMemberValidationPort.isValid(memberIdDomain);

        if(memberIdIsValid == Boolean.FALSE) {
            // todo, invalid memberId
            return null;
        }

        return findRegisteredBankAccountPort.get(memberIdDomain);
    }
}
