package com.test.question.q6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {
	public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("문자 :");
		char word = (char) reader.read();
		
		
		if ((word == 'f') || (word == 'F')){
			System.out.println("Father");
		} else if ((word == 'm') || (word == 'M')){
			System.out.println("Mother");
		} else if ((word == 's') || (word == 'S')){
			System.out.println("Sister");
		} else if ((word == 'b') || (word == 'B')){
			System.out.println("Brother");
		} else {
			System.out.println("올바른 문자를 입력하시오.");
		}

	}
}
