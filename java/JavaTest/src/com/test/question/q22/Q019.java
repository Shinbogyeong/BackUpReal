package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q019 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("첫번째 숫자 :");
		int num1 = Integer.parseInt(reader.readLine());
		
		System.out.println("두번째 숫자 :");
		int num2 = Integer.parseInt(reader.readLine());
		
		
		System.out.printf("%d의 약수: ", num1);//첫번째 숫자의 약수
		for(int i=1; i<=num1; i++) {
			if(num1 % i == 0 && i < num1) {
				System.out.printf("%d, ", i) ;
			}else if(i == num1) {
				System.out.println(num1);
			}
		}
		
		
		System.out.printf("%d의 약수: ", num2);//두번째 숫자의 약수
		for(int i=1; i<=num2; i++) {
			if(num2 % i == 0 && i < num2) {
				System.out.printf("%d, ", i) ;
			}else if(i == num2) {
				System.out.println(num2);
			}
		}
		
		int small = num1 < num2? num1: num2;
		int big = num1 < num2? num2: num1;
		
		System.out.println("12와 8의 공약수 :");
		for(int i=1; i<=small; i++) {
			if(small % i == 0 && big % i == 0) {
				System.out.printf("%d, ",i);
			}
		}
		System.out.printf("\b\b");
		
	}

}
