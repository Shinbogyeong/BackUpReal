package com.test.question.q25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("이메일 :");
		String txt = reader.readLine();
		
		int index = txt.indexOf('@');
		String id = txt.substring(0, index);
		String mail = txt.substring(index + 1);
		
		System.out.printf("아이디 : %s\n도메일 : %s", id, mail);
	}
}
