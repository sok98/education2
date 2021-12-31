package com.account;

public class SHAccount implements IAccount{
    private int balance;
    @Override
    public int withdraw(int value) throws Exception {
        if ( balance >  value) {
            balance -= value;
        } else {
            throw new Exception("잔고부족");
        }
        return  balance;
    }

    @Override
    public void deposit(int value) {
        balance += value * 1.1;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
