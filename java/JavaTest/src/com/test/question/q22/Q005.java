package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;

		System.out.println("시작할 숫자:");
		int start = Integer.parseInt(reader.readLine());
		System.out.println("마지막 숫자:");
		int finish = Integer.parseInt(reader.readLine());
		
		
		for(int i=start; i<=finish; i++) {
			
			System.out.printf("%d",i);
			
			sum += i;
			
			if(i==finish) {
				break;
			}else {
				System.out.printf(" + ");
			}
		}
		
		System.out.printf(" = " + sum);
		
		
//		for (int i = start; i <= end; i++) {
//	         
//	         sum += i;
//	         
//	         System.out.print(i);
//	         
//	         if (i <= end - 1) { // ( i < end)로 넣어도 됨
//	            System.out.print(" + ");
//	         }
//	         
//	         if (i == end) {
//	            System.out.print(" = ");
//	            System.out.print(sum);
//	         }
//	      }
		
	}

}
