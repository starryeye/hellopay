package dev.practice.member.application.port.in.source;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterMemberSource {

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
