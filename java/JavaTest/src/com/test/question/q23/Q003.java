package com.test.question.q23;

public class Q003 {
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<(4-i); j++) {
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
