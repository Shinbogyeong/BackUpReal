package com.test.question.q6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//추가조건
public class Q007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("숫자 입력 :");
		int num1 = Integer.parseInt(reader.readLine());
				
		System.out.println("숫자 입력 :");
		int num2 = Integer.parseInt(reader.readLine());

		System.out.println("숫자 입력 :");
		int num3 = Integer.parseInt(reader.readLine());

		System.out.println("숫자 입력 :");
		int num4 = Integer.parseInt(reader.readLine());

		System.out.println("숫자 입력 :");
		int num5 = Integer.parseInt(reader.readLine());

		int odd = 0; //홀
		int even = 0; //짝
		
		if (num1 % 2 == 1) {
			odd += 1;
		} else {
			even += 1;
		}
		

		if (num2 % 2 == 1) {
			odd += 1;
		} else {
			even += 1;
		}

		
		if (num3 % 2 == 1) {
			odd += 1;
		} else {
			even += 1;
		}

		
		if (num4 % 2 == 1) {
			odd += 1;
		} else {
			even += 1;
		}

		
		if (num5 % 2 == 1) {
			odd += 1;
		} else {
			even += 1;
		}
		
		System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다."
						, even, odd);
		if (odd > even) {
			System.out.printf("\n 홀수가 짝수보다 %d개 많습니다.", odd - even);
		} else {
			System.out.printf("\n 짝수가 홀수보다 %d개 많습니다.", even - odd);
		}
		
	}

}
