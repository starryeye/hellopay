package dev.practice.member.adapter.out.persistence;

import dev.practice.common.PersistenceAdapter;
import dev.practice.member.application.port.out.FindMemberPort;
import dev.practice.member.domain.Member;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberQueryAdapter implements FindMemberPort {

    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member get(Member.MemberId memberId) {

        MemberJpaEntity entity = memberJpaRepository.findById(Long.parseLong(memberId.getMemberIdValue()))
                .orElseThrow();

        return entity.toDomain();
    }
}
