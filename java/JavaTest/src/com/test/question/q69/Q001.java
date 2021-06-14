package com.test.question.q69;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("파일 경로: ");
		String path = reader.readLine();
		
		//String path = "C:\\class\\java\\m1.txt";
		File file = new File(path);
		
		if(file.exists()) {
			
			String fileType ="";
			int numType = file.getName().lastIndexOf(".");
			fileType = file.getName().substring(numType + 1);
			
			
			//단위별 출력
			String fileSizeType = "B";
			int fileSize = path.length();
			if (fileSize > 999) {
				fileSize = path.length() % 1000 ;
				fileSizeType = "KB";
				
				if (fileSize > 999) {
					fileSize %=1000;
					fileSizeType = "MB";
					
					if (fileSize > 999) {
						fileSize %=1000;
						fileSizeType = "GB";
						
						if (fileSize > 999) {
							fileSize %=1000;
							fileSizeType = "TB";
							
						}
					}
				}
			}
			
			System.out.printf("파일명 : %s\n종류 : %s파일\n파일 크기 : %d%s", file.getName(), fileType,  fileSize, fileSizeType);
		} else {
			System.out.println("파일이 없습니다.");
		}
		
		
	}

}
