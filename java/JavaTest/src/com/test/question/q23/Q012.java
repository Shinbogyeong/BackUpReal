package com.test.question.q23;

public class Q012 {

	public static void main(String[] args) {
		
		for(int i=2; i<=100; i++) {
			int sum = 0;
			for (int j=1; j<i; j++) {
				if(i % j ==0) {
					sum += j;
				}
			}
			if (i == sum) {
				System.out.printf("%d = [", i);
				
				for (int j1=1; j1<i; j1++) {
					if(i % j1 ==0) {
						System.out.printf("%d,", j1);
					}
				}
				System.out.printf("\b]\n");
			}
			
		}
		
		
	}//main
}
