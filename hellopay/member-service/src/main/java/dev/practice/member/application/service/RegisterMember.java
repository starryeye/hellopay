package dev.practice.member.application.service;

import dev.practice.common.UseCase;
import dev.practice.member.application.port.in.RegisterMemberUseCase;
import dev.practice.member.application.port.in.source.RegisterMemberSource;
import dev.practice.member.application.port.out.RegisterMemberPort;
import dev.practice.member.domain.Member;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class RegisterMember implements RegisterMemberUseCase {

    private final RegisterMemberPort registerMemberPort;

    @Override
    public Member execute(RegisterMemberSource source) {

        /**
         * adapter.in 에서 application..
         * application 에서 adapter.out 으로.. 갈때 domain 은 생성 되지 않는다.
         * adapter.out 에서 DB 에 적재 후, domain 이 생성된다.
         * -> 적재 전.. id 가 null 인 애매한 상황도 잘 해결됨
         *
         * DB 적재 직전의 domain 에 대한 제약사항은 domain 내부 클래스로 해결할 수 있다.
         */

        return registerMemberPort.register(
                new Member.MemberName(source.getName()),
                new Member.MemberEmail(source.getEmail()),
                new Member.MemberAddress(source.getAddress()),
                new Member.MemberIsValid(source.getIsValid()),
                new Member.MemberIsCorp(source.getIsCorp())
        );
    }
}
