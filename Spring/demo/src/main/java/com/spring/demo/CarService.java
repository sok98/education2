package com.spring.demo;


import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CarService implements ICarService{

	Car car;

	@Override
	public void coloring(String color) {
		car.setColor(color);
		System.out.println( "coloring : "  + car.toString()  );
	}

	@Override
	public void washing() {
		System.out.println( "washing : "  + car.toString()  );
	}
}
