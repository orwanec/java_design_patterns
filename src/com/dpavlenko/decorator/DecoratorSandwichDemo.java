package com.dpavlenko.decorator;

public class DecoratorSandwichDemo {

	public static void main(String args[]) {
		//Not a creational pattern -> we are adding functionality that didn't exist before through constructors and using composition in those decorators
		// Modifiyng structure of that SimpleSandwich
		Sandwich sandwich = new DressingDecorator(new MeatDecorator(new SimpleSandwich()));
		
		System.out.println(sandwich.make());
	}
}
