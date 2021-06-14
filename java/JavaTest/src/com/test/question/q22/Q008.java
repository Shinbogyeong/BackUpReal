package com.test.question.q22;

public class Q008 {
	public static void main(String[] args) {
		
		int year = 2021;
		int month = 4;
		int date = 9;
		int lastday = 0;
		
		int sum = 0;
		
		//1, 3, 5, 7, 8, 10, 12 =31일 217
		//2= 28일
		//4, 6, 9, 11 = 30일 120
		
		sum = (year - 1) * 365;
		
		for (int i= month-1; i>0; i--) {
			switch (i) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					sum += 31;
					System.out.println(sum);
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					sum += 30;
					System.out.println(sum);
					break;
				case 2:
					sum += 28;
					System.out.println(sum);
					break;
			}
		}
		
		sum += date;
		
		System.out.printf("%d년 %d월 %d일은 %,d일째 되는 날입니다.", year, month, date, sum);
		 
		
		//요일
		
		String day = "";
		switch (sum % 7) {
		case 0 : day ="일";
			break;
		case 1 : day = "월";
			break;
		case 2 : day = "화";
			break;
		case 3 : day = "수";
			break;
		case 4 : day = "목";
			break;
		case 5 : day = "금";
			break;
		case 6 : day = "토";
		}
		System.out.printf("오늘은 %s요일 입니다.", day);
			
		}
	}

