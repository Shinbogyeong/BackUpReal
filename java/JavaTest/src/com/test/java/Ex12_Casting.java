package com.test.java;

public class Ex12_Casting {
	public static void main(String[] args) {
		
		/*
		(자료) 형변환, (Data)Type Casting
		- 자료형은 변환시키는 기술
		- int -> float
		- double -> byte
		
		암시적인 형변화, 자동 타입 변환
		- 큰형 = 작은형(작은형을 큰형으로)
		- 100% 안전
		*/
		
		byte b1 = 10;
		short s1;
		
		// = 연산자
		// - 변수= 값;
		// - LValue(변수) = RValue((상수,변수)
		// - ******연산자는 반드시 (100%) LValue와 RValue의 자료형이 동일해야한다.
		//   동일 하지 않으면 복사를 못한다.~ 에러발생!!!!!!!!!!!!!!!!
		
		// short = byte
		// 2byte = 1byte
		// 큰형 = 작은형
		// 개발자가 모르게 형변환이 발생한다. > 임시적인 형변환, 자동형변환
		
		//s1 = b1;
		//s1 = (short)b1;// 컴파일러가 컴파일을 할 때 윗줄을 현재줄과 같이 번역한다.
		//() : 형변환 연산자
		
		
		s1 = b1; //권장(익숙함)
		s1 = (short)b1; //권장(가독성 향상)
		
		System.out.println("복사본 : " + s1);//원본확인 X
		
		b1 = Byte.MIN_VALUE;
		s1= b1;
		System.out.println("복사본 : " + s1);//최솟값 -128
		
		
		b1 = Byte.MAX_VALUE;
		s1= b1;
		System.out.println("복사본 : " + s1);//최대값 127
		
		long l1;
		l1 = s1;
		System.out.println("복사본 : " + s1);//
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		/*
		 명시적인 형변환, 강제 타입 변환
		 - 작은형 = 큰형
		 - 경우에 따라 다르다.(작은형이 포함할 수 있는 원본이면 안전하고, 포함할 수 없는 원본이면 불안전하다.)
		 - 결론 : 굉장히 위험한 작업이다 !!!!1> 정신을 바짝 차려라!!1> 틀리면 죽는다;;;> 에러가 안난다.;;;;;;>
		 		>>>>근데 값이 이상하다!!!!!!!!
		 
		 */
		
		//컴파일 작업 vs 런타임 작업
		// - 컴파일 : 실제 프로그램을 실행하는 것이 아니라, 단지 언어만 번역하는 작업만 한다.
		//			단, 그 과정 중에 문법이 유효한지 검사를 한다.유효한 문법 01010으로 바꿈
		short s2 = 10;
		byte b2;
		
		//Type mismatch: cannot convert from short to byte
		//b2 = s2;//컴파일"short변수를 byte변수에 넣어야지~(10인줄 모름)" 빨간밑줄 -> 실행하기 전이라 오류날거같다~
		b2 = (byte)s2;
		System.out.println("복사본 : " + b2);
		
		s2 = 127;
		b2 = (byte)s2;
		System.out.println("복사본 : " + b2);
		
		s2 = 128;
		b2 = (byte)s2;
		System.out.println("복사본 : " + b2);
		
		s2 = 1000;
		b2 = (byte)s2;
		System.out.println("복사본 : " + b2);
		
		s2 = 10000;
		b2 = (byte)s2;
		System.out.println("복사본 : " + b2);
		//복사본 : 16//10000을 2진수로 바꾸고 앞에부분 날림
		System.out.println();
		System.out.println();
		System.out.println();
		
		// 암시적 형변환
		// -> 왜 암시적? -> 개발자가 이사실을 알던 모르던.. 결과는 안전하니까 생략하자
		// short = byte
		
		// 명시적 형변환
		// -> 왜 명시적? -> 이작업은 잘못될 가능성이 존재한다. -> 개발자 너는 이사실을 명시적으로 책임지고 직접 형변환을 해라!
		// byte = (byte)short

		//--------정수형 끼리의 형변환---------------------------
		
		
		
		
		
		
		//실수형
		//float, double
		
		float f1 = 3.14F;
		double d1;
		//8byte = 4byte
		d1 = f1;
		
		System.out.println("복사본 : " + d1);
		
		
		
		float f2;
		double d2 = 3.14;
		//4byte = 8byte
		f2 = (float)d2;
		
		System.out.println(f2);
		
		
		//실수형: float, double -> 거의 double사용 (정밀도 때문에)
		//정수형: byte, short, int, long -> int, long 사용
		
		
		// 정수형 상수는 모조건 int이다.
		// byte와 short는 명시적으로 해야한다!
		// 하지만 초기화는 너무 많이 쓰니까 예외로 안써도됨
		// - 100L : Long
		byte n1		= (byte)100; //byte = int
		short n2	= (short)100; //short = ibt
		int n3		= 100; //int = int
		long n4		= 100; //long = int
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		//byte, short안쓰는 이유
		//cpu는 4byte씩 읽어서 byte나 short를 byte를 추가해서 쓰느니 그냥 int쓰자
		
		//----------------------------------
		// 정수 <-> 실수
		
		int a1;
		float a2;
		a1 = 100;
		
		//float = int
		//4byte = 4byte
		a2 = a1;
		System.out.println(a2);//100.0
		
		
		int a3;
		float a4;
		a4 = 3.14f;
		
		//int = float
		//4byte = 4byte//물리적
		//int(+-21억) = float(+-무한)//실질적 수
		a3 = (int)a4;
		System.out.println(a3);//3.13 -> 3
		
		
		long a5;
		float a6;
		a5 = 10000000;
		
		//float = long
		//4byte = 8byte :명시적이잖아 
		//무한대 = +-922경 : 그래서 암시적으로
		a6 = a5;
		
		System.out.println(a6);
		System.out.println( );
		System.out.println( );
		System.out.println( );
		
		//숫자 자료형의 크기
		//byte(1) < short(2) < int(4) < long(8)
		//float(4) < double(8)
		
		//byte(1) < short(2) < int(4) < long(8) <<<<< float(4) < double(8) ******
		
		
		
		
		
		//------------------------------------------------
		
		//char
		// - 문자형 -> 문자코드로 저장 -> char 숫자형에 속한다. 단, 가감승제를 안하는 숫자형
		//char를 정수로 형변환할 때는 반드시 int사용한다. (short(byte)를 사용하면 절대안된다.)
		//char의 범위 : 0~65535
		//short의 범위 : -32768 ~ 32767
		
		char c5;
		short s5;
		s5 = 97;//'a'
		System.out.println(s5);
		c5 = (char)s5;
		System.out.println(c5);
		
		char c6;
		short s6;
		c6 ='A';
		s6 = (short)c6;
		System.out.println(s6);
		
		//char은 int랑짝꿍이예용~!!
		System.out.println((int)'A');	//65
		System.out.println((int)'가');	// 44032
		System.out.println((short)'가');	//-21504깨짐 
		
		
		
		
	}
	
	
	
}
















