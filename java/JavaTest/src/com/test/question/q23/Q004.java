package com.test.question.q23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("행의 갯수: ");
		int num = Integer.parseInt(reader.readLine());
		
		for(int i=0; i<num; i++) {
			for(int j = 0; j<i ; j++) {
				System.out.printf(" ");
			}
			System.out.println("*");
		}
	
		
		
	}
	
}
