package com.dpavlenko.bridge;

import java.util.List;

public abstract class Printer {

	// Composition: takes Formatter
	public String print(Formatter formatter) {
		return formatter.format(getHeader(), getDetails());
	}

	// will call this in implementation calss to build what we want to put inside of the body
	abstract protected List<Detail> getDetails();
	
	abstract protected String getHeader();
}
