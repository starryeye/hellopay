package dev.practice.member.application.port.out;

import dev.practice.member.domain.Member;

public interface ChangeMemberNamePort {

    Member changeName(
            Member.MemberId memberId,
            Member.MemberName memberName
    );
}
