package com.test.question.q40;

public class Student {
	
	private String name = "미정";
	private int age;
	private int grade;
	private int classNumber;
	private int number;
	
	
	public Student() {
		
		this("미정", 0, 0, 0, 0);
//		this.name = "미정";
//		this.age = 0;
//		this.grade = 0;
//		this.classNumber = 0;
//		this.number = 0;
	}
	
	public Student(String name, int age, int grade, int classNumber, int number) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
	}
	
	public Student(String name, int age) {
		this(name, age, 0, 0, 0);
	}
	
	public Student(int grade, int classNumber, int number) {
		this("미정", 0, grade, classNumber, number);
	}
	
	
	
	public String info() {
		
		
		return this.name+ "(나이: " +( this.age != 0 ? this.age + "세":"미정" ) +", 학년:"+(this.grade!= 0 ? this.grade:"미정" )
	            + ", 반: " + (this.classNumber!= 0 ? this.classNumber:"미정" ) +",번호: " +(this.number!=0 ? this.grade:"미정")+")";
	}
	
	//

}
