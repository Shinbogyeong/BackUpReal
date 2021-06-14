package com.test.java;

public class Ex03_DataType {
	
	public static void main (String[] args) {
		
		/*
		 자료형, Data Type. p20~41, p55~73
		 - 데이터의 형태, 길이(범위) 등을 미리 정의하고 분류한 규칙(약속)
		 
		 자바 언어의 자료형**중요 기억**
		 1. 원시형(Primitive Type) = 값형(Value Type)
		 	a. 숫자형 (양수 + 음수)
		 		1. 정수형(-2^(n-1) ~ 2^(n-1) -1)
		 			- byte :  1byte(8bit) 2^8 = 256가지의 상태를 저장할 수 있다. 부호 포함하면 (-128~127)
		 			- short : 2byte(16bit)
		 			- int :   4byte(32bit)
		 			- long :  8byte(64bit)
		 			
		 			
		 		2. 실수형(부동 소수점) 부호+지수부+가수부
		 			- 범위 : -무한대 ~ +무한대(중요치 않음)// 지수부 때문에 엄청 커지기도 작아지기도 함, 하지만 가수부에서 표현하는 숫자는 한계적임(유효숫자)
		 			- float :  4byte(32bit) 범위?(X) -> 단정도형(정도: 정밀도, 정확도)
		 			- double : 8byte(64bit) 범위?(X) -> 배정도형(정밀도가 2배가 높음)
		 			
		 	b. 문자형
		 		- char : 2byte
		 		- 다른 언어(옛날 언어) : char(1byte)
		 		- 1byte -> 2byte(Unicode)
		 		
		 	c. 논리형
		 		- boolean : 1byte
		 		- 명제(참, 거짓) -> true, false
		 
		 
		 2. 참조형(Reference Type)
		 	-나중에 수업(2~3주차)
		 	
		 성적 처리 프로그램
		 - 데이터 : 학생 성적 -> 메모리 등록
		 
		 1. 내가 취급하려는 데이터를 선택
		 - 국어 점수
		 
		 2. 데이터의 형태와 길이를 선택
		 - 국어 점수 : 형태(숫자) + 길이(0~100)
		 
		 3. 자바의 자료형을 선택
		 - byte 선택 (-128 ~ 127)

		 4. 메모리에 3번의 자료형에 해당하는 공간을 얻어오기
		 - 변수
		 
		 5. 얻은 공간에 데이터 입출력하기
		 
		 
		 */
		
		//변수 생성(변수 선언) 자료형 변수명;
		byte kor;//문장(Statwment)- 명령어, ;(문장 종결자)
		
		
		//변수값 대입하기, 할당하기
		//-> 변수 초기화하기
		kor = 100;//대입연산자. 오른쪽의 데이터를 왼쪽의 공간에 넣어라!!
		
		
		//변수값 호출하기 -> 뭘할지? -> 화면 출력(println)
		//System.out.printlm(변수);
		//System.out.printlm(데이터);
		System.out.println(10);
		System.out.println(kor);
		
		
		
		
		//변수, Variable
		// - 메모리에 할당 받은 공간(공간의 이름)
		
		//1. 변수 선언하기
		byte eng;
		
		//2. 변수 초기화
		eng = 90;
		
		//3. 변수 사용하기
		System.out.println(eng);//똑같은 eng라는 표현을 출력했는데.. 한번은 90이 찍히고, 한번은 80이 찍혔다. > 변하는 수 > 변수
		
		//4. 변수 치환하기
		eng = 80;
		
		System.out.println(eng);
		
		System.out.println(111); //111-> 상수(변하지 않는 수) = 데이터 =리터럴(Literal)이라고 많이 부름
		System.out.println(111);
	
		
		//변수 선언하기
		byte n1; //선언
		n1 = 100; //초기화
		
		byte n2 = 120; //선언과 동시에 초기화
		
		byte n3;
		byte n4;
		
		byte n5, n6; //자료형 같을 때
		
		byte n7 =10, n8 =20, n9 =30;
		
		byte n10, n11=50, n12;
		
		
		//너비, 높이, 거리
		//byte width = 100, height = 50, distance = 70;
		
		//byte width =100;   //너비
		//byte height = 50;  //높이
		//byte distance =70; //거리
		
		byte width = 100,  //너비
			height = 50,   //높이
			distance = 70; //거리
		
		byte a = 10;
		byte b;
		
		//b = 20;
		b = a;// a변수의 데이터를 가져와서 b변수에 복사해라, *b나a 는 값이 저장된 공간임
		
		System.out.println(b);
		
		a = 5;
		
		System.out.println(b);//답은 10
		

		
		//자바는 대소문자를 구분한다.
		//수학 점수
		byte math;
		byte Mate;
		byte mAte;
		byte maTe;
		byte matE;
		
		//자바는 변수가 초기화되지 않은 상태에서 사용이 불가능하다.
		//The local variable size may not have been initialized
		//byte size;
		//size = 100;// ********
		//System.out.println(size);//
		
		
		//변수명 명명법
		//1. 영문자 + 숫자 + _ + &
		//2. 숫자로 시작 X
		//3. 예약어 사용 불가
		//4. 의미있게
		
		byte KoreanScore = 100;
		System.out.println(KoreanScore)
		
		//Ctrl + Space 자동완성기능 
		//이클립스에선 code assistance라고 불림
		//Visual Studio에선 인텔리센스라고 불림
		
		
		//식별자 명명법 패턴
		// - 많은 사람 + 오랜 시간 -> 이름 짓기 -> 경험 -> 패턴
		
		//1. 헝가리언 표기법
		//2. 파스칼 표기법
		//3. 캐멀 표기법
		//4. 스네이크 표기법
		//5. 케밥 표기법
		
		//헝가리언 표기법
		//- 식별자를 만들 때 식별자의 접두어로 해당 자료형을 표시하는 방법
		// 사용) 인터페이스 명
		//		- interface IHello{
		byte num;
		byte bnum;
		byte b_num;
		byte byte_num;


		//파스칼 표기법
		// - 식별자를 만들 때 식별자의 첫문자를 대문자 표기 + 나머지 문자는 소문자로 표기
		// - 식별자가 2개 이상의 단어로 조합되면 각 단어의 첫문자는 항상 대문자로 표기 + 나머지 문자는 소문자로 표기
		// 사용) class명
		
		//수학 점수 -> math + score
		byte mathsore;
		byte math_score;//스네이크 표기법
		byte mathScore; //캐멀 표기법
		byte MathScore; //파스칼 표기법
		
		//캐멀 표기법
		// - 식별자를 만들 때 식별자의 첫문자를 대문자 표기 + 나머지 문자는 소문자로 표기
		// - 식별자가 2개 이상의 단어로 조합되면 각 단어의 첫문자는 항상 대문자로 표기 + 나머지 문자는 소문자로 표기
		// - 첫단어의 첫문자는 소문자로 시작한다.(***)
		// 사용) 메소드명, 변수명
		
		//영어점수-> english + score
		byte EnglishScore; //파스칼
		byte englishScore; //캐멀
		
		//케밥 표기법
		// - 식별자를 만들 때 각 단어의 연결을 -를 사용해서 표기
		//byte englisg-score;
		
	
		
		
		
		
		
	}

}
