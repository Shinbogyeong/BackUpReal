package com.test.question.q73;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Q001 {
	
	public final static String DATA;
	
	static {
		DATA ="C:\\Users\\신보경\\Desktop\\파일_입출력_문제\\이름수정.dat";
	}
	
	
	public static void main(String[] args) {
		
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DATA));
			
			String line ="";
			String result = "";
			
			String oldValue = "유재석";
			String newValue = "메뚜기";
			
			while((line = reader.readLine()) != null) {
				result += line.replace(oldValue, newValue) + "\r\n";
				
			}
			
			reader.close();
			
			System.out.println(result);
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\신보경\\Desktop\\파일_입출력_문제\\이름수정_변환.dat"));
			
			writer.close();
			
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");
			
			//list[i].renameTo(new File(Q001 + "\\" + fileName));
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
