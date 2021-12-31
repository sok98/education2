package com.spring.demo;

import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Person p = new Person();

		p = new Person("이순신", 30);
		System.out.println(p);

		AbstractApplicationContext context =
				new GenericXmlApplicationContext("applicationContext.xml");

		Person p1 =  (Person) context.getBean("p1");
		p1.setName("이순신");
		p1.setAge(60);
		System.out.println(p1);

		Person p1_2 =  (Person) context.getBean("p1");
		System.out.println(p1_2);
		p1_2.setName("홍길동");
		System.out.println(p1);

		if ( p1 == p1_2) System.out.println("동일주소");
		else System.out.println("다른주소");

		Person p2 =  (Person) context.getBean("p2");
		System.out.println(p2);

		Person p3 =  (Person) context.getBean("p2");
		System.out.println(p3);

//		Car car = new Car("소나타", "빨간색");
//
//		ArrayList<Option> opts = new ArrayList<Option>();
//		opts.add( new Option("네비게이션"));
//		opts.add( new Option("후방카메라"));
//		opts.add( new Option("AV 시스템"));
//		car.setOptions(opts);
//		System.out.println(car);

		Car car1 = (Car) context.getBean("car1");
		System.out.println(car1);

//		CarService svr = new CarService(car1);
//		//svr.setCar(car1);
//		svr.washing();
//		svr.coloring("금색");

		ICarService  svr = (ICarService) context.getBean("svr3");
		svr.washing();
		svr.coloring("금색");


		context.close();

	}
}


