package dev.practice.member.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    /**
     * 엔티티
     * - 도메인 내에서 유일한 식별자(memberId) 로 구분되므로 해당 객체는 엔티티이다.
     *
     * 불변 객체
     *
     * aggregate root
     * - Member 엔티티는 내부 프로퍼티와 함께 aggregate 를 형성하며, aggregate root 에 해당한다.
     */

    private final String memberId;
    private final String name;
    private final String email;
    private final String address;
    private final Boolean isValid;
    private final Boolean isCorp;

    public static Member create( // 팩토리 메서드를 통해서만 생성할 수 있도록 한다.
            MemberId memberId,
            MemberName memberName,
            MemberEmail memberEmail,
            MemberAddress memberAddress,
            MemberIsValid memberIsValid,
            MemberIsCorp memberIsCorp
    ) {
        return new Member(
                memberId.getMemberIdValue(),
                memberName.getNameValue(),
                memberEmail.getEmailValue(),
                memberAddress.getAddressValue(),
                memberIsValid.getIsValidValue(),
                memberIsCorp.getIsCorpValue()
        );
    }


    /**
     * 아래는 각각 Member aggregate 형성하는 일부이다.
     *
     * 아래와 같이 타입을 만들면 생기는 이점 (DDD)
     *
     * 1) 각 타입에 대해 특정 도메인 규칙이나 유효성 검사 로직을 내재할 수 있다.
     *
     * 2) 각 필드가 단순한 데이터 타입(예: String, boolean)이 아닌,
     * 특정한 도메인 의미를 갖는 타입으로 정의되면, 코드를 통해 도메인 모델의 의미를 더 잘 전달할 수 있다.
     *
     * 3) 도메인 내에서 공통적으로 사용되는 규칙이나 로직이 있는 경우,
     * 이를 세부적인 타입으로 분리함으로써 코드의 재사용성을 높일 수 있다.
     */
    @Value
    public static class MemberId {

        String memberIdValue;

        public MemberId(String value) {
            this.memberIdValue = value;
        }
    }

    @Value
    public static class MemberName {

        String nameValue;

        public MemberName(String value) {
            this.nameValue = value;
        }
    }
    @Value
    public static class MemberEmail {

        String emailValue;

        public MemberEmail(String value) {
            this.emailValue = value;
        }
    }

    @Value
    public static class MemberAddress {

        String addressValue;

        public MemberAddress(String value) {
            this.addressValue = value;
        }
    }

    @Value
    public static class MemberIsValid {

        Boolean isValidValue;

        public MemberIsValid(Boolean value) {
            this.isValidValue = value;
        }
    }

    @Value
    public static class MemberIsCorp {

        Boolean isCorpValue;

        public MemberIsCorp(Boolean value) {
            this.isCorpValue = value;
        }
    }
}
