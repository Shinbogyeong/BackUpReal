package com.test.java;

public class Ex17_Overloading {

	public static void main(String[] args) {
		
		//메소드 오버로딩, Method Overloading //면접 단골 질문
		//- 같은 이름의 메소드를 여러개 만드는 기술 -30점자리 대답
		//- 메소드가 인자 리스트의 형태를 다양하게 구성해서 동일한 메소드명을 가질 수 있게 하는 기술
		//- 프로그램 성능에 영향 못미침, 개발자 도움O
		
		
		//메소드 오버로딩 조건O
		//1. 인자의 갯수
		//2. 인자의 타입
		
		//메소드 오버로딩 조건X
		//1. 인자의 이름
		//2. 반환값 타입
		
		
		//메소드 선언하는 중..
		//1. public static void test(){};					//O
		//2. public static void test(){};					//X
		//3. public static void test(int n){};				//O
		//4. public static void test(int m){};				//X
		//5. public static void test(String n){};			//O
		//6. public static void test(int n, int m){};		//O
		//7. public static void test(int n, Sting s){};		//O
		//8. public static String test(int n){};			//XXXX
		
		//3.
		test(10);
		
		//9.
		//String result = test(10);
		
		//test()
		
	}//main
	
	public static void test() {
		System.out.println("딸기");
	}
	
//	public static void test() {
//		System.out.println("포도");
//	}
	
	public static void test(int n) {
		System.out.println("수박");
	}
	
	
	
 }
