package com.test.question.q68;

import java.util.Arrays;



public class MyStack {
	
	private String[] list;
	private int index;
	
	public MyStack() {//기본생성자
		this.list = new String[4];
		this.index = 0;
	}

	@Override
	public String toString() {
		return String.format("length: %d\nindex: %d\n%s\n"
							, this.list.length
							, this.index
							, Arrays.toString(this.list));
	}
	
	public void push(String value) {
		
		doubling();
		
		this.list[index] = value;
		this.index++;
	}

	
	private void doubling() {
		if(this.index >= list.length){
			String temp[] = new String[this.index*2];
			for(int i=0; i<index; i++) {
				temp[i] = this.list[i];
			}
			this.list = temp;
		}
	}
	
	
	public String pop() {
		this.index--;
		return this.list[index];
	}
	
	
	public int size() {
		return this.index;
	}
	
	public String peek() {
		return this.list[index-1];
	}
	
	public void clear() {
		this.index = 0;
	}
	
	public void trimToSize() {
		String[] temp = new String[index];//요소 개수만큼의 배열크기 만듬
		for (int i=0; i<index; i++) {//깊은 복사
			temp[i] = list[i];
		}
		this.list = temp;
	}
}
