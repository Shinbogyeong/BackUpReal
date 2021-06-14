package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("국어 :");
		int kor = Integer.parseInt(reader.readLine());
		
		System.out.println("영어 :");
		int eng = Integer.parseInt(reader.readLine());
		
		System.out.println("수학 :");
		int math = Integer.parseInt(reader.readLine());
		
		 System.out.printf("%s입니다.", test(kor, eng, math) );
	}

	private static String test(int kor, int eng, int math) {
		
		String result = ((kor + eng + math) / 3 >= 60) && (kor > 40 && eng > 40 && math > 40)? "합격" : "불합격";
		
//		String cutLine = (kor < 40 || eng < 40 || math <= 40) ? "과락입니다." : "과락이 아닙니다.";
//		System.out.println(cutLine);
		
		return result;
		
	}

	
	
	

}
