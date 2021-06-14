package com.project.employee;

/**
 * 
 * 전체 사원들의 인적사항들을 담는 Getter, Setter
 * 사원들의 이름, 부서, 직급, 입사일, 사원번호, 생년월일,
 * 핸드폰번호, 주소들의 값들을 담아준다.
 * @author 3조
 *
 */
public class employee {   // 사원들의 모든 정보를 담는 get/set
   
   private String Name;         //사원 이름
   private String Division;      //사원 부서
   private String Position;      //사원 직급
   private String JoinDate;      //사원 입사일
   private String EmployeeNum;      //사원 번호
   private String Birth;         //사원 생년월일
   private String PhoneNum;      //사원 핸드폰 번호
   private String Address;         //사원 주소
   
   public String getName() {
      return Name;
   }
   public void setName(String name) {
      Name = name;
   }
   public String getDivision() {
      return Division;
   }
   public void setDivision(String division) {
      Division = division;
   }
   public String getPosition() {
      return Position;
   }
   public void setPosition(String position) {
      Position = position;
   }
   public String getJoinDate() {
      return JoinDate;
   }
   public void setJoinDate(String joinDate) {
      JoinDate = joinDate;
   }
   public String getEmployeeNum() {
      return EmployeeNum;
   }
   public void setEmployeeNum(String employeeNum) {
      EmployeeNum = employeeNum;
   }
   public String getBirth() {
      return Birth;
   }
   public void setBirth(String birth) {
      Birth = birth;
   }
   public String getPhoneNum() {
      return PhoneNum;
   }
   public void setPhoneNum(String phoneNum) {
      PhoneNum = phoneNum;
   }
   public String getAddress() {
      return Address;
   }
   public void setAddress(String address) {
      Address = address;
   }
   
   
   
}