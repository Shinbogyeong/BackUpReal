package com.test.question.q6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//Alt + Shift + y 개행해는 법
public class Q004 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("근무 년수 :");
		int year = Integer.parseInt(reader.readLine());
		
		
		if (year >= 0 && year < 5) {
			System.out.printf("%d년차 초급 개발자입니다.\n당신은 앞으로 %d년 더 근무하면 중급 개발자이고, \n%d년 근무하면 고급 개발자가 됩니다."
							, year, 5 - year, 10 - year);
		} else if (year >= 5 && year < 10) {//year < 10 이렇게 하면 더 간편
			System.out.printf("%d년차 중급 개발자입니다.\n당신은 %d년전까지 초급 개발자였습니다. \n앞으로 %d년 더 근무하면 고급 개발자가 됩니다."
					, year, year - 5, 10 - year);
		}else {
			System.out.printf("%d년차 고급 개발자입니다.\n당신은 %d년전까지 초급 개발자였습니다.\n당신은 %d년전까지 중급 개발자였습니다."
					, year, year - 10, year - 5);
		}
	}

}
