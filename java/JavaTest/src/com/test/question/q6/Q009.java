package com.test.question.q6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q009 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		
		System.out.println("년도 입력 : ");
		int year = Integer.parseInt(reader.readLine());
		
		String leap = "";
		
		
		if (year % 4 != 0) {
			leap = "평년";
		} else if (year % 100 != 0) {
			leap = "윤년";
		} else if (year % 400 != 0) {
			leap = "평년";
		} else {
			leap = "윤년";
		}
		
		System.out.printf("%d년은 '%s'입니다.", year, leap);
		

		
	}

}
