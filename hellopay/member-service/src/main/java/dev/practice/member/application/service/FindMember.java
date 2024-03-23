package dev.practice.member.application.service;

import dev.practice.common.UseCase;
import dev.practice.member.application.port.in.FindMemberUseCase;
import dev.practice.member.application.port.out.FindMemberPort;
import dev.practice.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class FindMember implements FindMemberUseCase {

    private final FindMemberPort findMemberPort;

    @Transactional(readOnly = true)
    @Override
    public Member execute(String id) {

        return findMemberPort.get(id);
    }
}
