package com.account;

import java.lang.reflect.Constructor;

public class AccountTest {
    public static void main(String[] args) throws Exception {

        int mode = 1;
        String baseClass = "com.account.KBAccount";
        IAccount bank;

        Class cls = Class.forName(baseClass);
        bank =  (IAccount) cls.newInstance();

        // 비지니스 로직
        bank.deposit(10000);
        bank.withdraw(5000);

        ((KBAccount)bank).print();

        System.out.println(bank.getBalance());

    }
}
