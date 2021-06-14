package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyFile {

	
	
public boolean copy(String orgPath, String copyPath) {
		
		//파일 복사
		// - C:\\class\\java\\file\\JavaTest.zip
		// - C:\\class\\java\\file\\AAA\\JavaTest.zip
		
		File  org = new File(orgPath);
		File copy = new File(copyPath);
		
		//파일 복새 -> 바이트 단위 복사
		//1. FileInputStream : 파일의 내용을 바이트 단위 읽기
		//2. FileOuputStream : 파일의 내용을 바이트 단위 쓰기
		
		try {
			
			FileInputStream fis = new FileInputStream(org); //원본파일
			FileOutputStream fos = new FileOutputStream(copy); //복사 파일
			
			//버퍼(512KB ~ 1KB내외)
			byte[] buffer = new byte[1024];
			
			int length = 0;
			
			//복사
			while ((length = fis.read(buffer)) >0) {
				fos.write(buffer, 0, length);
			}
			return true;
			
			
		} catch (Exception e) {
			return false;
		}
		
		
	}

	
	
}
