package com.test.java.collection;

import java.util.HashMap;
import java.util.Scanner;

public class Ex65_HashMap {
	
	public static void main(String[] args) {
		/*
		 
		 ArrayList vs
		 
		 ArrayList
		 - 요소 접근 -> 첨자(index) 사용 -> 요소의 순서가 있음
		 - 스칼라 배열(Scalar Array)
		 - 루프 적용 가능(장점)
		 
		 HashMap
		 - 
		 - 방이름 있음
		 - 사전(Dictionary) 구조, 맵(Map), 연관 배열
		 - 키(key)와 값(value)으로 요소를 관리
		 - 루프 적용 불가능(단점(X)) -> 애초에 루프를 돌릴 목적으로 만드는 배열이 아니다.
		 - 가독성 때문에 사용하는 배열 -> 방의 이름이 명확!!!
		 */

		//m1();
		//m2();
		m3();
		
	}//main

	private static void m3() {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>(10);// 내부배열을 입력해줄수 있음
		
		
		
		map.put("국어", 100);
		map.put("영어", 90);
		map.put("수학", 80);
		
		System.out.println(map.size());
		
		System.out.println(map.containsKey("국어")); //국어 점수 있니?
		System.out.println(map.containsValue(100)); //100점 맞은 과목이 있니?
		
		System.out.println(map.get("영어"));
		
		System.out.println(map.isEmpty());
		
		map.remove("국어");
		
		System.out.println(map.size());
		System.out.println(map.get("국어"));
		
		
		
		
	}

	private static void m2() {

		/*
		 데이터의 집합이 필요할 때(순수배열, 클래스, ArrayList, HashMap)
		 
		 1. 같은 자료형의 집합이 필요한다.
		 	a. 순수배열
		 	b. ArrayList
		 	c. HashMap
		 	
		 2. 다른 자료형의 집합이 필요하다.
		 	a. 클래스
		 	
		 	
		 1. 길이가 고정이다.
		 	a. 순수배열
		 
		 2. 길이가 가변이다.
		 	a. ArrayList
		 	b. HashMap
		 	
		 1. 데이터의 의미를 구분하기 쉽게 관리한다.
		 	a. 클래스 (멤버 변수명)
		 	b. HashMap (Key)
		 	
		 2. 일괄 처리를 한다.
		 	a. 순수배열
		 	b. ArrayList
		 
		 */
		
		//학생 정보를 관리하고 싶다. -> 데이터 집합 필요 -> 학생 1명 단위의 데이터 자료형이 필요하다.
		// - 이름, 주소, 전화, 나이
		//1. 순수배열 -> X(의미를 알기 힘듬)
		//2. ArrayList -> X(의미를 알기 힘들)
		
		//3. 클래스 -> O (의미를 알기 쉬움)
		// - 반복되는 틀로서의 역할이 만족스럽다.
		// - 규칙을 컴퓨터가 제어한다.
		// - 클래스를 선언하는 비용이 발생한다.
		// - 같은 형식의 객체를 여러개 만들때 사용한다.
		
		//4. HashMap -> O (의미를 알기 쉬움)
		// - 반복되는 틀로서의 역할이 부족하다.
		// - 규칙을 사람이 제어한다.
		// - 선언 비용이 없다.
		// - 같은 형식의 객체를 1개 만들떼 사용한다.
		
		Student2 s1 = new Student2();
		
		s1.name = "홍길동";
		s1.adress = "서울시";
		s1.tel = "010-1234-1234";
		s1.age = 20;
		
		Student2 s2 = new Student2();
		
		s2.name = "아무개";
		s2.adress = "부산시";
		s2.tel = "010-1111-2222";
		s2.age = 22;
		
		HashMap<String, String> s3 = new HashMap<String, String>();
		
		s3.put("name", "하하하");
		s3.put("adress", "인천시");
		s3.put("tel", "010-0000-0000");
		s3.put("age", "23");
		
		System.out.println(s2.name);
		System.out.println(s3.get("name"));
		
		HashMap<String, String> s4 = new HashMap<String, String>();
		
		s4.put("name", "호호호");
		s4.put("adress", "인천시");
		s4.put("tel", "010-9999-8888");
		s4.put("age", "24");
		
		
	}//m2()

	private static void m1() {
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//요소 추가
		// - Associates the specified value with the specified key in this map.
		map.put("국어", 100);
		map.put("영어", 80);
		map.put("수학", 80); //데이터(80), 키(수학) -> 방이름
		
		//강의실 6개
		// -> 1강의실, 2강의실, 3강의실 -> ArrayList
		// -> 햇님반, 달님반, 별님반 -> HashMap
		
		// - Returns the number of key-value mappings in this map
		System.out.println(map.size());
		
		//System.out.println(list.get(0));
		System.out.println(map.get("국어"));
		System.out.println(map.get("영어"));
		System.out.println(map.get("수학"));
		
		map.put("국어", 60);//수정
		System.out.println(map.get("국어"));
		
		HashMap<String, String> group = new HashMap<String, String>();
		
		group.put("반장", "홍길동");
		group.put("부반장", "아무개");
		group.put("체육부장", "하하하");
		
		System.out.println(group.get("반장"));
		
		//정보처리기사 -> 합격유무
		HashMap<String, Boolean> result = new HashMap<String, Boolean>();
		
		result.put("홍길동", true);
		result.put("아무개", false);
		result.put("하하하", true);
		
		System.out.println(result.get("홍길동"));
		System.out.println(result.get("홍홍홍"));//null
		
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("응시자명:");
		String name = scan.nextLine();
		
		if (result.get(name) != null) {
			if(result.get(name)) {
				System.out.println("합격하셨습니다.");
			} else {
				System.out.println("불합격하셨습니다.");
			}
		} else {
			System.out.println("응시자 명단에 없습니다.");
		}
	}
	
	//HashMap
	// - Key : String 다른 자료형은 잘 사용 안함
	// - value : Integer, Double, String, Boolean
	
	//요소의 최대 갯수 -> 2개
	HashMap<Boolean, String> map2 = new HashMap<Boolean, String>();
	
	//사용하지 말것
	// - 키의 의미를 알기가 힘들다.
	// - 루프용으로 사용하지 말것 -> Array
	HashMap<Integer, String> map3 = new HashMap<Integer, String>();
	
	
}

class Student2 {
	public String name;
	public String adress;
	public String tel;
	public int age;
	
	
	
}











