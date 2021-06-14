package com.test.question.q5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//입력 받을 값
		System.out.println("아빠 생일(년) : ");
		int dad_year = Integer.parseInt(reader.readLine());
		
		System.out.println("아빠 생일(월) : ");
		int dad_month = Integer.parseInt(reader.readLine());
		
		System.out.println("아빠 생일(일) : ");
		int dad_date = Integer.parseInt(reader.readLine());
		
		System.out.println("딸 생일(일) : ");
		int daughter_year = Integer.parseInt(reader.readLine());
		
		System.out.println("딸 생일(일) : ");
		int daughter_month = Integer.parseInt(reader.readLine());
		
		System.out.println("딸 생일(일) : ");
		int daughter_date = Integer.parseInt(reader.readLine());
		
		//출력 할 값
		
		Calendar dad = Calendar.getInstance();
		dad.set(dad_year, dad_month, dad_date);
		long dad_tick = dad.getTimeInMillis();
		
		Calendar daughter = Calendar.getInstance();
		daughter.set(daughter_year, daughter_month, daughter_date);
		long daughter_tick = daughter.getTimeInMillis();
		
				
		System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다."
					, (daughter_tick - dad_tick )/1000 / 60 / 60 /24);
		
	}

}
