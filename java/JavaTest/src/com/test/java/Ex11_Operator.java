package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11_Operator {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//연산자, Operator
		// - 피 연산자(operator)를 대상으로 미리 정해진 연산(계산, 행동)을 한 후에 결과값을 반환하는 구성요소
		// - 주로 기호를 사용해서 표현
		
		//1. 문장, Statemant
		//2. 표현식, Expression :문장에서 독립적으로 나올수 있는 놈
		//3. 연산자
		//4. 피연산자
		//5. 연산자 우선 순위
		//6. 연산방향
		
		//int a = 10;
		//int a1;
		//10;
		//a=10;
		
		//자바의 연산자 종류
		//1. 산술 연산자
		// - +, -, *, /, %(mod, 나머지)
		// - 2항 연산자(피연산자가 2개)
		// - 피 연산자를 숫자로 가진다. (정수, 실수)
		
		int a = 10;
		int b = 3;
		
		System.out.println(a + b);  //13
		System.out.println(a - b);	//7
		System.out.println(a * b);	//30
		System.out.println(a / b);	//3(몫) -> 정수 / 정수
		System.out.println(a % b);	//1
		System.out.println(10.0 / 3.0); //-> 실수 / 실수
		
		//나누기 연산자(이거말고 아래 별표 외워)
		// - 정수 / 정수 = 정수
		// - 정수 / 실수 = 실수
		// - 실수 / 정수 = 실수
		// - 실수 / 실수 = 실수
		System.out.println(10 / 3);		//3
		System.out.println(10 / 3.0);	//3.3333333333333335
		System.out.println(10.0 / 3);	//3.3333333333333335
		System.out.println(10.0 / 3.0);	//3.3333333333333335
		
		System.out.println(a / (double)b);	//3.3333333333333335
		System.out.println((double)a / b);	//3.3333333333333335
		
		
		//******* 모든 산술 연산의 결과는 항상 자료형이 두 피연산자 중 더 큰 자료형으로 반환된다.
		// 1. + : 오버플로우 신경 쓸것
		// 2. - : 오버플로우 신경 쓸것
		// 3. + : 오버플로우 더욱 신경 쓸것
		// 4. / : 오버플로우 발생 X, 소수 이하를 남길지 말지?
		// 5. % : X
		System.out.println(10 / 3);		//int / int =  int
		System.out.println(10 / 3.0);	//int / double = double
		System.out.println(10.0 / 3);	//double / int = double
		System.out.println(10.0 / 3.0);	//double / double = double
		
		int money1 = 2000000000;
		int money2 = 1500000000;
		
		System.out.println("잔액: " + (money1 + money2)); //int + int = int //Overflow 발생
		System.out.println("잔액: " + (money1 + (long)money2)); // int + long = long
		
		System.out.println();
		System.out.println();
		System.out.println();


		//2. 비교 연산자
		// - >, >=, <, <=, ==(같다, equal	), !=(다르다. A<>B, not equal)
		// - 2항 연산자
		// - 피연산자는 모두 숫자형
		// - 연산의 결과가 항상 boolean(true, flase)
		// - 문자열의 비교는 동등 비교만 가능하고, 연산자(==, !=) 사용이 불가능하고 대신,. equals()메소도를 사용해야한다.(****)
		
		a = 10;
		b = 5;
		
		System.out.println(a > b);	//true
		System.out.println(a >= b);	//true
		System.out.println(a < b);	//false
		System.out.println(a <= b);	//false
		System.out.println(a == b);	//false
		System.out.println(a != b); //true
		
		System.out.println();
		System.out.println();
		
		
		//요구사항] num이 양수입니까?
		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		//ctrl + shift + o
//		
//		System.out.println("숫자입력: ");
//		int num = Integer.parseInt(reader.readLine());
//		System.out.println("결과: " + (num > 0));
		
		String str1 = "홍길동";
		String str2 = "홍길동";
		String str3 = "아무개";
		String str4 = "홍";
		str4 = str4 + "길동";
		
		System.out.println(str4);//"홍길동"
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str1 == str4);//false
		System.out.println();
		
		System.out.println(str1.equals(str2));//true
		System.out.println(str1.equals(str4));//true
		
		System.out.println();
		System.out.println();


		//3. 논리 연산자 p114
		// - &&(and), ||(or), !(not)
		// - 2항 연산자
		// - 피연산자를 반드시 boolean을 가진다.
		// - 연산의 결과를 boolean으로 반환한다. 
		// - 피연산자를 가지고 특정한 규칙에 따라 연산의 결과를 반환한다.
		
		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = true;
		boolean b4 = false;
	
		
		System.out.println(b1 && b2); //false
		System.out.println(b1 && b3); //true
		System.out.println(b2 && b4); //false
		
	
		System.out.println(b1 || b2); //true
		System.out.println(b1 || b3); //true
		System.out.println(b2 || b4); //false
		
		//소개팅] 서울, 긴머리
		String address = "서울";
		String hair = "긴머리";
		
		System.out.println(address.equals("서울") && hair.equals("긴머리"));
		System.out.println(address.equals("서울") || hair.equals("긴머리"));
		
		//1항 연산자 : 피연산자가 1개
		System.out.println(!true);
		System.out.println(!false);
		
		boolean flag = true;
		System.out.println(!flag);
		System.out.println();
		
		
		//4. 대입 연산자, 할당 연산자
		// - = 
		// - +=, -=, *=, /=, %/ : 복합 대입 연산자
		// - Lvalue = Rvalue
		
		int n = 10;
		n = n + 1; //누적
		System.out.println(n);// 11
		
		n += 1;
		System.out.println(n);
		
		n = n - 1;
		n -= 1;
		
		n = n * 2;
		n *= 2;
		
		n = n / 2;
		n /= 2;
		
		n = n % 2;
		n %= 2;
		
		
		
		//5. 증감 연산자
		// - ++, --
		// - 1항 연산자 
		// - 피연산자로 숫자
		// - 피연산자의 값을 +1, -1 누적시키는 연산자
		// - 연산자의 결과가 경우에 따라 달라진다.
		// 		- 연산자의 위치와 피연산자의 위치를 바꿀 수 있다.
		//			a. ++n : 전위(전치) 연산자. 연산자 우선 순위가 가장 높다.
		//			c. n++ : 후위(후치) 연산자. 연산자 우선 순위가 가장 낮다.
		
		n = 10;
		
		n = n + 1;  //11
		n += 1;		//12
		++n;		//13
		
		n = n - 1;
		n -= 1;
		--n;
		
		System.out.println(n);
		
		
		//** 연산자 우선순위
		// - 연산자들을 실행하는 순서
		// - 증감 연산자 > 산술 연산자 > 비교 연산자 > 논리 연산자 > 대입 연산자 //전위 ++n
		// - 산술 연산자 > 비교 연산자 > 논리 연산자> 대입 연산자 >증감 연산자 	//후위 n++
		
		boolean result = 10 > 5 + 1 && 8 < 2 * 3;
//		boolean result = 10 > 6 && 8 < 6;
//		boolean result = true &&  false;
//		boolean result = false;
		
		
		System.out.println(result);
		
		//증감 연산자는 다른 연산자와 같은 문장에 작성하지 말것!!
		int num = 10;
		int sum = 0;
		
		//sum = 20 + ++num;
		++num;
		sum = 20 + num;
		System.out.println(sum);// 21
		
		
		num = 10;
		sum = 0;
		
		//sum = 20 + num++;
		sum = 20 + num;
		num++;
		System.out.println(sum); //30
		System.out.println(num); //11
		
		
		
		//6. 조건 연산자
		// - A ? B : C
		// - 3항연산자
		// - A : 조건(boolean)
		// - B, C : 상수, 변수, 연산식 -> 값 -> 연산의 결과값
		// - B와 C는 반드시 자요형이 동일해야 한다.
		
		
		System.out.println(1 + 2);
		System.out.println(true ? "참" : "거짓");
		System.out.println(false ? "참" : "거짓");
		
	
		//사이트 ] 회원가입 -> 19세 이상 ~ 60세 미만 > 입력하신 나이 25세는 회원가입 성공입니다.
		//										입력하신 나이 12세는 회원가입 성공입니다.
				
		int age = 25;//사용자 입력
		
		String result1 = ((age >= 19) && (age < 60)) ? "성공" : "실패";
		System.out.printf("입력하신 나이 %d세는 회원가입 %s입니다.\n", age, result1);
		
		
	}

}

















