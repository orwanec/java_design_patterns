package com.dpavlenko.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {

	//holder for pages
	protected List<Page> pages = new ArrayList<>();
	
	public List<Page> getPages() {
		return pages;
	}

	public Website() {
		this.createWebsite();
	}

	//	crux of the matter - all subclasses will have to override it to generate those
	public abstract void createWebsite();
	
}
