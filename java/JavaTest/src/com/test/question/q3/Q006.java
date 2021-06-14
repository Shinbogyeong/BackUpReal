package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
//		System.out.println("문자 입력 : ");
//		int word = System.in.read();
//		System.out.printf("소문자 '%c'의 대문자는 '%c'입니다.", word, word - 32);
		
//		System.out.println("문자 입력: ");
//		String str = reader.readLine();
//		char word = str.charAt(0);
//		System.out.printf("소문자 '%c'의 대문자는 '%c'입니다.", word, word - 32);
		
		
//		int word = reader.read();
		
		System.out.println("문자 입력: ");
		char word = reader.readLine().charAt(0);
		System.out.printf("소문자 '%c'의 대문자는 '%c'입니다.", word, word -32);
			
	}

}
