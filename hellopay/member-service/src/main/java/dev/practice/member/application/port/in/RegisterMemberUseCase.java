package dev.practice.member.application.port.in;

import dev.practice.member.application.port.in.source.RegisterMemberSource;
import dev.practice.member.domain.Member;

public interface RegisterMemberUseCase {

    Member execute(RegisterMemberSource registerMemberSource);
}
