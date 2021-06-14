package com.test.java.obj;


//프로그램 실행: 프로젝트 내의 모든 클래스 정의 읽기(인식단계, Class Loading) -> main() 메소드 실행

public class Ex29_Class {
	
	
	//푸로구램 시작점!!
	public static void main(String[] args) {
		
		//Ex29_Class.java
		/*
		 
		클래스, Class
		- 객체 지향 프로그래밍
		
		1. 절차 지향 프로그래밍
		 	- C
		 	
		2. 객체 지향 프로그래밍
			- C++, Java, C# 등등..
			
		3. 함수형 프로그래밍
			- F#, Kotlin, java(일부기술)
		 	
		클래스
		- 코드의 집합
		
		클래스 사용 이유
		1. 데이터 집합이 필요해서
		2. 행동 집합이 필요해서
		3. 데이터 + 행동 집합이 필요해서
		 
		 */
		
		//요구사항] 지도 -> 우리집 좌표 저장 + 관리
		
		//Case 1.
		// - 대량으로 관리하기가 힘들다.
		// - 물리적 구조가 집합이 아니다
		// - 식별자 관리하기가 힘들다.
		
		int x = 100;
		int y = 200;
		
		System.out.printf("우리집은 (%d,%d)에 위치 합니다.\n", x, y);
		
		//마트
		int x2 = 300;
		int y2 = 400;
		System.out.printf("마트는 (%d,%d)에 위치 합니다.\n", x2, y2);
		
		
		//case 2.
		
		//우리집
		int[] a1 = new int[2];
		a1[0] = 100;
		a1[1] = 200;
		System.out.printf("우리집은 (%d,%d)에 위치 합니다.\n", a1[0], a1[1]);
		
		//마트
		int[] a2 = new int[2];
		a2[0] = 300;
		a2[1] = 400;
		System.out.printf("마트는 (%d,%d)에 위치 합니다.\n", a2[0], a2[1]);
		
		
		int[][] alist = new int[2][2];
		
		alist[0][0] = 100;
		alist[0][1] = 200;
		
		alist[1][0] = 100;
		alist[1][1] = 200;
		
		int[][]	alist2 = new int[2][2];
		
		alist2[0] = a1;
		alist2[1] = a1;
		
		//마트의 y좌표값? > alist2[1][1]
		
		
		
		
		//질문(***********) >그림 그리면서 복습!!!!!!!!!
		//1. int a = 10;
		// - a의 자료형? >int
		
		//2. int[] a = new int[3];
		// - a의 자료형? > int[]
		// - a[0]의 자료형? > int
		
		//3. int[][] a = new int [3][3]
		// - a의 자료형? > int[][]
		// - a[0]의 자료형? > int[]
		// - a[0][0]의 자료형? > int
		
		
		//Case 3.
		// - 클래스 사용 > 객체 생성하기
		// - 물리적인 집합 > 제공 > 관리 용어
		// - 다량의 데이터 > 순차 접근 의미 > 좋지 않음(X)
		// - 의미 (가독성) > 같은 클래스로부터 만들어진 객체내의 변수는 이름이 동일하다. > 접근 편의성!!
		
		
		// 클래스명 클래스변수명 = new 클래스명();
		//자료형 변수명 = 객체생성자 생성자();
		//Point p1 = new Point();

		//String s1 = "홍길동";
		
		//int[] n1 = new int[2];
		//자료형 (참조변수, 주소값변수)!!**
		
		//참조형 > 클래스 heap에저장 stack에는 주소 저장
		//Point > 클래스
		//String > 클래스
		//int[] >클래스
		
		
		
		//자료형
		// - 데이터의 형식 + 길이를 정의해놓은 규칙
		
		//point(클래스)를 자료형이라고 부르는 이유?
		//1. 변수를 만들었으니까(1차원적인대답)
		//2.
		
		//point클래스의 객체(인스턴스)를 생성했습니다.
		//p1 = 집합(x,y)
		
		//우리집 좌표
		Point p1 = new Point();
		
		p1.x = 100;
		p1.y = 200;
		System.out.printf("우리집은 (%d,%d)에 위치 합니다.\n", p1.x, p1.y);
		
		//마트 좌표
		Point p2 = new Point();
		
		p2.x = 300;
		p2.y = 400;
		System.out.printf("마트는 (%d,%d)에 위치 합니다.\n", p2.x, p2.y);
		
		
		//상황1] 지도의 좌표를 저장하고 싶다.-> 선택? -> 클래스
		//상황2] 학생의 국어 점수를 저장하고 싶다. -> 선택?  ->클래스
		//상황3] 학생 정보를 저장하고 싶다.(학생 정보: 학생명, 키, 몸무게) -> 선택? -> 클래스
		
		//데이터 -> 딥합 ( 단위)
		//1. 배열
		// - 같은 자료형 + 같은 의미 
		//2. 클래스(=구조체)
		// - 다른 자료형(다른 의미) + 하나의 집합(각각의 다른 데이터가 결론적으로 하나의 목적을 가지고 있다.
		
		
		//int[] s1 = new int[3];
		//s1[0] = 170; //키
		//s1[1] = 70; //몸무게
		//s1[2] = "홍길동"; //이름
		
//		String[] s1 = new String[3];
//		s1[0] = "170"; //사용 -> 형변환(Integer.parseInt())
//		s1[1] = "70";
//		s1[2] = "홍길동"; //몇번재 방에 뭐가 들어있는지?? > 의미만 모르는게 아니고;; 자료형 알수업다.;;
		
		Student2 s1 = new Student2();
		
		//.연산자
		// - 멤버 접근 연산자
		//s1.name
		
		s1.name ="홍길동";
		s1.height = 180;
		s1.weight = 80;
		System.out.println(s1.name);
		System.out.println(s1.height);
		System.out.println(s1.weight);
		
	}//main

}//Ex29_Class

//	class Point{ //클래스 헤더 -> 식별자 + 규칙 정의
//		
//		//클래스 바디 -> rngusqn
//		
//		//클래스 멤버를 구현한다.(****)
//		// - 멤버 변수
//		// - 멤버 메소드
//	
//		//멤버 변수
//		int a;
//		
//		//멤버 메소드
//		public static void test() {
//			
//		}
//		
//	} //클래스 바디




//클랙
//1.클래스 선언하기(정의하기)
//2. 객체 생성하기
//3. 객체 사용하기

//설계도
class Point{
	
	public int x;
	public int y;
	
}

//학생 정보(학생 정보: 학생명, 키, 몸무게) -> 클래스 설계
class Student2 {
	
	//학생 정보를 구성하는 개별 데이터를 저장할 변수를 클래스 멤버로 선언한다.
	public String name;
	public int height;
	public int weight;
	
	
	
}













