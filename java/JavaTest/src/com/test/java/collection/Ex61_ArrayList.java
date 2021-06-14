package com.test.java.collection;

import java.awt.List;
import java.util.ArrayList;

public class Ex61_ArrayList {

	public static void main(String[] args) {
		
		/*
		 
		 컬렉션, Collection
		 - java Collection Framework(JCF) (면접에 용어 가끔나옴 )
		 - 배열 -> 향상된 배열
		 - 배열을 기반으로 특정한 사용 목적이나, 특정한 사용 방식을 구현해 놓은 클래스
		 - 자료 구조 -> 이름 붙여 놓은 것들 -> 컬렉션
		 - 10여종 + 직접 구현
		 
		 
		 
		 ArrayList 클래스
		 - 가장 많이 사용하는 컬렉션 클래스
		 - 가장 보편적인 구조를 가진다.
		 - 순수 배열과 구조가 거의 비슷하다.(*****)
		 - 첨자(index)를 사용해서 요소(Element)에 접근/제어
		 */
		
		//m1();
		//m2();
		m3();
		
	}

	private static void m3() {
		
		ArrayList<String> list = new ArrayList<String>();//String 배열
		
		//1. 요소 추가하기
		// - void add(T value)
		// - 배열의 맨 마지막에 추가한다.(Append)
		list.add("빨강");
		list.add("노랑");
		list.add("파랑");
		list.add("연두");
		list.add("주황");
		
		//2. 요소의 갯수
		// - int size()
		System.out.println(list.size());
		
		//3. 요소의 접근
		// - T get(int index)
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		//System.out.println(list.get(5)); 오류
		System.out.println(list.get(list.size()-1));
		
		
		//4. 요소의 수정
		// - list[0] = 100
		// - T set(int index, T value)
		System.out.println();
		System.out.println(list.get(2));
		String oldValue = list.set(2, "Blue");
		list.set(2, "blue");
		System.out.println(oldValue);
		System.out.println(list.get(2));

		//5. 요소의 삭제
		// - 순수 배열의 요소는 삭제 불가능
		// - 컬렉션은 요소의 삭제 가능
		// - T remove(int index) //더 많이 사용
		// - boolean remove(T value)
		
		System.out.println();
		System.out.println(list.size());
		
		for(String color : list) {
			System.out.println(color);
		}
		
		System.out.println("3번방: " + list.get(3));
		list.remove(2);
		System.out.println("3번방: " + list.get(3));
		
		System.out.println();
		System.out.println(list.size());
		
		for(String color : list) {
			System.out.println(color);
		}
		
		//6. 요소 추가
		// - 삽입(Insert)
		// - 중간에 끼워 넣기
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		for(String color : list) {
			System.out.println(color);
		}
		
		
		System.out.println("2번방: " + list.get(2));
		list.add(1, "오렌지");
		System.out.println("2번방: " + list.get(2));//오른쪽으로 밀림
		
		for(String color : list) {
			System.out.println(color);
		}
		
		
		
		//7. 검색
		// - 요소값 검색
		// - contatins - boolean contains( T value)
		// - int indexOf(T value)
		// - int lastIndexOf(T value)
		
		System.out.println(list.contains("노랑")); //있다? 없다?
		System.out.println(list.indexOf("노랑"));	  //몇번째? 방향(->)
		System.out.println(list.lastIndexOf("노랑")); //몇번째? 방향(<-)
		
		
		//8. 초기화
		// - 모든 방을 삭제
		list.clear(); //원래 배열을 초기화
		//list = new ArrayList<String>(); //새로운 배열로 덮어쓰기
		
		System.out.println(list.size());
		
		//9. 빈배열 확인
		System.out.println(list.size() == 0); //비어인시?
		System.out.println(list.isEmpty());
		
		
		//List 인터페이스
		//ArrayList 클래스
		
		ArrayList<String> a1 = new ArrayList<String>();
		//List<String> a2 = new List<String>();

		//**결론: 인터페이스를 상속받은 클래스의 객체는 인터페이스 변수에 담아서 사용하는 경우가 많다.
		//List<String> a2 = new ArrayList<String>(); //부모인터페이스 = 자식객체//업캐스팅
	}

	private static void m2() {
		
		//일반 버전(Object 버전)
		ArrayList list1 = new ArrayList();
		
		list1.add(100);
		list1.add(200);
		list1.add(300);
		
		System.out.println((int)list1.get(0) + 100);
		
		//제네릭 버전
		ArrayList<Integer>list2 = new ArrayList<Integer>();//int 배열
		
		list2.add(100);
		list2.add(200);
		list2.add(300);
		
		System.out.println(list2.get(0) + 100);
		
		System.out.println(list1.size());
		
		for(int i=0; i<list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		for(int n: list2) {
			System.out.println(n);
		}
	}

	private static void m1() {
		
		//순수 배열
		// - 타입 명시(int)
		// - 길이 명시(3)
		int[] num1 = new int[3];
		
		//초기화 + 요소접근 -> 첨자(index) 사용
		num1[0] = 100;
		num1[1] = 200;
		num1[2] = 200;
		
		System.out.println(num1[0]);
		
		//탐색
		for(int i=0; i<num1.length; i++) {
			System.out.println(num1[i]);
		}
		
		for(int n: num1) {
			System.out.println(n);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		//컬렉션
		//ArrayList
		//- 타입 없음(int) -> Object배역
		//- 길이 없음(3) -> 가변(늘리거나 줄일 수있다.) ***************
		ArrayList num2 = new ArrayList();
		
		//초기화
		//num2[0] = 100;//[0] : Indexer -> 자바는 순수 배열만 인덱서를 지원한다.
		
		//add -> 순서대로 알아서 넣는 메소드(비어있는 방에 순서대로 집어넣는다.)
		//Append
		num2.add(100); //0번방
		num2.add(200); //1번방
		num2.add(300); //2번방
		
		//System.out.println(num2[0]);
		System.out.println(num2.get(0));
		
		for(int i=0; i<num2.size() ; i++) {//lenght못씁
			System.out.println(num2.get(i));
		}
		
		//System.out.println(num2.get(0) * 2);//안됨 object라..(int)로 다운 캐스팅해줘야해
		
		
//		for(Object n: num2) {
//			System.out.println((int)n);
//		}
	}
}











