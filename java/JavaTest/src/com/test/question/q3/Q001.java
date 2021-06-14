package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("태어난 년도 :");
		
//		String year = reader.readLine();
//		int iyear = Integer.parseInt(year);
		
		int iyear = Integer.parseInt(reader.readLine());
		int age = 2021 - iyear;
		
		System.out.printf("한국나이 : %d세\n", age + 1);
		
	}

}
