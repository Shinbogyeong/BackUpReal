package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("첫번째 숫자:");
		int n1 = Integer.parseInt(reader.readLine());
		
		System.out.println("두번째 숫자:");
		int n2 = Integer.parseInt(reader.readLine());
		
		int result = add(n1, n2);
		System.out.println(result);
		
		result = add(n1, n1);
		System.out.println(result);
		System.out.println();
		
		
		result = subtract(n1,n2);
		System.out.println(result);
		System.out.println();
		
		
		result = multiply(n1,n2);
		System.out.println(result);
		
		result = multiply(n1,n1);
		System.out.println(result);
		System.out.println();
		
		
		
		double result2 = divide(n1,n2);
		System.out.printf("%.1f", result2);
		System.out.println();
		
		result = mod(n1,n2);
		System.out.println(result);
		System.out.println();
	}//main
	
	public static int add(int n1, int n2) {
		System.out.printf("%d + %d = ", n1, n2);
		return n1 + n2;
	}

	public static int subtract(int n1, int n2) {
		System.out.printf("%d - %d = ", n1, n2);
		return n1 - n2;
	}
	public static int multiply(int n1, int n2) {
		System.out.printf("%d * %d = ", n1, n2);
		return n1 * n2;
	}
	
	public static double divide(int n1, int n2) {
		System.out.printf("%d / %d = ", n1, n2);
		return (double)n1 / n2;
	}
	
	public static int mod(int n1, int n2) {
		System.out.printf("%d %% %d = ", n1, n2);
		return n1 % n2;
	}
}
