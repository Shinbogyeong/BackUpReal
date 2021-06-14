package com.test.question.q5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q004 {	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//입력 받을 값
		System.out.println("남자 이름 :");
		String boy_name = reader.readLine();
		
		System.out.println("여자 이름 : ");
		String girl_name = reader.readLine();
		
		System.out.println("만난날(년) : ");
		int meet_year = Integer.parseInt(reader.readLine()); 
		
		System.out.println("만난날(월) : ");
		int meet_month = Integer.parseInt(reader.readLine()); 
				
		System.out.println("만난날(일) : ");
		int meet_date = Integer.parseInt(reader.readLine()); 
		
		
		//출력 할 값
		Calendar meet = Calendar.getInstance();
		
		meet.set(meet_year, meet_month - 1, meet_date);
		
		System.out.printf("%tF", meet);
		
		System.out.printf("'%s'과(와) '%s'의 기념일\n", boy_name, girl_name);
		
		meet.add(Calendar.DATE, 100);
		System.out.printf("100일 : %tF\n", meet);
		
		meet.add(Calendar.DATE, 100);
		System.out.printf("200일 : %tF\n", meet);
		
		meet.add(Calendar.DATE, 100);
		System.out.printf("300일 : %tF\n", meet);
		
		meet.add(Calendar.DATE, 200);
		System.out.printf("500일 : %tF\n", meet);
		
		meet.add(Calendar.DATE, 500);
		System.out.printf("1000일 : %tF\n", meet);
		
		
	}

}
