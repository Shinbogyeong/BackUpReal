package com.test.question.q4;

public class Q010 {
	public static void main(String[] args) {
		
		position("홍길동");
		
		position("홍길동", "유재석");
		
		position("홍길동", "유재석", "박명수");
		
		position("홍길동", "유재석", "박명수", "정형돈");
		
		
	}//main
	
	public static void position(String name) {
	System.out.printf("사원: %s \n", name);
	System.out.println();
	}
	
	public static void position(String name, String name1) {
		System.out.printf("사원: %s \n대리: %s \n", name, name1);
		System.out.println();
		}
	
	public static void position(String name, String name1, String name2) {
		System.out.printf("사원: %s \n대리: %s \n과장: %s \n ", name, name1, name2 );
		System.out.println();
		}
	
	public static void position(String name, String name1, String name2, String name3) {
		System.out.printf("사원: %s \n대리: %s \n과장: %s \n부장: %s \n", name, name1, name2, name3);
		System.out.println();
		}

}
