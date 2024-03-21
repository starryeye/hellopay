package dev.practice.member.application.port.out;

import dev.practice.member.domain.Member;

public interface RegisterMemberPort {

    Member register(
            Member.MemberName memberName,
            Member.MemberEmail memberEmail,
            Member.MemberAddress memberAddress,
            Member.MemberIsValid memberIsValid,
            Member.MemberIsCorp memberIsCorp
    );
}
