package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q011 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("최대 숫자 :");
		int max = Integer.parseInt(reader.readLine());
		
		for(int i=1; i<=max; i++) {
			if (i % 3 == 1 || i % 3 == 2) {
				System.out.printf(" %d ", i);
			} else {
				System.out.printf(" 짝 ");
			}
			
		}
		
	}

}
