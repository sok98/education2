package com.account;

public class KBAccount extends Log implements IAccount{
    private int balance;
    @Override
    public int withdraw(int value) throws Exception {
        log("출금 : " + value);
        if ( balance >  value) {
            balance -= value;
        } else {
            log("에러 : 잔고부족 ");
            throw new Exception("잔고부족");
        }
        return  balance;
    }

    @Override
    public void deposit(int value) {
        log("입금 : " + value);
        balance += value;
    }

    @Override
    public int getBalance() {
        return balance;
    }


    public void print() {
        super.print();
        System.out.println("잔고 : " + balance);
    }

}
