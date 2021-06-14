package com.test.java;

public class Question01 {
	public static void main(String[] args) {
		/* 출력
		안녕하세요. 제 이름은 '홍길동'입니다.
		나이는 20살이고 남자입니다.
		저는 '서울시 강남구 역삼동'에 살고 있습니다.
		*/
	
		String name = "홍길동";
		int age = 20;
		String sex = "남자";
		String address = "서울시 강남구 역삼동";
		
		System.out.println("안녕하세요. 제 이름은 '" + name + "'입니다.");
		System.out.println("나이는 " + age + "살이고 " + sex+ "입니다.");
		System.out.println("저는 '" + address + "'에 살고 있습니다.");
	}

}
