package com.dpavlenko.bridge;

import java.util.List;
// the same thing like Color in the previous example
public interface Formatter {
	//a list of Detail objects
	String format(String header, List<Detail> details);
}
