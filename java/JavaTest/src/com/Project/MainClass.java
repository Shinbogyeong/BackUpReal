package com.Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class MainClass {

   private static Scanner scan;
   private final static String DATA1;
   private final static String DATA2;
   private final static String DATA3;
   private static ArrayList<Employee> list;
   private static ArrayList<String> sameName;

   static String id;
   static String pw;

   static {
      scan = new Scanner(System.in);
      DATA1 = "C:\\Project\\직원더미.txt";
      DATA2 = "C:\\Project\\직원연차더미.txt";
      DATA3 = "C:\\Project\\직원출퇴근더미.txt";
      list = new ArrayList<Employee>();
      sameName = new ArrayList<String>();
      
   }

   public static void main(String[] args) {

     // load();

      //System.out.println("[프로젝트]");

      //login();
      
      //dummy();
	  time();
	  
	  //System.out.println(sameName);
	// no();
      
   }// main

   
//   2021-05-07■임현래■07:54■19:01
//   2021-05-07■유빛혜■08:51■19:48
//   2021-05-07■한나운■07:56■18:52
//   2021-05-07■조윤수■08:46■19:02
//   2021-05-07■백대지■08:34■19:13
//   2021-05-07■신지민■07:46■18:49
   
private static void no() {
	 try {

         BufferedReader reader = new BufferedReader(new FileReader(DATA3));

         String line = "";

         while ((line = reader.readLine()) != null) {

        	 
        	 String[] temp = line.split("■");
        	 
        	 String date = temp[0];
        	 String name = temp[1];
        	 
        	 
        	 for( int i=0; i<sameName.size(); i++) {
        		 
        		 if(sameName.get(i).equals(date+"■"+name)) {
        			 System.out.println(sameName.get(i));
        		 }
        		 
        	 }
        	 
        	 

           

         } // while

         reader.close();

         } catch (Exception e) {
         System.out.println("load: " + e);
      }
   
	
}




//   DATA2 = "C:\\Project\\직원연차더미.txt";
//   DATA3 = "C:\\Project\\직원출퇴근더미.txt";
   
   
   private static void time() {
	   
	   
	   try {

	         BufferedReader reader = new BufferedReader(new FileReader(DATA2));

	         String line = "";
	         

	         while ((line = reader.readLine()) != null) {

	            String[] temp = line.split("■");
	            
	            String name = temp[0];
	            //System.out.println(name);
	            
	            while(!(line= reader.readLine()).equals("=============")) {
	            	
	            	String[] temp123 = line.split(",");//연차 날짜
	            	
	            	int num = temp123.length;//5

	            	//System.out.println(num);

	            	
	            	for (int i=0; i<num; i++) {
	            		
	            		BufferedReader reader123 = new BufferedReader(new FileReader(DATA3));
	            		String line123 = "";
	            		String result = "";
	            		
	            		while((line123 = reader123.readLine()) != null) {
		            		String[] temp12345 = line123.split("■");
		            		
		            		String date = temp12345[0];
		            		String dateName = temp12345[1];
		    
		            		
		            		
		            		if(temp123[i].equals(date) && dateName.equals(name)) {
		            			sameName.add(date+"■"+name);
		            		} else {
		            			result += line123 + "\r\n";
		            		}
		            		
		            	}
	            		
	            		BufferedWriter writer = new BufferedWriter(new FileWriter(DATA3));
	        			
	        			writer.write(result);
	        			
	        			writer.close();
	            		
	            		
	            	}
	            	
	            	
	            	
	            	
	            }
	           
	            
	           

	         } // while

	         reader.close();

	      } catch (Exception e) {
	         System.out.println("load: " + e);
	      }
	   
	
}




private static void dummy() {

	   try {

	         BufferedReader reader = new BufferedReader(new FileReader(DATA1));

	         String line = "";

	         while ((line = reader.readLine()) != null) {

	            Employee employee = new Employee();

	            // 1■김민수■인사부■부장■2014-12-07■20147245■1973-04-02■010-7599-0093■성남시 강남구 신도림동 195번지

	            String[] temp = line.split("■");

	            employee.setName(temp[1]);
	            employee.setDivision(temp[2]);
	            employee.setPosition(temp[3]);
	            employee.setJoinDate(temp[4]);
	            employee.setEmployeeNum(temp[5]);
	            employee.setBirth(temp[6]);
	            employee.setPhoneNum(temp[7]);
	            employee.setAddress(temp[8]);
	            
	            int num = (int)(Math.random() * 6) + 6;
	            
	            String[] yeuncha = new String[12-num];
	            
	            System.out.printf("%s■%s■%s■%d■%d\n"
	            		, temp[1], temp[2], temp[3],  num, 12-num);
	            
	            //----------------------------------
	            
	            
	            for(int i=0; i<12-num; i++	) {
	            	
	            	Calendar now = Calendar.getInstance();
	            	
	            	int month = (int) (Math.random() * 5) + 1;
		            int date = (int) (Math.random() * 28) + 1;
		            
		            now.set(2021, month-1, date);
		            
		            
		            Calendar c = m1(now);
		            
		            
	            	//yeuncha[i] = String.format("2021-%02d-%02d,", month, date);
		            yeuncha[i] = String.format("%tF,", c);
	            	
	            	System.out.print(yeuncha[i]);
	            	
	            	if(i==11-num) {
	            		System.out.println("\b\n=============");
	            	}
	            	
	            
	            
	            
	            } 

	            
	            
	           

	         } // while

	         reader.close();

	         } catch (Exception e) {
	         System.out.println("load: " + e);
	      }
	   

}





private static Calendar m1(Calendar now) {

	if(now.get(Calendar.DAY_OF_WEEK)>1 && now.get(Calendar.DAY_OF_WEEK)<7 ) {
		return now;
	} else {
		now = Calendar.getInstance();
    	
    	int month = (int) (Math.random() * 5) + 1;
        int date = (int) (Math.random() * 28) + 1;
        
        now.set(2021, month-1, date);
		return m1(now);
	}
}




private static void load() {

      try {

         BufferedReader reader = new BufferedReader(new FileReader(DATA1));

         String line = "";

         while ((line = reader.readLine()) != null) {

            Employee employee = new Employee();

            // 1■김민수■인사부■부장■2014-12-07■20147245■1973-04-02■010-7599-0093■성남시 강남구 신도림동 195번지

            String[] temp = line.split("■");

            employee.setName(temp[1]);
            employee.setDivision(temp[2]);
            employee.setPosition(temp[3]);
            employee.setJoinDate(temp[4]);
            employee.setEmployeeNum(temp[5]);
            employee.setBirth(temp[6]);
            employee.setPhoneNum(temp[7]);
            employee.setAddress(temp[8]);

            list.add(employee);

         } // while

         reader.close();

      } catch (Exception e) {
         System.out.println("load: " + e);
      }

   }// load

   private static void login() {

      System.out.println("===================");
      System.out.print("ID: ");
      id = scan.nextLine();
      System.out.println("");
      System.out.print("PW: ");
      pw = scan.nextLine();
      
      int i=0;
      for (Employee e : list) {
         i++;
         if (id.equals("root")) {
            if (pw.equals("0000")) {
               System.out.println("===================");
               System.out.println("관리자 등록");
               break;
            } else {
               System.out.println("===================");
               System.out.println("비밀번호가 틀렸습니다.");
               login();
               break;
            }
         } else if (e.getEmployeeNum().equals(id)) {

            int index = e.getPhoneNum().lastIndexOf("-");
            e.getPhoneNum().substring(index + 1);
            if (pw.equals(e.getPhoneNum().substring(index + 1))) {
               System.out.println("===================");
               System.out.printf("%s로그인 완료\n", e.getName());
               //EmployeeOption em = new EmployeeOption();
               //em.option();
               break;
            }else {
               System.out.println("===================");
               System.out.println("비밀번호가 틀렸습니다.");
               login();
               break;
            }
            
         } else {
            if(i==99) {
               System.out.println("===================");
               System.out.println("다시 입력하세요.");
               login();
            }
         }

      }

   
   }

}// Project