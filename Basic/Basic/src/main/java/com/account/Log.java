package com.account;

import java.util.ArrayList;

public class Log {
    private ArrayList<String> histroy = new ArrayList<String>();

    public void log(String log) {
        //System.out.println("LOG : " + log);
        histroy.add("LOG : " + log);
    }

    public void print() {
        for (String log: histroy  ) {
            System.out.println(log);
        }
    }
}
