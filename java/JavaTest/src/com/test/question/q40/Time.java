package com.test.question.q40;

public class Time {
	
	private int hour;
	private int minute;
	private int second;
	
	public Time(){
		this(0, 0, 0);
	}

	public Time(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	

	public Time(int minute, int second) {
		this(0, minute, second);
	}

	
	public Time(int second) {
		this(0, 0, second);
	}
	
	String info() {
		
		if(this.second / 60 > 0) {//second를 minute보다 먼저 계산
			this.minute += this.second/ 60;
			this.second = this.second % 60;
		}
		
		if(this.minute / 60 > 0) {
			this.hour += this.minute/ 60;
			this.minute = this.minute % 60;
		}
		
		
		
		return String.format("%d:%d:%d\n", this.hour, this.minute, this.second);
	}


}
