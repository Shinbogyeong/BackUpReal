package com.test.java.obj;

public class Ex52_enum {

	public static void main(String[] args) {
		
		//열거형, Enumeration
		// - 클래스의 일종(자료형)
		// - 열거값을 가지는 자료형 > 사용자가 임의의 값을 생성할 수 없고, 주어진 값들중 1개를 선택해서 사용 가능한 자료형
		
		
		//쇼핑몰] 의류 > 티셔츠 > 선택 > 색상 선택 > 빨강, 노랑, 파랑
		
		//색상을 선택하세요.
		String color = "yellow"; //주관식
		
		//Color c -> enum 변수
		//Color.빨강 -> enum 리터럴
		Color c = Color.빨강;
		
		
		//회사 업무
		//String 직급 = "";
		직급 s = 직급.사원;
		
		//녹색점: 멤버 변수
		//S: static
		//F: final
		System.out.println(Color.빨강); //static final 상수
		
		System.out.println(MyColor.BRUE);
		
		
	}//main
}

//class Color{
//	//멤버
//	public int a;
//	public void test() {
//		
//	}
//}

enum Color{
	//멤버
	// - 변수만(자료형, 값 X, 이름 O)
	빨강,
	노랑,
	파랑,
}


enum 직급{
	
	회장,
	사장,
	이사,
	전무,
	부장,
	과장,
	개리,
	주임,
	사원
}


class MyColor {
	public final static int RED = 0;
	public final static int BRUE = 1;
	public final static int YELLOW = 2;
}






















