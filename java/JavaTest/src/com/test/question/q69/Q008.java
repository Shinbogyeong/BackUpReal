package com.test.question.q69;

import java.io.File;

public class Q008 {
	
	public final static String Q008;
	public static int deleteFo;
	public static int deleteFi;
	
	static {
		Q008= "C:\\Users\\신보경\\Desktop\\027_파일_디렉토리\\파일_디렉토리_문제\\폴더 삭제\\delete";
		
		deleteFo = 0;
		deleteFi = 0;
	}

	public static void main(String[] args) {
		
	
		
		
		File dir = new File(Q008);
		deletefile(dir);
		
		
		System.out.println("폴더를 삭제했습니다.");
		System.out.printf("삭제된 폴더는 %d개이고, 파일은 %d개입니다.", deleteFo, deleteFi);
		
		
	}

	private static void deletefile(File dir) {
		
		File[] list = dir.listFiles();
		
		for(File name : list) {
			if(name.isFile()) {
				name.delete();
				deleteFo++;
				
			}
			
		}
		
		for (File sub: list) {
			if(sub.isDirectory()) {
				deletefile(sub);
			}
		}
		
		deleteFi++;
		
		dir.delete();
		
		
	}
}
