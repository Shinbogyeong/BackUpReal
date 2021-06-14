package com.test.question.q36_1;

public class Ruler {
	
	private int length;
	private String shape;
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public String info() {
		return String.format("%dcm %s", this.length, this.shape);
	}

}
