package com.test.question.q5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q006 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("음식을 받기 원하는 시각");
		System.out.print("시 : ");
		int hours = Integer.parseInt(reader.readLine());			
		System.out.print("분 : ");
		int min = Integer.parseInt(reader.readLine());
		
		Calendar iwant = Calendar.getInstance();
		iwant.set(Calendar.HOUR_OF_DAY, hours);
		iwant.set(Calendar.MINUTE, min);
		
		//짜장면, 10분
		iwant.add(Calendar.MINUTE,-10);						
		System.out.printf("짜장면 : %d시 %d분\n"
				,iwant.get(Calendar.HOUR_OF_DAY)
				,iwant.get(Calendar.MINUTE));
		
		//치킨, 18분(-10)
		iwant.add(Calendar.MINUTE,-8);						
		System.out.printf("치킨 : %d시 %d분\n"
				,iwant.get(Calendar.HOUR_OF_DAY)
				,iwant.get(Calendar.MINUTE));
		
		//피자,25분(-18)
		iwant.add(Calendar.MINUTE,-7);						
		System.out.printf("피자 : %d시 %d분\n"
				,iwant.get(Calendar.HOUR_OF_DAY)
				,iwant.get(Calendar.MINUTE));
		
		
		
		
		
//		//Calendar사용했을 때	
//		
//		
//		//입력 받을 값
//		System.out.println("음식을 받기 원하는 시각\n 시 :");
//		int hours = Integer.parseInt(reader.readLine());
//		
//		System.out.println("분 :");
//		int minute = Integer.parseInt(reader.readLine());
//		
//		//food 음식받는 시각
//		Calendar food = Calendar.getInstance();
//		
//		food.set(Calendar.HOUR_OF_DAY, hours);
//		food.set(Calendar.MINUTE, minute);
//		
//		int JJa = 10;
//		int Chicken = 18;
//		int Pizza = 25;
//		
//		
//		//출력 할 값
//		System.out.printf("짜장면 : %02d시 %02d분\n"
//				, food.get(Calendar.MINUTE) > JJa ? food.get(Calendar.HOUR_OF_DAY) : food.get(Calendar.HOUR_OF_DAY) -1
//				, food.get(Calendar.MINUTE) > JJa ? food.get(Calendar.MINUTE) - JJa : 60 +food.get(Calendar.MINUTE) - JJa);
//		
//		
//		System.out.printf("치킨 : %02d시 %02d분\n"
//				, food.get(Calendar.MINUTE) > Chicken ? food.get(Calendar.HOUR_OF_DAY) : food.get(Calendar.HOUR_OF_DAY) -1
//						, food.get(Calendar.MINUTE) > Chicken ? food.get(Calendar.MINUTE) - Chicken : 60 +food.get(Calendar.MINUTE) - Chicken);
//		
//		
//		System.out.printf("피자 : %02d시 %02d분\n"
//				, food.get(Calendar.MINUTE) > Pizza ? food.get(Calendar.HOUR_OF_DAY) : food.get(Calendar.HOUR_OF_DAY) -1
//						, food.get(Calendar.MINUTE) > Pizza ? food.get(Calendar.MINUTE) - Pizza : 60 +food.get(Calendar.MINUTE) - Pizza);
//		

		
		//int 변수 사용했을 때
		
//		System.out.println("음식을 받기 원하는 시각\n 시 :");
//		int hours = Integer.parseInt(reader.readLine());
//		
//		System.out.println("분 :");
//		int minute = Integer.parseInt(reader.readLine());
//		
//		int JJa = 10;
//		int Chicken = 18;
//		int Pizza = 25;
//		
//		
//		int JJa_minute = minute > JJa ? minute - JJa : 60 + minute - JJa;
//		int JJa_hours = minute > JJa ? hours : hours - 1;
//		System.out.printf("짜장면 : %02d시 %02d분\n", JJa_hours, JJa_minute);
//		
//		int Chicken_minute = minute > Chicken ? minute - Chicken : 60 + minute - Chicken;
//		int Chicken_hours = minute > Chicken ? hours : hours - 1;
//		System.out.printf("치킨 : %02d시 %02d분\n", Chicken_hours, Chicken_minute);
//		
//		int Pizza_minute = minute > Pizza ? minute - Pizza : 60 + minute - Pizza;
//		int Pizza_hours = minute > Pizza ? hours : hours - 1;
//		System.out.printf("피자 : %02d시 %02d분\n", Pizza_hours, Pizza_minute);
//		
		
	
		
		
		
	}

}
