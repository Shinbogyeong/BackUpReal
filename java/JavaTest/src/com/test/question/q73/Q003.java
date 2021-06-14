package com.test.question.q73;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Q003 {
	
	public final static String DATA;
	
	static {
		DATA = "C:\\Users\\신보경\\Desktop\\파일_입출력_문제\\성적.dat";
	}
	
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader reader = new BufferedReader (new FileReader(DATA));
			
			String line = "";
			
			ArrayList<String> passName = new ArrayList<String>();
			ArrayList<String> nonpassName = new ArrayList<String>();
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				int kor = Integer.parseInt(temp[1]);
				int eng = Integer.parseInt(temp[2]);
				int math = Integer.parseInt(temp[3]);
				
				if((kor + eng + math) / 3 >= 60) {
					passName.add(temp[0]);
				} else {
					nonpassName.add(temp[0]);
				}
				
			}//while
			
			reader.close();
			
			System.out.println("[합격자]");
			for(String name : passName) {
				System.out.println(name);
			}
			
			System.out.println("[불합격자]");
			for(String name : nonpassName) {
				System.out.println(name);
			}		
				
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
