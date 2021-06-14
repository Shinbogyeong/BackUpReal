package com.project.employee;

import java.util.ArrayList;


/**
 * 직원들의 상세한 연차 정보를 담고 있는 클래스입니다.
 * @author 3조
 */

public class AnnualLeaveReason {
	
	private String name;
	private String division;
	private String position;
	private String remainvalue;
	private String usedvalue;
	private String date;
	private String type;
	private String reason;
	private String aplyDate;
	private String check;
	
	 /**
	  * 직원의 이름, 부서, 직책, 남은연차, 사용연차, 사용날짜, 연차종류, 연차사유, 제출날짜, 연차태를 초기화하고 반환할수 있는 메서드입니다.
	  */
	 
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getRemainvalue() {
		return remainvalue;
	}
	public void setRemainvalue(String remainvalue) {
		this.remainvalue = remainvalue;
	}
	public String getUsedvalue() {
		return usedvalue;
	}
	public void setUsedvalue(String usedvalue) {
		this.usedvalue = usedvalue;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAplyDate() {
		return aplyDate;
	}
	public void setAplyDate(String aplyDate) {
		this.aplyDate = aplyDate;
	}
	@Override
	public String toString() {
		return "AnnualLeaveReason [name=" + name + ", division=" + division + ", position=" + position
				+ ", remainvalue=" + remainvalue + ", usedvalue=" + usedvalue + ", date=" + date + ", type=" + type
				+ ", reason=" + reason + ", aplyDate=" + aplyDate + ", check=" + check + "]";
	}
	

	
	
}
