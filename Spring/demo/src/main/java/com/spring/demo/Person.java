package com.spring.demo;

import lombok.*;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor

public class Person  {
    private  String name;
    public int age;
    public String hobby;
    public  Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void init() {
        System.out.println("객체가 생성되었습니다.");
    }

    public void destroy() {
        System.out.println("객체가 제거되었습니다.");
    }}
