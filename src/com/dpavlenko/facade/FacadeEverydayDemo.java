package com.dpavlenko.facade;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class FacadeEverydayDemo {

	public static void main(String args[]) throws Exception {

		URL url = new URL("http", "www.pluralsight.com", 80, "/author/bryan-hansen");


		//openStream = facade - a good usage of URL class.
		// new BufferedReader(new InputStreamReader - decorator(wrapper)
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
	}
}