package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.io.BufferedReader;// 창고에서 도구를 가져와 사용하겠습니다.> 클래스 임포트
//import java.io.InputStreamReader;

//import java.io.*;// *: wild card - all

//class 임포트 :ctrl + shift + o

public class Ex10_Input {

	public static void main(String[] args) throws IOException {
		
		//BufferedReader 클래스
		
		//System.out.println("문자 입력: ");
		
		int a = 10;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// reader: 키보드 입력을 받을 수 있는 도구
		
		//int data = reader.read(); //사용 안함
		//System.out.println(data);	
		
		//이클립스 주석 단축기
		// - 단일라인: Ctrl + /
		// - 다중라인: Ctrl + Shift + /
		// 			Ctrl + Shirt + \
		
		//String data = reader.readLine();//입력한 라인 전체를 반환한다.(**************)
//		System.out.println(data);
		
		//요구사항] 이름 입력 > 인사하시오.
//		System.out.println("이름 입력: ");
//		String name = reader.readLine();
//		System.out.printf("안녕하세요. %s님\n", name);
		
		

		
		//요구사항] 태어난 년도를 입력받아 나이를 출력하시오
//		System.out.println("생년 입력: ");
//		String year = reader.readLine();
//		int iyear = Integer.parseInt(year);//"1998"->1998
//		int age = 2021 - iyear;
//		System.out.printf("당신의 나이는 %d 세 입니다.\n", age);
		
		
		//문자열 -> 변환 -> 숫자
			
				//"문자열" -> byte : Byte.parseByte("문자열")
				//"문자열" -> short : Short.parseShort("문자열")
				//"문자열" -> long : Long.parseLong("문자열")
				//"문자열" -> float : Float.parseFloat("문자열")
				//"문자열" -> double : Double.parseDouble("문자열")
				//"문자열" -> boolean : Boolean.parseBoolean("문자열")
				//"문자열" -> char : X
				//"A" -> 'A' : "A".charAt(0)
		
		
		
		//요구사항] 숫자(정수)를 2개 입력받아 > + 연산을 하시오. > 연산 관정과 결과를 모두 출력하세요.
		
		System.out.println("첫번째 숫자: ");		
		String data1 = reader.readLine();		
		int first = Integer.parseInt(data1);
		
		
		System.out.println("두번째 숫자: ");		
		String data2 = reader.readLine();		
		int second = Integer.parseInt(data2);
		//int second = Intefer.parseInt(reader.readLine())
		
		System.out.printf("%d + %d = %d\n", first , second, first+ second);
		
		
		//1. 예제 확실히 반복
		//2. 문제 반복
		//3. 프로젝트
		//4. 개인 프로젝트(토이 프로젝트) -2~3주 1번씩 -> 10회 전후로.. -> 포트폴리오
		//프로젝트 : 3~4회 -> 포트폴리오 3~4개 프로젝트
		//프로젝트 : 3~4회 + 토이 프로젝트 -> 포트폴리오 3~4개 프로젝트 + 10여개 -> 13~14개 프로젝트
		
		
		//
		
		
	}
}





