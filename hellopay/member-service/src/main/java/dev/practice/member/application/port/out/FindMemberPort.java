package dev.practice.member.application.port.out;

import dev.practice.member.domain.Member;

public interface FindMemberPort {

    Member get(String id);
}
