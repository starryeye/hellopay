package dev.practice.member.adapter.in.web.response;

import dev.practice.member.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {

    private final String memberId;
    private final String memberName;
    private final String memberEmail;
    private final String memberAddress;
    private final String memberIsValid;
    private final String memberIsCorp;

    @Builder
    private MemberResponse(String memberId, String memberName, String memberEmail, String memberAddress, String memberIsValid, String memberIsCorp) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberAddress = memberAddress;
        this.memberIsValid = memberIsValid;
        this.memberIsCorp = memberIsCorp;
    }

    public static MemberResponse of(Member member) {
        return MemberResponse.builder()
                .memberId(member.getMemberId())
                .memberName(member.getName())
                .memberEmail(member.getEmail())
                .memberAddress(member.getAddress())
                .memberIsValid(String.valueOf(member.getIsValid()))
                .memberIsCorp(String.valueOf(member.getIsCorp()))
                .build();
    }
}
