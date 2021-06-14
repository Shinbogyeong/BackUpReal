package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex26_Array {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//배열 , Array
		// - 문자열 유사(문자 배열, char array)
		// - 같은 성격의 데이터 + 같은 자료형 -> 모아놓은 집합
		// - 참조형(Referenxe Type)
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		m9();
		//m10();
		//m11();
		//m12();
		
		
		//자료구조, 알고리즘
		//자료구조 -> 배열(연습 + 제어문)
		
		
		
	}private static void m12() {

		//프로젝트 적용
		// - 데이터 만들기
		// - 회원 정보 x 100명
		
		//회원 정보
		//a. 이름 : 문자열
		//b. 나이 : 숫자
		//c. 성별 : 숫자(1. 남자, 2 여자)
		//d. 주소 : 문자열
		
		//Mate.random() + 배열
		
		int count = 100;
		
		String[] name = new String[count];
		int[] age = new int[count];
		int[] gender = new int[count];
		String[] address = new String[count];
		
		//기초 데이터 -> 임의의 회원 정보를 생성하기 위한 기반 데이터
		
		//이름(성)
		String[] n1 = {"김", "이", "박", "최", "정", "한", "신"};
		
		//이름(이름)
		String[] n2 = { "대", "은", "창", "미", "준", "나", "보", "도", "경", "지", "원", "연"};
		
		
		//주소
		String[] a1 = {"서울시", "인천시", "부산시", "광주시", "대천시"};
		String[] a2 = {"동대문구", "서대문구", "중구","남구"};
		String[] a3 = {"연남동", "역삼동", "길동", "명일동"};
		
		
		//n1[임의의 방번호]
		//System.out.println(n1[(int)(Math.random() * n1.length)]
		//		+ n2[(int)(Math.random() * n2.length)]
		//		+ n2[(int)(Math.random() * n2.length)]);
		
		for(int i=0; i<count; i++) {
			name[i] = n1[(int)(Math.random() * n1.length)]
							+ n2[(int)(Math.random() * n2.length)]
							+ n2[(int)(Math.random() * n2.length)];
			
			age[i] = (int)(Math.random() * 41) + 19;// 0~40 -> 19~59
			
			gender[i] = (int)(Math.random() *2) + 1;
			
			address[i] = a1[(int)(Math.random() *a1.length)]
						+ " "
						+ a2[(int)(Math.random() *a2.length)]
						+ " "
						+ a3[(int)(Math.random() *a3.length)]
						+ " "
						+((int)(Math.random() * 330) + 1)
						+ "번지";
			
		}
		
		
		
		
		
		for (int i=0; i<count; i++) {
			System.out.printf("[%s] %d세, %s, %s\n"
							, name[i]
							, age[i]
							, gender[i] ==1? "남자" : "여자"
							, address[i]);
		}
		
		
		
	}

	private static void m11() {

		//배열 초기화 리스트, 배열 초기자(Initializer)
		int[] num1 = new int[5];
		
		for(int i=0; i<num1.length; i++) {
			num1[i] = (i+1) * 100;
		}
		
		for(int n : num1) {
			System.out.println(n);
		}
		
		
		
		int[] num2 = new int[5]; //152, 45, 36, 98, 354
		
		num2[0] = 152;
		num2[1] = 45;
		num2[2] = 36;
		num2[3] = 98;
		num2[4] = 354;
		
		int[] num3 = new int[] { 152, 45, 36, 98, 354}; //초기화리스트
		
		int[] num4 = { 152, 45, 36, 98, 354}; 
		
		String[] name = {"홍길동", "아무개", "하하하"};
		
		boolean[] flag = { true, false, false, true};
		
		char[] cs = { 'a', 'b'};
		
		
	}

	private static void m10() {

		//갑형 vs 참조형
		int n; //null
		String s; //null
		
		//지역 변수는 초기화하지 않으면 사용이 불가능하다.
		//System.out.println(n);
		//System.out.println(s);
		
		//초기화 해야할 값이 정해지지 않았지만 일단 초기화를 해야 하는 경우..
		//참조형(주소값) 변수는 null로 초기화를 할 수 있다.
		s = null;
		s = "";
		
		//값형 변수는 절대로 null로 초기화를 할 수 없다.
		//n = null;
		n = 0;
		
		//---------------------------------------
		// - 배열은 방을 만들면 개발자의 의도와 상관없이 모든 방이 특정값으로 초기화가 된다. ->생성자
		// 어떤 값으로 초기화?(****)
		//1. 정수 배열 > 0
		//2. 실수 배열 > 0.0
		//3. 문자 배열 > '\0'(null문자, 문자코드값(0))
		//4. 논리 배열 > false
		//5. 참조형 배열 > null
		
		int[] num = new int[5];
		
		System.out.println(num[0]); //num[0]자료형 -> int니까 값초기화 안했으면 없엉야하는데..?
		System.out.println(num[1]);//0
		System.out.println(num[2]);//0
		System.out.println(num[3]);//0
		System.out.println(num[4]);//0
		
		
		double[] num2 = new double[3];
		System.out.println(num2[0]);//0.0
		
		char[] list = new char[3];
		System.out.println(list[0]); //
		System.out.println((int)list[0]);//0
		
		boolean[] list2 = new boolean[3];
		System.out.println(list2[0]);//false
		
		String[] list3 = new String[3];
		System.out.println(list3[0]);//null
		
	}

	private static void m9() {
		
		String[] name = new String[5];
		name [0] = "홍길동"; 
		name [1] = "아무개"; 
		name [2] = "유재석"; 
		name [3] = "강호동"; 
		name [4] = "신동엽"; 
		
		//배열 탐색 -> for문을 사용해서 배열의 요소(Element)에 접근하기
		for(int i=0; i<name.length; i++) {
			System.out.println(name[i]);
			name[i] += "님";
		}
		System.out.println();
		
		
		//제어문 -> 또 다른 for문 -> 향상된 for문(Enhanced for Statement)
		// - 배열이나 컬렉션을 대상으로만 사용이 가능하다.(iterator를 지원하는 자료형에 한해서..)
		// - 루프 변수가 없다. > 안정성이 높음 + 코드 간결함
		// - 배열의 모든 요소를 순차적으로(****) 자동 탐색한다. > 다른 방식으로는 탐색 불가능
		// - 속도가 for문보다 빠르다.
		// - 읽기 전용 반복문 : 요소의 값을 수정할 수 없다. -> 요소의 값을 수정하면 안된다!!!
		
		//for(변수: 집합) {
		//	
		//}
		
		for(String temp : name) {
			System.out.println(temp);
			temp += "고객" + name; //수정 ->고객 : 홍길동 님
		}
		System.out.println();
		
		for (String temp : name) {
			System.out.println(temp);
		}
		
		
		
		int[] num = new int[10];
		
		//쓰기-> 일반 for문
		for(int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random() * 100) + 1; //1~100
		}
		
		for(int n : num) {
			System.out.println(n);
		}
		
		
		
	}

	private static void m8() {

		//배열 복사(참조형 복사)
		//1. 얕은 복사, Shallow Copy
		//2. 깊은 복사, Deep Copy
		
		int[] num1 = new int[3];
		num1[0] = 100;
		num1[1] = 200;
		num1[2] = 300;
		
		int[] num2; //=new int[3]; 복사할 배열은 굳이 만들필요 없음
		
		//얕은 복사
		num2 = num1;
		
		
		int[] num3 = new int[3];
		num3[0] = 100;
		num3[1] = 200;
		num3[2] = 300;
		
		int[] num4 = new int[3]; //배열은 꼭 만들어야 한다!!
		
		//깊은 복사
		for(int i=0; i<num3.length; i++) {
			//
			//int = int
			num4[i] = num3[i];
		}
		
		num3[0] = 500;
		
		output(num3);
		output(num4);
		
		//참조형 복사
		//1. 변수끼리 복사-> 얕은 복사 -> 원본을 건드리면 복사본 수정된다.
		//2. 실제 공간끼리 복사 -> 깊은 복사 -> 원본을 건드려도 복사본 영향을 받지 않는다.
		
	}

	//main

	private static void m7() {

		//값형 복사 vs 참조형 복사
		
		//값형복사
		// - Side Effect가 없다.
		int a = 10;
		int b;
		
		b = a;
		
		System.out.println(a);
		System.out.println(b);
		
		a++;
		
		System.out.println(a);
		System.out.println(b);
		
		//배열 복사(참조형 복사)
		// - Side Effect가 있다.
		// - 복사된 변수가 있었을 때 그 중 하나를 조작하면 나머지도 영향을 받는다(주의!!!!)
		int[] num1 = new int[3];
		
		num1[0] = 100;
		num1[1] = 200;
		num1[2] = 300;
		
		output(num1);// 출력
		
		int[] num2 = new int[3];
		
		
		//*******
		// - int[] = int[]
		// - 모든 참조형 변수끼리의 복사는 데이터 복사가 아닌 참조 주소 복사가 일어난다.
		num2 = num1;//num1에있는 주소를 num2의 주소에 복사, num2의 참조 끊김, num1의 heap주소를 참조
		
		output(num2);
		
		num1[0] = 500;
		
		output(num1);
		
		output(num2); //num1[0]의 수정이 num2[0]의 수정으로 반영이됨,,왜??
		
		
		
	}
	
	public static void output(int[] num) { //int[] num = num1; 주소값을 복사
		for(int i=0; i<num.length; i++) {
			System.out.printf("%d  ", num[i]);
		}
		System.out.println();
	}
	

	private static void m6() {

		//배열을 만드는 목적
		// -> 한번에 변수를 여러개 만들기 위해서..
		// -> 같은 자료형 + 같은 성격의 데이터 -> 다량으로 저장하기 위한 공간 필요
		
		int[] kor = new int [3];//int방 x 3개
		kor[0] = 100;	//국어점수
		kor[1] = 90; 	//국어점수
		kor[2] = 80;	//영어점수 -> 컴파일O, 런타임O, 데이터 X
		
		int[] score = new int[3];
		score[0] = 100;	//국어점수
		score[1] = 90;	//영어점수
		score[2] = 80;	//수학점수
		
		System.out.println(kor[0]);		//국어점수
		System.out.println(score[1]);	//???
		
		//[index] 표기법 > indexer(인덱서)
		//score[0] ;
		
		//메모리 구조
		// - 값형과 참조형(모든 자료형)은 메모리에 공간이 한번 항당되면 그 공간의 크기를 변경할 수 없다.
		// - 메모리에 잡힌 공간은 변경이 불가능하다.
		//1. 값형(8가지)
		// - 데이터가 변해도 공간의 크기가 변하지 않는다.
		// - 모든 지역 변수는 값형, 참조형에 상관없이 무조건 Stack 에 생성된다.
		//2. 참조형(String. Array, Calendar, Math, BufferedReader...)
		// - 데이터에 따라 공간의 크기가 일정하지 않다.
		// - 공간의 크기를 미리 예측하기 불가능하다.
		
		
		//값형, 원시형
		//0000 0000 0000 0000 0000 0000 0000 1010
		//0000 0101 1111 0101 1110 0001 0000 0000
		int n = 10;		
		n = 100000000;
		
		boolean b = true;
		
		double d = 3.14;
		
		//참조형
		String s1 = "홍길동";
		String s2 = "안녕하세요";
		
		s1 = "반갑습니다.";//"홍길동"은 참조가 끊김, "반갑습니다"로 교체
		s2 = "하하";
		
		System.out.println(n);//값형 - Stack에 데이터있음
		System.out.println(s1);//참조형 - Stack에 데이터 대신 주소가 들어있음 그 heap의 주소에서 데이터가져감
		
		
		//참조형 : 상수를 먼저 만들고(heap) , 변수를 만들고(stack), 그 이름에 상수 복사함
		//GC(Garbage Collector) - 가 이름이 없는 상수를 가져감(값형), 참조가 끊긴 상수(참조형)
		
		
		
		String s3 = "a";
		s3 = "abc";
		s3 = "abc";
		
		int[] num = new int[3];//int x 3 = 12byte
		num = new int[5];		//int x 5 = 20byte
		
		
		int[] num2 = new int[3];
		
		num2[0] = 100;
		num2[2] = 300;
		
		System.out.println(num[2]);
		
		
		String[] name = new String[3];
		
		name[0] = "홍길동";
		name[1] = "아무개";
		name[2] = "하하";
		
	}

	private static void m5() throws NumberFormatException, IOException {

		//배열의 성질
		// - 배열의 길이가 불변(Immutable)이다. > 한번 만들어진 배열의 방 갯수는 수정이 불가능하다. > 방을 더 만들거나, 있는 방을 삭제할 수 없다. > 배열에 들어갈 데이터의 갯수를 미리 충분히 예측해서 최대값의 근접한 길이로 잡는다.(조금 더 크게)
		
		int[] num = new int[5];
		
		//추후에 변경 불가능하다
		
		// - 자바의 배열은 동적할당이 가능하다. > 자바 배열의 길이는 런타임에서 결정할 수 있다.
		//int [] list = new int[5]; //정적할당
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("숫자:");
		int n = Integer.parseInt(reader.readLine());
		
		int[] list = new int[n];//동적 할당
		
		System.out.println(list.length);
		
		
	}

	private static void m4() {

		//배열 + 여러 자료형
		
		//정수 배열(byte, short, int, long)
		byte[] list1 = new byte[3];
		list1[0] = 10;
		System.out.println(list1[0]);
		
		//싱수형 배열(float, double)
		double[] list2 = new double[3];
		list2[0] = 3.14;
		System.out.println(list2[0]);
		
		//문자열 배열(char)
		char[] list3 = new char [3];
		list3[0] = 'A';
		System.out.println(list3[0]);
	
		//논리형 배열(boolean)
		boolean[] list4 = new boolean[3];
		list4[0] = true;
		System.out.println(list4[0]);
		
		//참조형 타입 배열(*******************************)
		// - 문자열은 참조형에 속하지만 사용법은 값형과 동일하다.
		String[] list5 = new String[3];
		list5[0] = "홍길동";
		System.out.println(list5[0]);
		
		
		//모든자료형으로 배열을 생성할 수 있다.
		Calendar[] list6 = new Calendar[3];
		list6[0] = Calendar.getInstance();
		System.out.printf("%tF\n", list6[0]);
		
		
		
	}

	private static void m3() {

		//요구사항] int 숫자 -> 1 ~10까지 저장
		
		int[]num = new int[10];
		
		//배열안의 방 10개 -> 숫자 대입
		//배열 탐색
		for (int i=0; i<num.length; i++) {
			num[i] = i + 1;
		}
		//출력
		System.out.println(num[0]);
		System.out.println(num[1]);
		System.out.println(num[2]);
		
		System.out.println(num[9]);//length -1
		
		//java.lang.ArrayIndexOutOfBoundsException
		System.out.println(num[10]);//존재안함
		
		for(int i=0; i<num.length; i++) {
			System.out.printf("num[%d] = %d\n", i, num[i]);
		}
	}

	private static void m2() {

		//배열 사용
		//m1() -> 개선 -> m2()
		//요구사항] 학생 3명 > 국어 점수 > 총점, 평균
		
		//1. 배열 만들기(선언하기)
		// - 자료형[] 배열명 = new 자료형[길이]
		
		
		
		int[] kor = new int [500]; //이득발생
		
		kor[1] = 100; //경우에 따라 이득 발생
		kor[2] = 90;
		kor[3] = 80;
		//..
		kor[499] = 100;
		
		//int total = kor[0] + kor[1] + kor[2];
		int total = 0;
		
		for(int i=0; i<kor.length; i++) {
			total += kor[i];
		}
		
		
		double avg = (double)total / kor.length; 
		
		System.out.printf("총점: %d점, 평균: %1.f점\n", total, avg);
		
		
		
	}

	private static void m1() {

		//요구사항] 학생 3명
		//수정사항] 학생 수 증가 > 500명
		int kor1;
		int kor2;
		int kor3;
		// + 497
		
		kor1 = 100;
		kor2 = 90;
		kor3 = 80;
		
		int total = kor1 + kor2 + kor3; // +497
		double avg = total / 3.0; //3 -> 500.0
		
		System.out.printf("총점: %d점, 평균: %1.f점\n", total, avg);
		
	}

}
