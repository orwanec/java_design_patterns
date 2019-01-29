package com.dpavlenko.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorEverydayDemo {

	public static void main(String[] args) {
		//List<String> names = new ArrayList<>();
		Set<String> names = new HashSet<>();

		names.add("Bryan");
		names.add("Aaron");
		names.add("Jason");
		
		Iterator<String> namesItr = names.iterator();

		// Old School loop, but won't work if we move from ArrayList to HashSet
		//for(int i = 0; i < names.size(); i++) {
		//	String name = names.get(i);
		//}

		// The same iterator behind the scenes
		//for (String name : names) {
		//	System.out.println(name);
		//}
		
		while(namesItr.hasNext()) {
			String name = namesItr.next();
			System.out.println(name);
			namesItr.remove();  //removes the latest element to stop the loop!
		}
		
		System.out.println("Names size: " + names.size());
	}
}
