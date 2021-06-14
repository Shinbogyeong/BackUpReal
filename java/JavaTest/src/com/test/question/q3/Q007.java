package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		
		System.out.println("섭씨(`c) :");
		int temperature = Integer.parseInt(reader.readLine());
		
		System.out.printf("섭씨 %d`C는 화씨 %.1f`F입니다."	, temperature, (double)(temperature * 1.8 +32));
		
		
	}

}
