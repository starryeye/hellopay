package dev.practice.money.adapter.out.persistence.jpa;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class MembersMoneyJpaEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberId;
    private Integer balance;

    @Builder
    private MembersMoneyJpaEntity(Long id, String memberId, Integer balance) {
        this.id = id;
        this.memberId = memberId;
        this.balance = balance;
    }

    public static MembersMoneyJpaEntity create(String memberId, Integer balance) {
        return MembersMoneyJpaEntity.builder()
                .id(null)
                .memberId(memberId)
                .balance(balance)
                .build();
    }
}
