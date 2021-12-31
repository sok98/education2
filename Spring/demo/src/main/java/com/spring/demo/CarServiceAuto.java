package com.spring.demo;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Getter @Setter @NoArgsConstructor @ToString
public class CarServiceAuto implements ICarService{

	//@Resource(name="car1")
	//@Autowired
	Car car;

	@Autowired
	public  CarServiceAuto(Car car) {
		this.car = car;
	}

	@Override
	public void coloring(String color) {
		car.setColor(color);
		System.out.println( "coloring  auto: "  + car.toString()  );
	}

	@Override
	public void washing() {
		System.out.println( "washing auto: "  + car.toString()  );
	}
}
