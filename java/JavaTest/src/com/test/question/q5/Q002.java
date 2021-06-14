package com.test.question.q5;

import java.util.Calendar;

public class Q002 {
	public static void main(String[] args) {
		
		//오늘 태어난 아이의 백일과 첫돌이 언제인지 출력하시오
		
		Calendar birthday = Calendar.getInstance();
		
		//오늘(시각) + 100일(시간) -> add()
		birthday.add(Calendar.DATE, 100 - 1);//기준점을 오늘 포함하면 -1 
		
		System.out.printf("백일 : %tF\n", birthday);
		
		//초기화
		birthday = Calendar.getInstance();
				
		//첫돌 ***월, 년 -> 산술연산은 반드시 add()
		birthday.add(Calendar.YEAR, 1);
		System.out.printf("첫돌 : %tF\n", birthday);
		
		
	}//main

}
