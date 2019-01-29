package com.dpavlenko.decorator;

public abstract class SandwichDecorator implements Sandwich {

	protected Sandwich customSandwich;

	//composition
	public SandwichDecorator(Sandwich customSandwich) {
		this.customSandwich = customSandwich;
	}

	public String make() {
		return customSandwich.make();
	}
	
}
