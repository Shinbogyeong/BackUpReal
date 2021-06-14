package com.test.java;

import java.io.PrintStream;

public class Ex18_Recursive {//이름바꾸는 법 파일 누르고 f2로 이름바꾸기

	public static void main(String[] args) {	
		
		//재귀 메소드, Recursive Method
		//- 메소드가 자신의 구현부에서(body) 자신을 호출하는 구문을 가지는 메소드
		//- 자기가 자기를 호출하는 메소드
	
		//test();
		
		
		//팩토리얼
		// 4! = 4 X 3 X 2 X !
		// 4! = 24
		
		int n = 4;
		
		int result = factorial(n);
		
		PrintStream printf = System.out.printf("%d! = $d\n", n, result);
		
		
		
	}//main
	
	public static int factorial(int n) {
		int temp = (n == 1 ) ? 1 : n * factorial(n-1);
		return temp;
	}

	//test() 메소드의 호출 횟수 : 무한대
	public static void test() {
		
		//StackOverflowError - 메모리가 꽉차서 더이상 아무것도 못합니다...
		
		System.out.println("테스트입니다."); 
		
		test();//**** 
	}
	
}













