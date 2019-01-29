package com.dpavlenko.decorator;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class DecoratorEverydayDemo {

	public static void main(String args []) throws Exception {
		File file = new File("./output.txt");
		file.createNewFile();

		//OutputStream == base decorator, FileOutputStream == concrete decorator (subclass)
		OutputStream oStream = new FileOutputStream(file);

		//can write physical data out to the system
		DataOutputStream doStream = new DataOutputStream(oStream);
		doStream.writeChars("text");
		
		doStream.close();
		oStream.close();
	}
}
