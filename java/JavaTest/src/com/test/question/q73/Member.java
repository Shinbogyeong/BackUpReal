package com.test.question.q73;

//2018-8-13,길수명,8:23,18:50
//2018-8-13,이무게,8:55,16:49
//2018-8-13,정형유,8:12,19:29

public class Member {

	private String name;
	private int late;
	private int leave;
	
	public Member() {
		name = "";
		late = 0;
		leave = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public int getLeave() {
		return leave;
	}

	public void setLeave(int leave) {
		this.leave = leave;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", late=" + late + ", leave=" + leave + "]\n";
	}
	
}
