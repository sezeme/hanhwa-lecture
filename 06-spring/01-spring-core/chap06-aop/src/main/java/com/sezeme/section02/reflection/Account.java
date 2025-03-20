package com.sezeme.section02.reflection;

public class Account {
    private String backCode;
    private String accNo;
    private String accPwd;
    private int balance;
    public Account() {}
    public Account(String bankCode, String accNo, String accPwd) {
        this.backCode = bankCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
    }
    public Account(String bankCode, String accNo, String accPwd, int balance) {
        this(bankCode, accNo, accPwd);
        this.balance = balance;
    }
    /* 현재 잔액을 출력해주는 메소드 */
    public String getBalance() {
        return this.accNo + " 계좌의 현재 잔액은 " + this.balance + "원 입니다.";
    }
    /* 금액을 매개변수로 전달 받아 잔액을 증가(입금) 시켜주는 메소드 */
    public String deposit(int money) {
        String str = "";
        if(money >= 0) {
            this.balance += money;
            str = money + "원이 입급되었습니다.";
        }else {
            str = "금액을 잘못 입력하셨습니다.";
        }
        return str;
    }
    /* 금액을 매개변수로 받아 잔액을 감소(출금) 시켜주는 메소드 */
    public String withDraw(int money) {
        String str = "";
        if(this.balance >= money) {
            this.balance -= money;
            str = money + "원이 출금되었습니다.";
        }else {
            str = "잔액이 부족합니다. 잔액을 확인해주세요.";
        }
        return str;
    }
}

