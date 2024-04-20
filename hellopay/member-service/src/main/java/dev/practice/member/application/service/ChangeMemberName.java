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
         *
         * 참고..
         * 여기서 찾고 변경해주고 반영한다면, DB 에 두번 찾아야하지 않을까는 걱정은 접어도 된다.
         * 이 메서드에 @Transactional 이 걸려있으므로 OSIV 설정과 상관없이 최소 이 메서드 범위까지 영속성컨텍스트가 살아있다.
         * 그렇다는 말은.. 첫번째 찾을 때는 DB 에 쿼리 조회가 수행되고
         * 두번째 찾고 변경해줄때는 영속성 컨텍스트가 살아있으므로 1 차 캐시에 존재하는 엔티티가 반환되므로 DB 에 조회 되지는 않음
         */

        return changeMemberNamePort.changeName(
                new Member.MemberId(id),
                new Member.MemberName(name)
        );
    }
}
