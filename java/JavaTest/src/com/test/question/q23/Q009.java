package com.test.question.q23;

public class Q009 {
	public static void main(String[] args) {
		
		int add =0;
		int sum =0;
		
		for(int i=1; i<=100; i+=add) {
			System.out.printf("%d +", i);
			++add;
			sum += i;
		}
		System.out.println("\b\b =" + sum);
		
		
		
		
	}

}
