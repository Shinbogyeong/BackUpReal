package com.test.question.q36_1;

import java.text.Format;

public class Eraser {
	
	private String size;

	public void setSize(String size) {
		this.size = size;
	}
	
	public String info() {
		return String.format("%s 사이즈 지우개"	, this.size);
	}

}
