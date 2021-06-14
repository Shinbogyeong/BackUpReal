package com.test.question.q22;

public class Q018 {
	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 1; i<=100; i++) {
			for(int n=i-1; n>0; n--) {
				if(i % n == 0) {
					sum = sum + n;
				}
			}
			
			if(i == sum) {//완전수

				System.out.printf("%d =[", i);
				for(int i1=1; i1<sum; i1++) {
					if (sum % i1 == 0) {
						System.out.printf("%d,", i1);
					}
				}
				System.out.println("\b]");
			}
			sum = 0;
			
		}
		
		
		
		
	}

}
