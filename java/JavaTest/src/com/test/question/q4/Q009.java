package com.test.question.q4;

public class Q009 {
	public static void main(String[] args) {
		
		sum(10);
		
		sum(10, 20);
		
		sum(10, 20, 30);
		
	}//main	

	public static void sum(int a) {
		System.out.printf("%d = %d\n", a, a);
	}
	
	public static void sum(int a, int b) {
		System.out.printf("%d + %d = %d\n", a, b, a + b);
	}
	
	public static void sum(int a, int b, int c) {
		System.out.printf("%d + %d + %d = %d\n", a, b, c, a + b + c);
	}
	
	public static void sum(int a, int b, int c, int d) {
		System.out.printf("%d + %d + %d + %d  = %d", a, b, c, d, a + b + c + d );
	}
	
	public static void sum(int a, int b, int c, int d, int e) {
		System.out.printf("%d + %d + %d + %d + %d = %d", a, b, c, d, e, a + b + c + d + e);
	}
	
}
