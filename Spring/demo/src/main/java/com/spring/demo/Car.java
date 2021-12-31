package com.spring.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;


@Setter @Getter @ToString
public class Car {
	String name;
	String color;
	Date date;
	ArrayList<Option>  options;

	public Car(String name, String color) {
		this.name = name;
		this.color = color;
		this.date = new Date();
	}

	public void  print() {
		for (Option option: options	 ) {
			System.out.println(option);
		}
	}


}
