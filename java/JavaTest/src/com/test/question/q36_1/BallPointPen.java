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
		return String.format("%s μμ %.1fmm λ³Όν", this.color , this.thickness);
	}

}
