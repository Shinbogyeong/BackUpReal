package com.test.question.q65;

public class MainClass {
	
	public static void main(String[] args) {
		//1. 더블링 구형
		//2. put() -> 1개로 구현(추개 or 수정)
		//	a. key를 검색 -> 몇번째 방에있는지?
		//	b. a방과 동일한 values에 값을 덮어쓰기
		//3. put() -> 수정
		// 	a. key를 검색 -> 해당 Entry반환 -> 그 Entry 의 value 수정
		
		
		MyHashMap map = new MyHashMap();
		
		map.put("국어", "합격");
		map.put("영어", "불합격");
		map.put("수학", "보류"	);
		
		
		System.out.println(map.get("국어"));
		System.out.println(map.get("영어"));
		System.out.println(map.get("수학"));
		System.out.println(map.get("사회"));
		
		
		//수정
		map.put("영어", "합격");
		System.out.println(map.get("영어"));
		
		
		
		//삭제
		map.remove("영어");
		System.out.println(map.get("영어"));
		
		
		
		//검색
		if(map.contaionKey("국어")) {
			System.out.println("국어 접수 있음");
		} else {
			System.out.println("국어 점수 없음");
		}
		
		
		//검색
		if(map.contaionsValue("합격")) {
			System.out.println("합격 과목 있음");
		} else {
			System.out.println("합격 과목 없음");
		}
		
		//초기화
		map.clear();
		System.out.println(map.size());
		
		
	}

}
