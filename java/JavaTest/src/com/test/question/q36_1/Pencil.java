package com.test.question.q36_1;

public class Pencil {
	
	private String hardness;

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}
	
	public String info() {
		return String.format("%s 진하기 연필", this.hardness);
	}

}
