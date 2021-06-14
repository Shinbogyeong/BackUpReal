package com.test.java.Inheritance3;

public class Ex58_Generic {
	
	public static void main(String[] args) {
		
		//자료형
		//1. 값형(원시형)
		//	a. 정수(byte, short, int, long)
		//	b. 실수(float, double)
		//	c. 문자(char)
		//	d. 논리(boolean)
		
		//2. 참조형
		// - 모두 클래스
		//	a. String
		//	b. 배열
		// 	c. 클래스
		//		1. 일반 클래스
		//		2. 추상 클래스
		//		3. 인터페이스
		//		4. enum
		//		5. 제네릭 클래스
		
		//제네릭, Generic
		
		WrapperInt n1 = new WrapperInt(100);
		System.out.println(n1);
		System.out.println(n1.getData() * 3);
		System.out.println();
		
		WrapperObject n2 = new WrapperObject(200);
		System.out.println(n2);
		System.out.println((int)n2.getData() * 3);
		System.out.println();
		
		Wrapper<Integer> n3 = new Wrapper<Integer>(300); //전용(WrapperInt) + 범용(WrapperObject)
		System.out.println(n3);
		System.out.println(n3.getData() * 3);
		System.out.println();
		
		
		
		WrapperString s1 = new WrapperString("홍길동");
		System.out.println(s1);
		System.out.println(s1.getData().length());
		System.out.println();

		WrapperObject s2 = new WrapperObject("안녕하세요");
		System.out.println(s2);
		System.out.println(((String)s2.getData()).length());
		System.out.println();
		
		Wrapper<String> s3 = new Wrapper<String>("지금 자바를 공부하고 있습니다.");
		System.out.println(s3);
		System.out.println(s3.getData().length());
		System.out.println();
		
		
		
		WrapperBoolean b1 = new WrapperBoolean(true);
		System.out.println(b1);
		System.out.println(b1.getData() ? "참" : "거짓");
		System.out.println();
		
		WrapperObject b2 = new WrapperObject(false);
		System.out.println(b2);
		System.out.println((boolean)b2.getData() ? "참" : "거짓");
		
		Wrapper<Boolean> b3 = new Wrapper<Boolean>(true);
		System.out.println(b3);
		System.out.println(b3.getData() ? "참" : "거짓");
		
		//제네릭 클래스
		//1. Object 처럼 모든 자료형을 제어할 수 있다.
		//2. 전용 클래스처럼 형변환없이 데이터를 바로 사용이 가능하다. (Object는 다운캐스팅이 필요하다.)
		
	}//main

	

}



//요구사항] 
//1. int값 1개를 중심으로 여러가지 작업을 하는 클래스를 선언하시오.
//2. String 값 1개를 중심으로 여러가지 작업을 하는 클래스를 선언하시오.
//3. boolean 값 1개를 중심으로 여러가지 작업을 하는 클래스를 선언하시오.
//4. byte
//5. short
//6. long
//7. float
//8. double
//9. char
//10. Random
//11. Student
//...무한대

class WrapperInt {
	
	private int data; //중심 데이터
	
	public WrapperInt(int data) {
		this.setData(data);
	}


	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String toString() {
		
		//int -> String
		//return (string) this.data;
		
		//return String.valueOf(this.data);//정석
		
		return this.data + "";//편법 문자열을 더하면 문자열이 된다!!
	}
}


class WrapperString {
	
	private String data; //중심 데이터
	
	public WrapperString(String data) {
		this.setData(data);
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String toString() {
		return this.data;
	}
}


class WrapperBoolean {
	
	private Boolean data; //중심 데이터
	
	public WrapperBoolean(Boolean data) {
		this.setData(data);
	}


	public Boolean getData() {
		return data;
	}

	public void setData(Boolean data) {
		this.data = data;
	}

	public String toString() {
		return this.data + "";
	}
}


class WrapperObject {
	
	private Object data; //중심 데이터
	
	public WrapperObject(Object data) {
		this.setData(data);
	}


	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String toString() {
		return this.data + "";
	}
}


class Wrapper<T> {
	
	private T data;
	
	public Wrapper(T data) {//생성자
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data + "";
	}
	
}









