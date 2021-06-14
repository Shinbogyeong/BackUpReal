package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//		int sum = 0;
//		
//		System.out.println("시작 숫자:");
//		int start = Integer.parseInt(reader.readLine());
//		
//		System.out.println("마지막 숫자:");
//		int finish = Integer.parseInt(reader.readLine());
//		
//		for(int i=start; i<=finish; i++) {
//			if (i % 2 == 1) {
//				
//				sum += i;
//				
//				System.out.printf("%d",i);
//				
//				if(i==finish) {
//					
//					break;
//					
//				}
//				
//				System.out.printf(" - ");
//				
//			} else {
//				
//				sum -= i;
//
//				System.out.printf("%d",i);
//				
//				if(i==finish) {
//					
//					break;
//				}
//				
//				System.out.printf(" + ");
//				
//			}//esle
//		
//		}//for
//
//		System.out.printf(" = " + sum);
		
		//아래와 같이 출력하시오.
				//1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5
				
				int sum = 0;
				
				for (int i=1; i<=10; i++) {
					if (i % 2 == 1) {
						System.out.printf("%d - ", i);
						sum += i;
					} else {
						System.out.printf("%d + ", i);
						sum -= i;
					}
				}
				
				System.out.printf("\b\b\b = %d\n", sum);
	}
	
}
