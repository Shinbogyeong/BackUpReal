package com.test.question.q73;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Q002 {
	
	public final static String DATA1;
	public final static String DATA2;
	
	static {
		DATA1 = "C:\\Users\\신보경\\Desktop\\파일_입출력_문제\\숫자.dat";
		DATA2 = "C:\\class\\java\\JavaTest\\dat\\숫자_변환.dat";
	}
	
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DATA1));
			
			
			String line ="";
			String result = "";
			
			
			while((line = reader.readLine()) != null) {
				line = line.replace("0", "영");
				line = line.replace("1", "일");
				line = line.replace("2", "이");
				line = line.replace("3", "삼");
				line = line.replace("4", "사");
				line = line.replace("5", "오");
				line = line.replace("6", "육");
				line = line.replace("7", "칠");
				line = line.replace("8", "팔");
				line = line.replace("9", "구");
				
				result += line + "\r\n";
				
			}//while
					
				
			
			reader.close();
			
			
			
			System.out.println(result);
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DATA2	));
			
			writer.write(result);
			
			writer.close();
			
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
		
		
	

}