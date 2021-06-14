package com.test.java.obj;

public class Ex40constructor {
	
	public static void main(String[] args) {
		
		/*
		 
		 생성자, Constructor
		 - 특수한 목적을 가지는 메소드
		 - 객체를 초기화하는 역할(객체 멤버 변수를 초기화or 기타 초기화 작업)
		 
		 
		 생성자 vs Setter
		 - 공통점
		 	a. 생성자 : 객체 변수의 값을 대입할 수 있다.
		 	b. Setter :객체 변수의 값을 대입할 수 있다.
		 	
		 - 차이점
		 	a. 생성자 : 객체가 처음 만들어질 때 자동으로 호출된다.
		 		-주번 이상 호출이 불가능하다.
		 		- ****역할 : 초기화
		 	b. Setter : 개발자가 우너하는 시점에 직접 호출한다.
		 		- N번 이상호출이 가능하다.
		 		-***역할 : 수정자
		 */
		
		//클래스명 변수 = 객체 생성연산자 생성자
		
		//Person 객체 x 100개 생성 -> "익명", -1
		
		//1. new - heap에 null값인 놈들만 생김
		//2. Person() - 값을 초기화함!
		//3. Person p
		//4. =
		Person p = new Person();
		
		//객체 초기화(SEtter) -> 현실 : 수정
		//p.setName("익명");
		//p.setAge(-1);
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		
		
		Person p2 = new Person();
		
		//p2.setName("익명");
		//p2.setAge(-1);
		
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
		System.out.println();
		System.out.println();
		
		
		//요구사항]
		//p1, p2 -1
		//p3 : 홍길동, 20
		//p4 : 아무개, 25
		
		
//		Person p3 = new Person(); //공산품 생산.. 항상 같은 모습만 생성
		Person p3 = new Person("홍길동", 20); // 주문 생산이 가능해졌음. 원하는 모습으로 생성
		
//		p3.setName("홍길동");
//		p3.setAge(20);
		
//		System.out.println(p3.getName());
//		System.out.println(p3.getAge());
		
		
//		Person p4 = new Person();
		Person p4 = new Person("아무개", 25);
//		p4.setName("아무개");
//		p4.setAge(25);
//		System.out.println(p4.getName());
//		System.out.println(p4.getAge());
		
				
				
		//문법의 발전
		// - 수많은 목적..
		// - **************** 생산자보다 소비자의 입장을 우선한다.
		// - 생산자: 클래스를 설계하는 개발자
		// - 소비자: 클래스를 사용해서 객체를 생성하는 개발자
				
		// 생성자 : 생산자를 위한 기술이 아니라, 소비자를 위한 기술
				
		Person p5 = new Person();	//익명, -1
		Person p6 = new Person("홍길동", 20);	//홍길동, 20
		Person p7 = new Person("아무개");	//아무개, -1
		Person p8 = new Person(25); //익명, 22
		
		
		
		
		
		Member m1 = new Member();
		
		Member m2 = new Member("20", "아무개", "ter@naver.com", "010-123-456", "서울시", 22, 120, 60, "남자", 200);
		
		
		
		
		//The constructor Camera() is undefined
		// 권장 : 보통은 인자가 없는 기본 생성자가 있을거라고 예상
		Camera c1 = new Camera("A001", "white");
		
		
		
		
		System.out.println();
		
		//Monitor
		// - 객체 멤버(model) > 메모리에 아직 없음
		// - 정적 멤버(owner) > 메모리에 이미 있음
		
		//***정적 멤버를 객체 생성을 통해서 초기화 해야만 하는게 올바른 행동인가?
		// -> 정적 멤버의 초기화는 객체 생성 유무와 상관없이 별도로 실행되야 한다.
		
		System.out.println(Monitor.getOwner()); //null
		
		Monitor m = new Monitor(); //이 행동(Monitor())이 이상하다!!! -> 객체(변수)초기화 + 정적(변수) 초기화
		
		System.out.println(Monitor.getOwner()); //"홍길동"
		
		//static을 잘 사용안한다. > 사용하기가 어렵다, 메모리에 항상 차지함
		//변수 -> 데이터 저장용 -> 사물함
		//1. 객체 변수 -> 개인 사물함
		//2. 정적 변수 -> 공용 사물함
		
		//개인(홍길동) 사물함 -> 스마트폰 -> 분실 ->???
		//공용 사물함 -> 스마트폰 -> 분실 ->??
		
		
		
	}//main

}


class Person{
	
	//멤버 변수
	private String name;
	private int age;
	
	//생성자
	// - 메소드
	// 1. 메소드명이 클래스명과 동일한다.
	// 2. 반환형을 명시하지 않는다. > 반환값을 돌려주는 목적의 메소드가 아니다.
	// 3. 멤버 초기화를 구현한다.
	
	//기본 생성자
	// - 인자값이 없는 생성자
	// - 기본 생성자는 개발자가 만들지 않으면 자바가 자동으로 만든다.
	// - 인자값이 있는 생성자는 기본생성자를 만들지 않는다.
	
//	public Person() {
//		
//		//멤버 초기화 기본값
//		//1. 정수 -> 0
//		//2. 실수 -> 0
//		//3. 문자 ->\0
//		//4. 논리 -> false
//		//5. 참조 -> null
//		this.name = null;
//		this.age = 0;
//		
//		//this.name = "아무개";
//		//this.age = 100;
//	}
	
	public Person() {
		
		this.name = "익명";
		this.age = -1;
		
	}
	
	//생성자 오버로딩( = 메소드 오버로딩)
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
		
	}
	
	public Person(String name) {
		
		this.name = name;
		this.age = -1;
	}
	
	public Person(int age) {
		
		this.name = "익명";
		this.age = age;
	}
	
	
	//Getter, SEtter
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
	
	
}



class Member{
	
	private String no;
	private String name;
	private String email;
	private String tel;
	private String adress;
	private int age;
	private int height;
	private int weight;
	
	
	public Member() {
		
	}
	
	public Member(String no, String name, String email, String tel, String adress, int age, int height, int whight, String gender, int point) {
		this.no = no;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.adress = adress;
		this.age = age;
		this.height = height;
		this.weight = whight;
		this.gender = gender;
		this.point = point;
		
	}
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	private String gender;
	private int point;

	
	
}

class Camera {
	
	private String model;
	private String color;
	
	//기본 생성자는 되도록 생성하는 편이 좋다.(강제)X
	public Camera() {
		//this.model = "none";
		//this.color = "none";
		this("none", "cnone");
	}
	
	
	//***생성자는 또 다른 생성자를 호출할 수 있다.
	public Camera(String model, String color) {
		
		if(model.equals("none") || model.equals("A001") || model.equals("B001") || model.equals("C001")) {
			this.model = model;
		}
			this.color = color;
		
	}
	
	public Camera(String model) {
		this(model, "none");
		//if(model.equals("none") || model.equals("A001") || model.equals("B001") || model.equals("C001")) {
			//this.model = model;
		//}
		//this.color = "none";
		
	}
	
}


/*
 
지역 변수의 생명주기
- 변수 선언문(생성) ~ 해당 영역 종료(소멸)

객체 변수의 생명주기
- new, 객체 생성(생성) ~ 객체의 참조가 모두 끊겨서 가비지가 되고, GC가 그 객체를 회수해가는 순간(소멸)

정적 변수의 생명주기
- main() 메소드 실행전(생성) ~ main() 메소드 종료후(소멸)
- 프로그램 시작(생성) ~ 프로그램 종료(소멸)
 
 
 
 
 
 
 */

class Monitor {
	
	private String model; //멤버(객체) -> 개인정보
	private static String owner; //멤버 (정적) -> 공용정보
	
	//객체 생성자 
	// -> 객체 내부에 있는 멤버를 초기화하는 역할
	// -> 정적 멤버를 초기화하지 않는다! -> 논리에 안맞음
	
	public Monitor() { //new Monitor()
		this.model = "M100";
		Monitor.owner= "홍길동";
	}
	
	//정적 생성자
	// - 정적 멤버를 초기화 하는 전용 생성자
	// - main() 실행전에 호출된다.
	static {
		
		Monitor.owner = "홍길동";
		
	}

	
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public static String getOwner() {
		return owner;
	}

	public static void setOwner(String owner) {
		Monitor.owner = owner;
	}
}


//메소드, 함수
//클래스 멤버 변수(객체, 정적), 특성, 속성, 필드










