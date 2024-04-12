package dev.practice.banking.application.service;

public class RegisterBankingAccount {

    public void execute() {

        /**
         * 자신의 외부 실물 은행 계좌를 hellopay 에 등록하는 비즈니스에 해당한다.
         *
         * 0. 요청한 회원에 대해, member-service 에 회원이 유효한지 확인
         *
         * 1. 등록할 외부 실물 은행 계좌가 정상인지 확인한다.
         * -> 외부 은행과 통신
         *
         * 2. 등록이 가능한 계좌면, 등록하고 등록한 정보를 리턴
         * -> db 와 통신
         *
         * 2-1. 등록이 불가능한 계좌면, 에러 리턴
         *
         */
    }
}
