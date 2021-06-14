package com.test.question.q6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("년 : ");
		int year = Integer.parseInt(reader.readLine());

		System.out.println("월 : ");
		int month = Integer.parseInt(reader.readLine());

		System.out.println("일 : ");
		int date = Integer.parseInt(reader.readLine());
		
		
		
		Calendar now = Calendar.getInstance();
		
		now.set(year, month - 1, date);
		
		if (now.get(Calendar.DAY_OF_WEEK) == 7 || now.get(Calendar.DAY_OF_WEEK) == 1) {
			System.out.println("입력하신 날짜는 '휴일'입니다.\n결과가 없습니다.");
		} else if (now.get(Calendar.DAY_OF_WEEK) == 2) {
			now.add(Calendar.DATE, 5);
			System.out.printf("입력하신 날짜는 '평일'입니다.\n해당 주의 토요일로 이동합니다.\n이동한 날짜는 '%tF'입니다."
						,now);
		} else if (now.get(Calendar.DAY_OF_WEEK) == 3) {
			now.add(Calendar.DATE, 4);
			System.out.printf("입력하신 날짜는 '평일'입니다.\n해당 주의 토요일로 이동합니다.\n이동한 날짜는 '%tF'입니다."
						,now);
		} else if (now.get(Calendar.DAY_OF_WEEK) == 4) {
			now.add(Calendar.DATE, 3);
			System.out.printf("입력하신 날짜는 '평일'입니다.\n해당 주의 토요일로 이동합니다.\n이동한 날짜는 '%tF'입니다."
						,now);
		} else if (now.get(Calendar.DAY_OF_WEEK) == 5) {
			now.add(Calendar.DATE, 2);
			System.out.printf("입력하신 날짜는 '평일'입니다.\n해당 주의 토요일로 이동합니다.\n이동한 날짜는 '%tF'입니다."
						,now);
		} else if (now.get(Calendar.DAY_OF_WEEK) == 6) {
			now.add(Calendar.DATE, 1);
			System.out.printf("입력하신 날짜는 '평일'입니다.\n해당 주의 토요일로 이동합니다.\n이동한 날짜는 '%tF'입니다."
						,now);
		}
	}
}
