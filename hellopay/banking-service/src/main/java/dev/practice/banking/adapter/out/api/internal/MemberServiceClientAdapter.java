package dev.practice.banking.adapter.out.api.internal;

import dev.practice.banking.adapter.out.api.internal.response.MemberResponse;
import dev.practice.banking.application.port.out.CheckMemberValidationPort;
import dev.practice.banking.domain.RegisteredBankAccount;
import dev.practice.common.WebClientAdapter;
import lombok.RequiredArgsConstructor;

@WebClientAdapter
@RequiredArgsConstructor
public class MemberServiceClientAdapter implements CheckMemberValidationPort {
    @Override
    public Boolean isValid(RegisteredBankAccount.MemberId memberId) {

        //todo, member-service interaction
        //  GET  /api/v1/members/{memberId}
        MemberResponse response = MemberResponse.builder()
                .memberId(memberId.getMemberIdValue())
                .memberName("memberName")
                .memberEmail("memberName@practice.dev")
                .memberAddress("memberAddress")
                .memberIsValid("true")
                .memberIsCorp("true")
                .build();


        return Boolean.parseBoolean(response.getMemberIsValid());
    }
}
