package com.test.question.q23;

public class Q002 {

	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			for (int j=0; j<4-i; j++) {
				System.out.printf(" ");
			}
			for (int j=0; j<=i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		
		
		
		
	}

}
