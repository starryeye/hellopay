package dev.practice.member.adapter.in.web.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterMemberRequest {

    private final String name;
    private final String email;
    private final String address;

    @Builder
    private RegisterMemberRequest(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
