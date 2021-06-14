package com.test.question.q69;

import java.io.File;

public class Q004 {
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\신보경\\Desktop\\027_파일_디렉토리\\파일_디렉토리_문제\\음악 파일";
		
		File dir = new File(path);
		//앞에 붙힐 숫자
		int num = 1;
		
		File[] list = dir.listFiles();
		
		for(File name: list) {
			String newPath = String.format("%s\\[%03d]%s", path, num, name.getName());
			File newName = new File(newPath);
			name.renameTo(newName);
			
			System.out.println(newName.getName());
			num++;
		}
		
		//출력만 됨
//		 String path = "D:\\class\\java\\filedierectory\\음악 파일";
//	      File f = new File(path);
//	      File[] fl = f.listFiles();
//	      int cnt = 1;
//	      for(File t : fl) {
//	         System.out.printf("[%03d]%s\n",cnt++,t.getName());
//	      }
		
	}

}
