package dev.practice.member.adapter.out.persistence;

import dev.practice.common.PersistenceAdapter;
import dev.practice.member.application.port.out.ChangeMemberNamePort;
import dev.practice.member.application.port.out.RegisterMemberPort;
import dev.practice.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberCommandAdapter implements RegisterMemberPort, ChangeMemberNamePort {

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

    // todo,
//    @Transactional(propagation = Propagation.REQUIRES_NEW) 고려..
    @Override
    public Member changeName(
            Member.MemberId memberId,
            Member.MemberName memberName
    ) {
        MemberJpaEntity entity = memberJpaRepository.findById(Long.parseLong(memberId.getMemberIdValue()))
                .orElseThrow();

        entity.changeName(memberName.getNameValue());

        return entity.toDomain();
    }
}
