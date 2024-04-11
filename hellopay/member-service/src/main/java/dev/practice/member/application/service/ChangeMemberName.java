package dev.practice.member.application.service;

import dev.practice.common.UseCase;
import dev.practice.member.application.port.in.ChangeMemberNameUseCase;
import dev.practice.member.application.port.out.ChangeMemberNamePort;
import dev.practice.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class ChangeMemberName implements ChangeMemberNameUseCase {

    private final ChangeMemberNamePort changeMemberNamePort;

    @Transactional
    @Override
    public Member execute(String id, String name) {

        /**
         * todo,
         * 여기서 찾고 변경해주고 반영해야할까..?
         * 그냥 change port 를 만들어서 adapter 에서 찾고 변경해줘야할까..?
         */

        return changeMemberNamePort.changeName(
                new Member.MemberId(id),
                new Member.MemberName(name)
        );
    }
}
