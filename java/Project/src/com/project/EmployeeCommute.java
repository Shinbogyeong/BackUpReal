package com.project;


/**
 *출퇴근 더미가 저장되어 있는 파일을
 *ArrayList배열에 담기 위해 직원들의 출퇴근 정보가 담겨있는 클래스
 *(근무날짜, 직원이름, 출근시간, 퇴근시간, 사원번호를 담기위한 변수를 선언하고
 *Setter, Getter를 통해 초기화하고 값을 반환해준다.)
 * @author 3조
 *
 */
public class EmployeeCommute {
	
	private String commuteDay;	//근무날짜
	private String name;		//직원이름
	private String startTime;	//출근시간
	private String endTime;		//퇴근시간
	private String employeeNum;	//사원번호
	
	
	public String getCommuteday() {
		return commuteDay;
	}
	public void setCommuteDay(String commuteday) {
		this.commuteDay = commuteday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getEmployeeNum() {
		return employeeNum;
	}
	
	public void setEmployeeNum(String employeeNum) {
		// TODO Auto-generated method stub
		this.employeeNum = employeeNum;
	}
	@Override
	public String toString() {
		return "EmployeeCommute [commuteDay=" + commuteDay + ", name=" + name + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", employeeNum=" + employeeNum + "]";
	}
	
	
	
}
