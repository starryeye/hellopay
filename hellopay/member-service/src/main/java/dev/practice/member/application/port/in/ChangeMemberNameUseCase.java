package dev.practice.member.application.port.in;

import dev.practice.member.domain.Member;

public interface ChangeMemberNameUseCase {

    Member execute(String id, String name);
}
