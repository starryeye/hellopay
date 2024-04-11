package dev.practice.member.adapter.out.persistence;

import dev.practice.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String address;
    private Boolean isValid;
    private Boolean isCorp;

    private MemberJpaEntity(Long id, String name, String email, String address, Boolean isValid, Boolean isCorp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
    }

    public static MemberJpaEntity create(String name, String email, String address, Boolean isValid, Boolean isCorp) {
        return new MemberJpaEntity(
                null,
                name,
                email,
                address,
                isValid,
                isCorp
        );
    }

    public Member toDomain() {
        return Member.create(
                new Member.MemberId(String.valueOf(id)),
                new Member.MemberName(name),
                new Member.MemberEmail(email),
                new Member.MemberAddress(address),
                new Member.MemberIsValid(isValid),
                new Member.MemberIsCorp(isCorp)
        );
    }

    public void changeName(String name) {
        this.name = name;
    }
}
