package com.test.question.q22;

public class Q017 {
	public static void main(String[] args) {
		
		int num = 0;
		for (int i = 2; i<=100; i++) {
			
			for (int n = i; n>0; n--) {
				if(i % n ==0) {
					num ++;
				}
			}
			if(num < 3)  {
				System.out.printf("%d, ",i);
			}
			num = 0;
		}
		System.out.println("\b\b");
	}

}


