package dev.practice.member.application.port.in;

import dev.practice.member.domain.Member;

public interface FindMemberUseCase {

    Member execute(String id);
}
