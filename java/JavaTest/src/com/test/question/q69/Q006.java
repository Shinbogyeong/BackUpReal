package com.test.question.q69;

import java.awt.List;
import java.io.File;

public class Q006 {
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\신보경\\Desktop\\027_파일_디렉토리\\파일_디렉토리_문제\\파일 제거";
		
		File dir = new File(path);
		
		File[] list = dir.listFiles();
		
		int num = 0;
		
		
		for(File name : list) {
			
			if(name.length() == 0) {
				System.out.println(name.getName());
				name.delete();
				num++;
			}
					
		}
		
		System.out.printf("총 %d개 파일을 삭제했습니다.", num);
		
	}

}
