package com.test.java.Inheritance3;

public class Ex53_Cast {
	
	public static void main(String[] args) {
		
		/*
		 형변환, Type Cast
		 1. 값형 형변환: 값형끼리만 가능
		 2. 참조형 형변환 : 참조형끼리만 가능 > 클래스간의 형변환
		 
		 값형 형변환
		 - 숫자형끼리 가능(boolean불가능)
		 - 작은형 -> 큰형 : 암시적(100% 안전)
		 - 큰형 -> 작은형 : 명시적(Overflow 발생 가능)
		 
		 참조형 형변환
		 - 클래스간의 형변환
		 - 상속 관계를 맺은 (직계)클래스간에만 가능
		 - 자식클래스 -> 부모클래스 : 암시적(100% 안전), 업캐스팅(UP casting)
		 - 부모클래스 -> 자식클래스 : 명시적(부분 안전, 불안전), 다운캐스팅(Down Casting), 100% 불가능, 되는 경우도 있음
		 
		 */
		
		
		/*
		Parent p1 = new Parent();
		Child c1 = new Child();
		
		
		Parent p2; //복사본
		Child c2 = new Child(); //원본
		
		//Parent = Child
		//부모 클래스 = 자식 클래스
		//업캐스팅 발생(암시적)
		p2 = c2;
		//p2 = (Parent)c2 같음
		
		//복사가 제대로 이루어졌는지 확인???
		// -> 참조형 형변환의 확인 방법 -> "복사된 참조 변수를 올바르게 사용할 수 있는가?"(*******)
		
		//p2로 할 수 있는 모든 행동을 테스트 중..(******************)
		p2.a = 10;
		p2.b = 20;
		
		System.out.println(p2.a);
		System.out.println(p2.b);
		
		
		Parent p3 = new Parent(); //원본
		Child c3; //복사본
		
		//Child = Parnet
		//자식클래스 = 부모클래스
		//다운클래스(명시적)
		
		c3 = (Child)p3;//에러  java.lang.ClassCastException
		//class com.test.question.Inheritance3.Parent cannot be cast to class com.test.question.Inheritance3.Child (com.test.question.Inheritance3.Parent and com.test.question.Inheritance3.Child are in unnamed module of loader 'app')
		
		
		
		//p2로 할 수 있는 모든 행동을 테스트 중..(******************)
		c3.a = 10; //O
		c3.b = 20; //O
		c3.c = 30; //X
		c3.d = 40; //X
		
		System.out.println(c3.a); //O
		System.out.println(c3.b); //O
		System.out.println(c3.c); //X
		System.out.println(c3.d); //X
		*/
	
		Parent p4;
		Child c4 = new Child();
		
		//업캐스팅
		p4 = c4;
		
		
		
		
		
		Child c5;
		
		//다운 캐스팅(100%불가능) -> 가능한 작업(******)
		//자식클래스 = 부모클래스
		
		c5 = (Child)p4; //실체 : Child -> Child
		
		System.out.println(c5.a);
		System.out.println(c5.b);
		System.out.println(c5.c);
		System.out.println(c5.d);
		
		
		
		
	}//main
	

}


class Parent {
	public int a;
	public int b;
}


class Child extends Parent{
	public int c;
	public int d;
}






