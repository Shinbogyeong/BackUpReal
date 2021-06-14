package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
	
		System.out.println("숫자 :");
		int num = Integer.parseInt(reader.readLine());
		
		String oddNum = getNumber(num);
		
		System.out.printf("입력하신 숫자는 '%d'는(은) '%s'입니다. ", num, oddNum);
	}//main

	public static String getNumber(int num) {
		String oddNum = num % 2 == 0 ? "짝수" : "홀수"; 
		return oddNum;
	}
	
	
}
