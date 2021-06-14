package com.test.question.q25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("숫자 :");
		String num = reader.readLine();
		int sum = 0;
		
		
		System.out.print("결과: ");
		
		for(int i=0; i<num.length(); i++) {
			
			char c = num.charAt(i);
			//num1 = (int)num.charAt(i) -48;
			sum +=(c - 48);
			System.out.printf("%c + ", c);
		}
		System.out.printf("= %d", sum);
		
	}

}
