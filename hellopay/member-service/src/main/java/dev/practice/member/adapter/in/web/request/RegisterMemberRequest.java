package dev.practice.member.adapter.in.web.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterMemberRequest {

    @Size(min = 2, max = 8)
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
