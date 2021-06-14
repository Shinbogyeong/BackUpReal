package com.test.question.q65;

import java.util.Arrays;

public class MyHashMap {
	
	//case A.
	
	private String[] keys; //키를 담을 배열
	private String[] values; //값을 담을 배열
	private int index; //*** 여전히 중요, 역할 동일
	
	public MyHashMap() {
		this.keys = new String[4];
		this.values = new String[4];
		this.index = 0;
	}
	
	public void put(String key, String value) {
		
		double2();//배열의 방번호를 2배시키는 메소드
		
		//풀이1)
		boolean same = false; //key값이 이미 있는 값인지 확인해보고 있으면 수정 없으면 추가
		
		for(int i=0; i<index; i++) { //수정
			if(this.keys[i].equals(key)) {
				this.values[i] = value;
				same = true;
			}
		}
		 
		if(same == false) {//추가
			this.keys[this.index] = key;
			this.values[this.index] = value;
			this.index++;
		} 
		

		
	}

	//double
	private void double2() {
		if(this.index >= this.keys.length) {
			String[] newKeys = new String[index*2];
			String[] newValues = new String[index*2];
			
			for(int i=0; i<index; i++) {
				newKeys[i] = keys[i];
				newValues[i] = values[i];
			}
			
			this.keys = newKeys;
			this.values = newValues;
			
		}
	}
	

	//get, 읽기
	public String get(String key) {
		for(int i=0; i<index; i++) {
			if(this.keys[i].equals(key))	{
				return this.values[i];
			}
		}
		
		return null;
	}
	
	
	
	//size, 개수
	public int size() {
		return index;
	}
	
	
	//remove, 삭제
	public void remove(String key) {
		for(int i=0; i<this.index; i++) {
			if(this.keys[i].equals(key)) { //key값이 같은걸 찾으면
				
				for(int j=i; j<=index; j++) {
					keys[j] = keys[j+1];//좌측시프트 //HashMap은 삭제시 방이름으로 접근하기 때문에 인덱스만 수정한다.
					values[j] = values[j+1]; 
					index--;
				}
				
			}
		}
	}
	
	
	//containKey, 검색
	boolean contaionKey(String key) {
		for(int i=0; i<this.index; i++) {
			if(this.keys[i].equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	//containsKValue, 검색
	boolean contaionsValue(String value) {
		for(int i=0; i<this.index; i++) {
			if(this.values[i].equals(value)) {
				return true;
			}
		}
		return false;
	}
		
	
	//clear, 검색
	public void clear() {
		this.keys = new String[4];
		this.values = new String[4];
		index = 0;
	}
		
	

}//MyHashMap


class Entry {
	public String key;
	public String value;
	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + "]";
	}
}













