package com.agilogy.csv.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompareFiles {
	public static boolean sameContents(String file1, String file2) throws IOException {
		byte[] b1 = readFile(file1);
		byte[] b2 = readFile(file2);
		
		if (b1.length != b2.length) {
			return false;
		}
		
		boolean result = true;
		for (int i=0; i<b1.length; i++)
		{
		if (b1[i]!=b2[i]) {result=false;}
		}
		return result;
	}

	private static byte[] readFile(String file1) throws IOException {
		File file = new File(file1);
		FileInputStream fis = new FileInputStream(file);
		byte[] contents = new byte[(int) file.length()];
		fis.read(contents);
		return contents;
	}
}
