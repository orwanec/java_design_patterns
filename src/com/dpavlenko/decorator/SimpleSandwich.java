package com.dpavlenko.decorator;

public class SimpleSandwich implements Sandwich {

	@Override
	public String make() {
		return "Bread";
	}
}
