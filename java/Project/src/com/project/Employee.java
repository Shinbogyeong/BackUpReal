package com.project;

/**
 * 직원들이 갖는 정보를 담은 클래스.
 * (이름, 부서, 직책, 입사일, 사원번호, 생년월일, 핸드폰 번호, 주소를 
 * 저장해주고 반환할수 있는 Setter, Getter를 포함한다.)
 * @author 3조
 */
public class Employee {

	private String name;		//이름
	private String division;	//부서
	private String position;	//직책
	private String joinDate;	//입사일
	private String employeeNum;	//사원번호
	private String birth;		//생년월일
	private String phoneNum;	//핸드폰 번호
	private String address;		//주소
	
	/**
	 * 직원 이름을 반환하기 위한 Getter 
	 * @return name : 직원 이름
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * 매개변수로 받아온 데이터를(name)을 직원 이름으로 저장해주기위한 Setter
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 직원 부서를 반환하기 위한 Getter
	 * @return division
	 */
	public String getDivision() {
		return division;
	}
	
	/**
	 * 매개변수로 받아온 데이터를(division)을 직원 부서로 저장해주기위한 Setter
	 * @param division
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	
	/**
	 * 직원 직책을 반환하기 위한 Getter
	 * @return position
	 */
	public String getPosition() {
		return position;
	}
	
	/**
	 * 매개변수로 받아온 데이터를(position)을 직원 직책으로 저장해주기위한 Setter
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * 직원 입사일을 반환하기 위한 Getter
	 * @return joinDate
	 */
	public String getJoinDate() {
		return joinDate;
	}
	
	/**
	 * 매개변수로 받아온 데이터를(position)을 직원 입사일로 저장해주기위한 Setter
	 * @param joinDate
	 */
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	/**
	 * 직원 사원번호를 반환하기 위한 Getter
	 * @return employeeNum
	 */
	public String getEmployeeNum() {
		return employeeNum;
	}
	
	/**
	 * 매개변수로 받아온 데이터를(employeeNum)을 직원 사원번호로 저장해주기위한 Setter
	 * @param employeeNum
	 */
	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}
	
	/**
	 * 직원 생년월일를 반환하기 위한 birth
	 * @return birth
	 */
	public String getBirth() {
		return birth;
	}
	
	/**
	 * 매개변수로 받아온 데이터를(birth)을 직원 생년월일로 저장해주기위한 Setter
	 * @param birth
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	/**
	 * 직원 핸드폰번호로 반환하기 위한 phoneNum
	 * @return phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	/**
	 * 매개변수로 받아온 데이터를(phoneNum)을 직원 핸드폰번호로 저장해주기위한 Setter
	 * @param phoneNum
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	/**
	 * 직원 주소로 반환하기 위한 address
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 매개변수로 받아온 데이터를(address)을 직원 주소로 저장해주기위한 Setter
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	/**
	 * 직원정보를 좀 더 편하게 확인하고자 오버라이딩한 toString
	 */
	@Override
	public String toString() {
		return "Employee [name=" + name + ", division=" + division + ", position=" + position + ", joinDate=" + joinDate
				+ ", employeeNum=" + employeeNum + ", birth=" + birth + ", phoneNum=" + phoneNum + ", address="
				+ address + "]";
	}
	
	
}//Employee
