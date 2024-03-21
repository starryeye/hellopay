package dev.practice.member.adapter.out.persistence;

import dev.practice.common.PersistenceAdapter;
import dev.practice.member.application.port.out.RegisterMemberPort;
import dev.practice.member.domain.Member;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberCommandAdapter implements RegisterMemberPort {

    private final MemberJpaRepository memberJpaRepository;


    @Override
    public Member register(
            Member.MemberName memberName,
            Member.MemberEmail memberEmail,
            Member.MemberAddress memberAddress,
            Member.MemberIsValid memberIsValid,
            Member.MemberIsCorp memberIsCorp
    ) {

        MemberJpaEntity entity = MemberJpaEntity.create(
                memberName.getNameValue(),
                memberEmail.getEmailValue(),
                memberAddress.getAddressValue(),
                memberIsValid.getIsValidValue(),
                memberIsCorp.getIsCorpValue()
        );

        MemberJpaEntity saved = memberJpaRepository.save(entity);

        return saved.toDomain();
    }
}
