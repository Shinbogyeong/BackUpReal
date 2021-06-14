package com.test.question.q36_1;

public class BallPointPen {
	
	private double thickness;
	private String color;
	
	
	public void setTickness(double d){
		this.thickness = d;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	public String info() {
		return String.format("%s 색상 %.1fmm 볼펜", this.color , this.thickness);
	}

}
