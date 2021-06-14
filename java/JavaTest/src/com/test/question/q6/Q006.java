package com.test.question.q6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("문자 : ");
		int word = reader.read();
		
		//A = 65, a =97 
		
		if (word >= 97 && word < 123) {
			System.out.println("결과 : " + (char)(word -32));
		} else if (word >= 65 && word < 91) {
			System.out.println("결과 : " + (char)(word + 32));
		} else {
			System.out.println("올바르게 입력해 주세요.");
		}
		
	}

}
