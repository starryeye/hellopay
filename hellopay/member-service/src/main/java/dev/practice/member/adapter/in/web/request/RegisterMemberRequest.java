package dev.practice.member.adapter.in.web.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterMemberRequest {

    @NotBlank
    private final String name;
    @Email
    private final String email;
    @NotBlank
    private final String address;

    @Builder
    private RegisterMemberRequest(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
