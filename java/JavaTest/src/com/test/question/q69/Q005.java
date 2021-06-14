package com.test.question.q69;

import java.io.File;
import java.util.HashMap;

public class Q005 {
	
	public static void main(String[] args) {
		
		String path = "C:\\Users\\신보경\\Desktop\\027_파일_디렉토리\\파일_디렉토리_문제\\확장자별 카운트";
		
		File dir = new File(path);
		File[] list = dir.listFiles();
		
		int gifNum = 0;
		int jpgNum = 0;
		int pngNum = 0;
		
		HashMap<String, Integer> num = new HashMap<String, Integer>();
		
		for(File name : list){
			
			if(name.getName().endsWith("gif")) {
				gifNum++;
			} else if(name.getName().endsWith("jpg")) {
				jpgNum++;
			} else if (name.getName().endsWith("png")){
				pngNum++;
			}
			
		}
		
		System.out.printf("*.gif : %d개\n*jpg : %d개\n*.png : %d개", gifNum, jpgNum, pngNum);


	}

}
