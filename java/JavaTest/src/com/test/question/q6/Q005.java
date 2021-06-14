package com.test.question.q6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("첫번째 숫자 :");
		int num1 = Integer.parseInt(reader.readLine());
		
		System.out.println("두번째 숫자 :");
		int num2 = Integer.parseInt(reader.readLine());
		
		System.out.println("연산자 : ");
		char operator = reader.readLine().charAt(0);
				
		
		if (operator == '*') {
			System.out.printf("%d * %d = %d", num1, num2, num1 * num2);
		} else if (operator == '/') {
			System.out.printf("%d / %d = %.1f", num1, num2, (double)num1 / num2);
		} else if (operator == '%') {
			System.out.printf("%d %% %d = %d", num1, num2, num1 % num2);
		} else if (operator == '+') {
			System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
		} else if (operator == '-') {
			System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
		} else {
			System.out.println("연산자를 올바르게 입력해 주세요");
		}
		 
		
		
		
	}

}
