package com.dpavlenko.flyweight;

import java.util.HashMap;
import java.util.Map;

//Catalog acts as a factory and cache for Item flyweight objects
public class Catalog {
	//HashMap for items
	private Map<String, Item> items = new HashMap<String, Item>();

	//factory method to see if we have these items
	public Item lookup(String itemName) {
		if (!items.containsKey(itemName))
			items.put(itemName, new Item(itemName));
		return items.get(itemName);
	}

	public int totalItemsMade() {
		return items.size();
	}
}