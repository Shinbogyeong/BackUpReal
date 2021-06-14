package com.project.employee;

/**
 * 연말정산을 위한 사원들의 정보를 받기 위한 get/set이다
 * 사원 이름, 부서, 직책, 사원번호를 받는 클래스이다.
 * @author 3조
 */

public class yearcallist {

   private String Name;
   private String Division;
   private String position;
   private String EmployeeNum;
   
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
      return position;
   }
   public void setPosition(String position) {
      this.position = position;
   }
   public String getEmployeeNum() {
      return EmployeeNum;
   }
   public void setEmployeeNum(String employeeNum) {
      EmployeeNum = employeeNum;
   }
   
   
}