package com.test.question.q22;

public class Q015 {
	public static void main(String[] args) {
		
		int sum = 0;
		int n = 0;
		
		for(int i = 1; i<=100; i+=n) {
				System.out.printf("%d + ",i);
				sum = sum + i;
				n++;
		}
		
		System.out.printf("\b\b\b = %d", sum);
	}

}
