package com.test.java;

public class Ex14_Method {

	public static void main(String[] args) {
	
		//public static void main hello()
		// - hello : 정의/호출에 사용됨
		
		//소괄호 ? = 메소드 인자 리스트
		// - 파라미터(parameter)
		// - 인자(Argument)
		// - 매개변수
		// - 가인자/실인자
		
		// - 메소드 호출 시 전달하고자 하는 데이터 전송하는 역할
		// - (소극적)다형성 구현
		
		hello();
		hello2();
		//hello25(); //누구?? 메소드명 만들기도 힘들다;;; 의미있게
		
		
		//The method hi(String)is not applicable for the arguments ()
		hi("홍길동");// 실인자, Actual Argument
		hi("홍길동");
		hi("홍길동");
		
		//public static void bye(String name, int age) {
		bye("신보경", 25);
		bye("뽀로로", 5);
		
		//매개변수 사용 시 주의점!!!
		// - 가인자와 실인자의 개수가 동일해야 한다.
		// - 가인자와 실인자의 자료형이 동일해야 한다.
		// - 형변환이 가능하면 자료형이 동일하지 않아도 된다.
				
//		hi("홍길동");
//		hi("홍길동", "아무개");		
//		hi(100);
		
		byte b = 10;
		bye("홍길동", b); //bye(String name, int age);
		bye("홍길동", (int)b); //암기적 형변환 발생
		
		
		//2개 숫자 입력 -> 연산과정 출력
		
		int n1 = 10;
		int n2 = 20;
		
		System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
		
		n1 = 5;
		n2 = 9;
		
		System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
		
		n1 = 22;
		n2 = 123;
		
		System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
		
		add(n1, n2);
	
		n1 = 111;
		n2 = 222;
		
		add(n1, n2);
		
		n1 = 1;
		n2 = 2;
		
		add(n1, n2);
		
	}//main
	
	public static void add(int n1, int n2) {
//		int n1 = 10;
//		int n2 = 20;
		System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
	}
	

	// '홍길동'에게 인사를 하는 메소드를 구현하시오.
	public static void hello(){
		System.out.println("홍길동님, 안녕하세요.");
	}
	
	// '아무개'에게도 인사를 하는 메소드를 구현하시오.
	public static void hello2() {
		System.out.println("아무개님, 안녕하세요.");
	}
	
	// 우리반 30명에세 각각 인사를 하는 메소드를 구현하시오.
	// -> 메소드를 30개 추가 선언하기
	
	// 대한민국 국민들에게 각각 인사를 하는 메소드를 구현하시오.
	// 전세계 모든 사람들에게 각각 인사를 하는 메소드를 구현하시오. -> 78억개
	
	public static void hello3() {
		System.out.println("신보경님, 안녕하세요.");
	}
	
	public static void hello4() {
		System.out.println("신시내님, 안녕하세요.");
	}
	
	
	public static void hi(String name ) {//String name -> 매개변수, 가인자, Formal Argument
		
//		String name = "홍길동";
		
		System.out.printf("%s님, 안녕하세요.\n", name);
	}
	
	
	
	public static void bye(String name, int age) {
		
		//인삿말을 나이에 따라 다르게...
		//10세이상 -> 안녕하세요.
		//10세미만 -> 안녕~
		
		String result = age >= 10 ? "안녕하세요." : "안녕~";
		System.out.printf("%s님 %s\n", name, result);
	}
	
	
	
	public static void aaa(int num) {
		int a;
		//int a;
	}
	
	public static void bbb(int num) {
		int a;
	}
	
	
}















