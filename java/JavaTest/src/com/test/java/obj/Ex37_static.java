package com.test.java.obj;

public class Ex37_static {
	
	//클래스 로딩 -> static 할당 -> main() 실행
	public static void main(String[] args) {
		
		//static 키워드
		// - 클래스 멤벙에게 붙이는 키워드
		// 1. 멤버 변수
		// 2. 멤버 메소드
		
		//static int a = 10; //지역변수에 static 은 안됨
		
		
		Student.setSchool("역삼 중학교");//
		
		Student s1 = new Student();
		
		s1.setName("홍길동");
		s1.setAge(15);
		//s1.setSchool("역삼 중학교"); //6자 12byte
		
		
		Student s2 = new Student();
		
		s2.setName("아무개");
		s2.setAge(14);
		//s2.setSchool("역삼 중학교");
		
		
		Student s3 = new Student();
		
		s3.setName("하하하");	
		s3.setAge(16);
		//s3.setSchool("역삼 중학교");
		
		
		//학생 1면 질문 
		System.out.println("이름: " + s1.getName());
		System.out.println("나이: " + s1.getAge());
		System.out.println("학교:" + s1.getSchool());
		
		
		
	}//main

}

class Test{
	public int a;
	public static int b; //멤버볌수라 됨
	
	public void aaa() {
		
	}
	
	public static void bbb() {//멤버 메소드라 됨
		
	}
}

//Ctrl + Shift + L

//학생 클래스
class Student{
	
	private String name; //heap에 생성
	private int age;	//heap에 생성
	
	//private String school;
	private static String school; //static에 생김(적어둠) 제일 먼저
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public static String getSchool() { //static에 생김
		return school;
	}
	public static void setSchool(String school) {//static에 생김
		Student.school = school;
	}
	
	
	//public String getSchool() {
	//	return school;
	//}
	//public void setSchool(String school) {
	//	this.school = school;
	//}
	
}



















