package dev.practice.money.adapter.out.persistence.jpa;

import dev.practice.money.domain.enums.MoneyChangeStatus;
import dev.practice.money.domain.enums.MoneyChangeType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class RequestedMoneyChangeJpaEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long targetMemberId;
    private Integer amount;

    @Enumerated(EnumType.STRING)
    private MoneyChangeType type;
    @Enumerated(EnumType.STRING)
    private MoneyChangeStatus status;

    private String transactionId;

    @Builder
    private RequestedMoneyChangeJpaEntity(Long id, Long targetMemberId, Integer amount, MoneyChangeType type, MoneyChangeStatus status, String transactionId, LocalDateTime createdAt) {
        this.id = id;
        this.targetMemberId = targetMemberId;
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.transactionId = transactionId;
    }

    public static RequestedMoneyChangeJpaEntity create(Long targetMemberId, Integer amount, MoneyChangeType type, MoneyChangeStatus status, String transactionId) {
        return RequestedMoneyChangeJpaEntity.builder()
                .id(null)
                .targetMemberId(targetMemberId)
                .amount(amount)
                .type(type)
                .status(status)
                .transactionId(transactionId)
                .build();
    }
}
