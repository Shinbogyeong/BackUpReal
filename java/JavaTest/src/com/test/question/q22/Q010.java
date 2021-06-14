package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q010 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		String print = "";
		
		for(int i = 0; ;i++) {
			System.out.println("숫자:");
			int num = Integer.parseInt(reader.readLine());
			
			if(num % 2==0) {
				sum += num;	
				print += " + " + num;
			} else {
				sum -= num;
				print += " - " + num;
			}
			
			if (sum >= 100) {
				System.out.printf("%s = %d", print, sum);
				break;
			}
		}
	}



}
