package com.test.java.collection;

import java.util.Arrays;

public class Ex68_Queue {

	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		
		System.out.println(queue);
		
		queue.add("빨강");
		System.out.println(queue);
		
		queue.add("파랑");
		System.out.println(queue);
		
//		queue.poll();
//		System.out.println(queue);
	}//main
}


class MyQueue{
	
	private String[] list;
	private int index;
	
	public MyQueue() {
		this.list = new String[4];
		this.index = 0;
	}

	@Override
	public String toString() {
		return String.format("length: %d\nindes: %d\n%s\n"
							, this.list.length
							, this.index
							, Arrays.toString(this.list));
	}
	
	public void add(String value) {
		
		doubling();
		
		list[index] = value;
		index++;
	}

	private void doubling() {
		if(this.index >= list.length){
			String temp[] = new String[this.index*2];
			
			for(int i=0; i<index; i++) {
				temp[i] = list[i];
			}
			
			this.list = temp;
			
		}
	}
	
	
	public String poll() {
		
		//부정 전처리 - 잘못된 상황을 먼저 발견해서 업무 중지
		if (this.index == 0) {
			return null;
		}
		
		String temp = this.list[0]; //첫번째 공
		
		//좌측 시프트
		for (int i=0; i<this.index -1; i++) {
			this.list[i] = this.list[i+1];
		}
		
		this.index--;
		
		return temp;
		
//		if (this.index != 0) {
//			//업무 블럭
//			String temp = this.list[0]; //첫번째 공
//			
//			//좌측 시프트
//			for (int i=0; i<this.index -1; i++) {
//				this.list[i] = this.list[i+1];
//			}
//			
//			this.index--;
//			
//			return temp;	
//		} else {
//			//예외처리
//			return null;
//		}
		
	}
	
	public int size(){
		return this.index;
	}
	
	public String peek()	{
		return this.list[0];
	}
	
	public void clear() {
		this.index = 0;
	}
	
}