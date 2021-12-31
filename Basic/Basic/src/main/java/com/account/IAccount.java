package com.account;

public interface IAccount {
    public int withdraw(int value) throws Exception;
    public void deposit(int value);
    public int getBalance();
}
