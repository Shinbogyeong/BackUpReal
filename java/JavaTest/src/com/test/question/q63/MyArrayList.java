package com.test.question.q63;

import java.util.Arrays;

public class MyArrayList {
	
	private String[] list;
	private int index;//****중요한 역할(요소가 들어갈 방의 번호)
	
	public MyArrayList() {
		this.list = new String[4];
		this.index = 0;
	}
	
	//add
	public void add(String s) {
		
		//0 -> 1번째
		//1 -> 2번째
		//2 -> 3번째
		//3 -> 4번째
		//4 -> 방이 꽉 찬 상태
		//방이 남아있는지 체크하는 구문
		if(this.index >= this.list.length) {
			//1. 2배 길이의 배열 만든다.
			//2. 기존 배열의 각 방의 값을 새 배열에 복사한다.
			//3. 새 배열은 this.list에 넣는다.
			String[] newList = new String[index * 2];
			
			for(int i=0; i<list.length; i++) {//원래 list크기까지 값 넣어줌
				newList[i] = list[i];
			}
			this.list = newList;
		}
		
		this.list[this.index] = s;
		this.index ++;
	}
	
	//get
	public String get(int index) {
		return this.list[index] ;
		
//		if (index >=0 && index < this.index) { //예외 추가하기
//			return this.list[index];
//		} else {
//			throw new IndexOutOfBoundsException();//예외 던지기
//		}
	}
	
	//size
	public int size() {
		return this.index;
	}
	
	//set
	public void set(int index, String value) {
		this.list[index] = value;
	}
	
	//remove
	public void remove(int index) {
		for(int i=index; i<this.index-1; i++) { //좌측쉬프트
			this.list[i] = this.list[i+1];
		}
		this.index --;
	}
	
	//add
	public void add(int index, String value) {
		 
		if(this.index>= this.list.length) {
			String[] newList = new String[index * 2];
			
			for(int i=0; i<list.length; i++) {//원래 list크기까지 값 넣어줌
				newList[i] = list[i];
			}
			this.list = newList;
		}
		
		for(int i=this.index -1; i>=index; i--) {//우측쉬프트(배열 맨 마지막에서 입력된 요소까지
			this.list[i +1] = this.list[i]; 
		}
		
		
		this.index ++;
		this.list[index] = value;
	}

	//indexOf
	public int indexOf(String value) {
		for(int i=0; i<this.index; i++) {
			if(this.list[i].equals(value)) {
				return 1;
			}
		}
		return -1;
	}
	
	//lastIndexOf
	public int lastIndexOf(String value) {
		for(int i=this.index -1; i>=0; i--) { //배열의 맨뒤에서부터 찾는다.(q
			if(this.list[i].equals(value)) {
				return i;
			} 
		}
		return 0;
	}
	
	public void clear() {
		String[] newlist = new String[list.length];
		this.list = newlist;
		this.index = 0;
	}
	
	@Override
	public String toString() {
		return "MyArrayList [list=" + Arrays.toString(list) + ", index=" + index + "]";
	}

	
}
