package com.test.question.q23;

public class Q006 {
	public static void main(String[] args) {

		for (int a=2; a<=6; a+=4) {
			for (int i=1; i<=9; i++) {
				for (int j=a; j<=a+3; j++) {
					System.out.printf("%d x %d = %d\t", j, i, j*i);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		
		
		
	}

}
