package dev.practice.member.application.port.in.source;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class RegisterMemberSource {

    /**
     * 이 DTO 가 없으면 어떻게 되는지 생각해보자.
     *
     * 1. Controller 에서 Member 도메인 객체(aggregate root) 를 생성해야할 수 있다.
     * -> presentation layer 에서 도메인 객체를 생성하는 것은 application 에서 할 일이 세어나가는 꼴이다.
     *
     * 2. Controller 에서 모든 값을 하나씩 파라미터로 넣어줘야한다.
     * -> 피곤하다.
     */

    private final String name;
    private final String email;
    private final String address;
    private final Boolean isValid;
    private final Boolean isCorp;

    @Builder
    private RegisterMemberSource(String name, String email, String address, Boolean isValid, Boolean isCorp) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
    }

    public static RegisterMemberSource create(String name, String email, String address) {
        return RegisterMemberSource.builder()
                .name(name)
                .email(email)
                .address(address)
                .isValid(true) //todo service 로직인듯..
                .isCorp(false)
                .build();
    }
}
