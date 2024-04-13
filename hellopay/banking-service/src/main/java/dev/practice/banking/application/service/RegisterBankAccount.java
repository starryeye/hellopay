package dev.practice.banking.application.service;

import dev.practice.banking.application.port.out.CheckBankAccountValidationPort;
import dev.practice.banking.application.port.out.CheckMemberValidationPort;
import dev.practice.banking.application.port.out.RegisterBankAccountPort;
import dev.practice.banking.application.port.in.RegisterBankAccountUseCase;
import dev.practice.banking.application.port.in.source.RegisterBankAccountSource;
import dev.practice.banking.domain.RegisteredBankAccount;
import dev.practice.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RegisterBankAccount implements RegisterBankAccountUseCase {

    private final CheckMemberValidationPort checkMemberValidationPort;
    private final CheckBankAccountValidationPort checkBankAccountValidationPort;
    private final RegisterBankAccountPort registerBankAccountPort;

    @Override
    public RegisteredBankAccount execute(RegisterBankAccountSource source) {

        /**
         * 자신의 외부 실물 은행 계좌를 hellopay 에 등록하는 비즈니스에 해당한다.
         *
         * 0. 요청한 회원에 대해, member-service 에 회원이 유효한지 확인 todo
         *
         * 1. 기 등록 계좌 번호 인지 확인(계좌 번호 중복 확인) todo
         *
         * 2. 등록할 외부 실물 은행 계좌가 정상인지 확인한다.
         * -> 외부 은행과 통신 todo
         *
         * 3. 등록이 가능한 계좌면, 등록하고 등록한 정보를 리턴
         * -> db 와 통신
         *
         * 3-1. 등록이 불가능한 계좌면, 에러 리턴 todo
         *
         */

        RegisteredBankAccount.MemberId memberId = new RegisteredBankAccount.MemberId(source.getMemberId());
        RegisteredBankAccount.BankName bankName = new RegisteredBankAccount.BankName(source.getBankName());
        RegisteredBankAccount.BankAccountNumber bankAccountNumber = new RegisteredBankAccount.BankAccountNumber(source.getBankAccountNumber());


        Boolean memberIsValid = checkMemberValidationPort.isValid(memberId);

        if (memberIsValid == Boolean.FALSE) {
            // todo, invalid memberId
            return null;
        }

        Boolean bankAccountIsValid = checkBankAccountValidationPort.isValid();
        RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid = new RegisteredBankAccount.LinkedStatusIsValid(bankAccountIsValid);

        return registerBankAccountPort.register(
                memberId,
                bankName,
                bankAccountNumber,
                linkedStatusIsValid
        );
    }
}
