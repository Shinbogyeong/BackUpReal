package com.project.employee;


/**
 * 포인트 저장할때 필요한 정보를 get/set에 담는다.
 * 사원마다 포인트가 다른것을 저장해주기 위한 클래스이다.
 * @author 3조
 */
public class point {
   private String EmployeeNum;      //사원 번호
   private int point;            //포인트
   public String getEmployeeNum() {
      return EmployeeNum;
   }
   public void setEmployeeNum(String employeeNum) {
      EmployeeNum = employeeNum;
   }
   public int getPoint() {
      return point;
   }
   public void setPoint(int point) {
      this.point = point;
   }
}