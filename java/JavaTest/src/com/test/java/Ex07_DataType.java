package com.test.java;

public class Ex07_DataType {

	public static void main(String[] args) {
		
		//변수2 개 -> 두 변수의 + 과정을 출력
		//10 + 20 = 30
		int a = 10;
		int b = 20;
		System.out.println(a + "+" + b + "=" + a + b);
	
		System.out.println(a + "+" + b + "=" + (a + b));
		
		System.out.println();
		
		// - 숫자 + 숫자 : 1 + 2
		// - 문자열 + 문자열 : "사과" + "포도" = "사과포도" <-concat
		
		// - 숫자 + 문자열 : 1 +"사과" => "1" + "사과" = "1사과" 문자열
		// - 문자열 + 숫자 : "포도" + 2 = "포도2"
		
		//------------------------------------------------------------
		
		
		
		//"숫자 형태"의 데이터를 다룰 때 주의할 점
		//-> 100, "100"
		// - 숫자 형태의 데이터는
		// 1. 산술 연산의 대상인가?
		// 2. 산술 연산의 대상이 아닌가?
		
		//주민등록번호 > 숫자 > 앞자리 : 980211-1234567
		
		int jumin = 980211;
		System.out.println("주민번호: " + jumin);
				
		//주민등록번호는 숫자가 아니다!
		jumin = 020331;//8409
		System.out.println("주민번호: " + jumin);
		
		
		String jumin2 = "980211";
		System.out.println("주민번호: " + jumin2);
		
		jumin2 = "020331";
		System.out.println("주민번호: " + jumin2);
		

		//자바에서 숫자 상수 표기법(정수만 해당)
		//- 기수법 명시 가능
		// - 출력될때는 무조건 10진수로 출력된다.
		//1. 10진수
		//2. 8진수
		//3. 16진수
		//4. 2진수(X)
		
		int num = 10;// 소스(10) -> 10진수 표현
		System.out.println(num);
		
		 num = 010;// 소스(0XX) -> 8진수 표현
		System.out.println(num);
		
		num = 0x10;// 소스(0xXX) -> 16진수 표현
		System.out.println(num);
		
		
		
	}
}
