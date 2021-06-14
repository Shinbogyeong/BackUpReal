package com.test.java;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Ex20_if {

	public static void main(String[] args) {
		//Ctrl + Shift + F 하면 정렬해 줌
		/*
		 
		 제어문
		 - 수많은 명령어들을 제어하는 도구
		 - 명령어들의 실행 순서 or 반복 등을 제어한다.
		 - 조건 제어, 반복 제어 , 분기 제어
		 
		 1. 조건문
		 	a. if
		 	b. switch
		 	
		 2. 반복문
		 	a. for
		 	b. while
		 	c. do while
		 	d. for
		 	
		 3. 분기문
		 	a. break
		 	b. continue
		 	c. goto(JDK1.5 폐지)
		 
		 
		 */
		//m1();
		//m2();
		m3();
		
	}//main

	private static void m3() {
		
		//조건식, Condition
		// - 조건식 반드시 boolean값을 가진다.
		// - 다른 언어는 조건식의 결과로 boolean이 아닌값을 가지기도 한다.
		// - 정수: 0(flase), 그 이외의 숫자(true), 1(true)
		// - 실수: 0.0(false), 그 이외의 숫자(true)
		// - 문자: \0(문자코드값(0), null문자)(false), 그 외의 모든 문자(true)
		// - 문자열: ""(빈문자열, false), "홍길동"(true)
		
//		int n = 10;
//		
//		if (n > 0) {
//			
//		}
		
	}

	private static void m2() {
		
		
		
		//입력 숫자 -> 짝수 or 홀수?
		int num = 2;
		
		if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		
		//나이 입력 > 우리가 원하는 나이대?
		// - 19세 이상 ~ 60세 미만
		
		int age = 25;
		
		//19 <= age < 60
		//true <= 60
		
		//중첨 if문 (Nested if statement)
		if (age >= 1 && age <= 140) {

			if (19 <= age && age < 60) {
				System.out.println("회원 가입 진행");
			} else {
				System.out.println("가입불가능..");
			}

		} else {
			System.out.println("나이가 올바르지 않습니다.");
		}
		
		
		
	}//m2

	private static void m1() {
		/*
		 
		 if문 
		 - 조건을 제시한 후 조건의 결과에 따라서 실행문을 실행할지 결정 제어
		 - 조건식의 결과는 반드시 boolean
		 
		 
			
		 
		 if (조건식){
		 	실행문;
		 	}
		 	
		 	 	
		 	
		 if (조건식){
		 	실행문;
		 	} else {
		 	실행문;
		 	}
		 	
		 	
		  if (조건식){
		 	실행문;
		 	} else if (조건식) {
		 	실행문
		 	} else if (조건식) {
		 	실행문
		 	} else if (조건식) {
		 	실행문
		 	} else if (조건식) {
		 	실행문;
		 	}
		 	
		 	
		 	if (조건식){
		 	실행문;
		 	} else if (조건식) {
		 	실행문
		 	} else {
		 	실행문
		 	
		 	
		 	if (조건식){
		 	실행문;
		 	}
		 	[else if (조건식) {
		 	실행문
		 	}] x N 
		 	else {
		 	실행문
		 	
		 	
		 */
		
		//1.
		if(true) {
			
		}
		
		//2.
		boolean flag = true;
		
		if(flag) {
			
		}
		
		//3.
		int num = 10;
		if(num > 0) {
			
		}
		
		//4. boolean값 리턴하는 같는 메소드 생성
		if(test()) {
			
		}
		
		
		
		
		int n = - 10;
		
		//n이 양수입니까?"
		if(n > 0) {
			System.out.println("양수입니다.");			
		}
		
		n = - 10;
		
		if(n > 0) {
			System.out.println("양수입니다.");			
		} else {
			System.out.println("양수가 아닙니다.");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		n = 10;
		if (n > 0) {
			System.out.println("양수입니다.");
		} else if (n < 0) {
			System.out.println("음수입니다.");
		} else if (n == 0) {
			System.out.println("0입니다.");
		}
		
		
		if (n > 0) {
			System.out.println("양수입니다.");
		} else if (n < 0) {
			System.out.println("음수입니다.");
		} else {
			System.out.println("0입니다.");
		}
		
		System.out.println("프로그램 종료");
		
		
		
		//기상 시각
		int hour = 7;
		
		if(hour < 8) {
			System.out.println("지하철을 타고갑니다.");
		} else {
			System.out.println("택시를 타고갑니다.");
		}
		
		
		if(hour < 8) {
			System.out.println("지하철을 타고갑니다.");
		} else if(hour < 9) { //8시 ~9시 기상
			System.out.println("택시를 타고갑니다.");
		} else { //9시 넘어시 기상
			System.out.println("결근한다.");
		}
		
	}//m1

	private static boolean test() {
		return false;
	}
	
	
	
	
	
	
}
