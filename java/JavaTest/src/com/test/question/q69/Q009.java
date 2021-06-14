package com.test.question.q69;

import java.io.File;
import java.util.ArrayList;

public class Q009 {
	
	public final static String path;
	
	static {
		path = "C:\\Users\\신보경\\Desktop\\027_파일_디렉토리\\파일_디렉토리_문제\\크기 정렬";
	}
	
	public static void main(String[] args) {
		
		File dir = new File(path);
		ArrayList<File>	fileArray = new ArrayList<File>();
		
		findeFile(dir, fileArray);
		
		for( File file  : fileArray) {
			System.out.printf("%s\t%s\t%s\n", file.getName(), file.length(), file.getAbsolutePath());
		}
		
	}

	private static void findeFile(File dir, ArrayList<File> fileArray) {

		File[] list = dir.listFiles();
		
		for(File sub : list ) {
			if(sub.isFile()) {
				fileArray.add(sub);
			}
		}
		
		for(File subsub : list) {
			if(subsub.isDirectory()) {
				findeFile(subsub, fileArray);
			}
		}
		
		
	}

	
	

}
