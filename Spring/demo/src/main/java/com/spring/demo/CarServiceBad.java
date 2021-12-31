package com.spring.demo;


import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CarServiceBad implements ICarService{

	Car car;

	@Override
	public void coloring(String color) {
		car.setColor(color);
		System.out.println( "coloring (bad) : "  + car.toString()  );
	}

	@Override
	public void washing() {
		System.out.println( "washing  (bad): "  + car.toString()  );
	}
}
