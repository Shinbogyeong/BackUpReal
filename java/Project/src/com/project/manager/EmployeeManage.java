package com.project.manager;

import java.io.FileNotFoundException;

//import project.src.project1.management;

/**
 * 관리자가 직원 관리를 하기 위한 클래스입니다.
 * (클래스내에 직원관리를 위한 메서드를 담고있습니다.) 
 * @author 3조
 */
public class EmployeeManage {

   public void employeeManage() {
      management manage = new management();
      try {
         manage.empllist();
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      manage.menu();
      manage.save();
      }
   
}