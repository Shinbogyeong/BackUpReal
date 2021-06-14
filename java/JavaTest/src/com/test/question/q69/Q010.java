package com.test.question.q69;

import java.io.File;
import java.util.Arrays;

public class Q010 {
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\신보경\\Desktop\\027_파일_디렉토리\\파일_디렉토리_문제\\직원";
		File dir = new File(path);
		
		File[] list = dir.listFiles();
		
			for(File name : list) {
				
				if(name.isFile()) {
					String[] temp = getName(name.getName());
	
					File subDir = new File(path + "\\" + temp[0] + "\\" + temp[1]);
					System.out.println(subDir.getAbsolutePath());
					subDir.mkdirs();

					File newDir = new File(path + "\\" + temp[0]+ "\\" + temp[1] +"\\"+ name.getName());
					
					name.renameTo(newDir);
					
					//name.renameTo(subDir);
					//System.out.println("완료");
					
				}
			
			
			}
		}

	
	
	private static String[] getName(String name) {
		
		String[] temp = new String[2];
		
		int index = name.indexOf("_");
		temp[0] = name.substring(0, index);
		
		int index2 = name.indexOf("_", index +1);
		temp[1] = name.substring(index+1, index2);
		
		return temp;
	}
		
		
	

}
