package aaa;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Dummy {

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
	  //time();
	  
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



/*
--시험문제
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 시험문제, 답, 시험지등록번호);

--1강의실
-- java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. System.out.print("10 + 20 = " + 10 + 20);', 'X', 1);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. System.out.print(010);', 'O', 1);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 시각 - 시각의 결과는 시간이다.', 'O', 1);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 자바의 index는 1부터 시작한다.', 'X', 1);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. indexOf() 메소드는 검색어의 위치를 반환한다.', 'O', 1);

-- 오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 2);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 '123'이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 2);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 2);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 2);

-- 백엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q1. Get과 Post 차이점?', '-Get:주로 웹 브라우저가 웹 서버에 데이터를 요청할 때 사용 -Post:는 웹 브라우저가 웹 서버에 데이터를 전달하기 위해 사용.', 3);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q2. Session과 Cookie 사용 이유', '- Session에 관련된 데이터는 Server에 저장된다. - 사용자 정보를 유지할 수 없다는 HTTP의 한계를 극복할 수 있는 방법', 3);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q3. MVC란?', '- MVC 패턴은 목적 코드의 재사용에 유용한 것은 물론, 사용자 인터페이스와 응용프로그램 개발에 소요되는 시간을 현저하게 줄여주는 형식이라고 많은 개발자들이 평가하고 있다.', 3);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. Singleton Design Patter(싱글톤 디자인 패턴, 싱글톤 패턴)이란?', '- 클래스 인스턴스가 하나만 만들어지도록 하고, 그 인스턴스에 대한 전역 접근을 제공한다.', 3);

-- 아두이노를 활용한 임베디드 프로그래밍
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. ALU의 Full Name은 무엇인가?', 'Arthmetic Lojic Unit', 4);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. SoC(System On chip)에 대해 설명하시오', '하나의 집적회로에 집적된 컴퓨터나 전자 시스템 부품들을 가르킨다.', 4);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 임베디드란 무엇인가?', '임베디드란 PC이외의 장비에 사용되는 칩을 말한다.', 4);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 임베디드 시스템에는 어떤 프로세서 코어가 장착될수 있는지 설명하시오', '마이크로컨트롤러, DSP', 4);

--2강의실
--java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. 명시적인 형변환은 항상 안전하다.', 'X', 7);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. 대입 연산자는 우선 순위가 가장 낮다.', 'O', 7);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. float는 실수형이고, 4byte의 크기를 가진다.', 'X', 7);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. int는 실수형이고, 8byte의 크기를 가진다.', 'O', 7);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. long을 float로 형변환할 때 암시적인 형변환이 일어난다.', 'O', 7);

--오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 8);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 '123'이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 8);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 8);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 8);

--프론트엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. CSS 전처리(CSS preprocessors)설명과 장단점?','[장점]재사용성: 공통 요소를 변수 또는 함수, 믹스인으로 만들어 재사용할 수 있다.[단점] 전처리기를 위한 도구(컴파일러) 필요', 9);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. CSS Selector가 어떠한 원리로 동작하는지 설명', '브라우저는 선택자를 오른쪽 키 선택자부터 왼쪽으로 일치시킨다. 선택자에 따라 DOM의 요소를 필터링하고 부모요소를 검사해 일치하는지 본다.', 9);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. UI와 UX의 차이점을 설명해보세요.', 'UI: 사용자가 제품/서비스와 상호작용할 수 있도록 만들어진 매개체. UX:사용자가 만족할 수 있도록 사용자 중심적으로 설계된 디자인', 9);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. XSS(Cross-site scripting)를 설명해보세요.', '특정 javascript 구문을 client side에서 hacker가 원하는 시점에 실행시키는 공격이다.', 9);



--3강의실
-- java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. System.out.print("10 + 20 = " + 10 + 20);', 'X', 13);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. System.out.print(010);', 'O', 13);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 시각 - 시각의 결과는 시간이다.', 'O', 13);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 자바의 index는 1부터 시작한다.', 'X', 13);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. indexOf() 메소드는 검색어의 위치를 반환한다.', 'O', 13);

-- 오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 14);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 '123'이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 14);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 14);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 14);

-- 백엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q1. Get과 Post 차이점?', '-Get:주로 웹 브라우저가 웹 서버에 데이터를 요청할 때 사용 -Post:는 웹 브라우저가 웹 서버에 데이터를 전달하기 위해 사용.', 15);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q2. Session과 Cookie 사용 이유', '- Session에 관련된 데이터는 Server에 저장된다. - 사용자 정보를 유지할 수 없다는 HTTP의 한계를 극복할 수 있는 방법', 15);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q3. MVC란?', '- MVC 패턴은 목적 코드의 재사용에 유용한 것은 물론, 사용자 인터페이스와 응용프로그램 개발에 소요되는 시간을 현저하게 줄여주는 형식이라고 많은 개발자들이 평가하고 있다.', 15);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. Singleton Design Patter(싱글톤 디자인 패턴, 싱글톤 패턴)이란?', '- 클래스 인스턴스가 하나만 만들어지도록 하고, 그 인스턴스에 대한 전역 접근을 제공한다.', 15);



--4강의실
--java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. 명시적인 형변환은 항상 안전하다.', 'X', 20);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. 대입 연산자는 우선 순위가 가장 낮다.', 'O', 20);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. float는 실수형이고, 4byte의 크기를 가진다.', 'X', 20);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. int는 실수형이고, 8byte의 크기를 가진다.', 'O', 20);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. long을 float로 형변환할 때 암시적인 형변환이 일어난다.', 'O', 20);

--오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 21);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 '123'이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 21);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 21);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 21);

--프론트엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. CSS 전처리(CSS preprocessors)설명과 장단점?','[장점]재사용성: 공통 요소를 변수 또는 함수, 믹스인으로 만들어 재사용할 수 있다.[단점] 전처리기를 위한 도구(컴파일러) 필요', 22);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. CSS Selector가 어떠한 원리로 동작하는지 설명', '브라우저는 선택자를 오른쪽 키 선택자부터 왼쪽으로 일치시킨다. 선택자에 따라 DOM의 요소를 필터링하고 부모요소를 검사해 일치하는지 본다.', 22);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. UI와 UX의 차이점을 설명해보세요.', 'UI: 사용자가 제품/서비스와 상호작용할 수 있도록 만들어진 매개체. UX:사용자가 만족할 수 있도록 사용자 중심적으로 설계된 디자인', 22);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. XSS(Cross-site scripting)를 설명해보세요.', '특정 javascript 구문을 client side에서 hacker가 원하는 시점에 실행시키는 공격이다.', 22);

-- 백엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q1. Get과 Post 차이점?', '-Get:주로 웹 브라우저가 웹 서버에 데이터를 요청할 때 사용 -Post:는 웹 브라우저가 웹 서버에 데이터를 전달하기 위해 사용.', 23);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q2. Session과 Cookie 사용 이유', '- Session에 관련된 데이터는 Server에 저장된다. - 사용자 정보를 유지할 수 없다는 HTTP의 한계를 극복할 수 있는 방법', 23);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q3. MVC란?', '- MVC 패턴은 목적 코드의 재사용에 유용한 것은 물론, 사용자 인터페이스와 응용프로그램 개발에 소요되는 시간을 현저하게 줄여주는 형식이라고 많은 개발자들이 평가하고 있다.', 23);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. Singleton Design Patter(싱글톤 디자인 패턴, 싱글톤 패턴)이란?', '- 클래스 인스턴스가 하나만 만들어지도록 하고, 그 인스턴스에 대한 전역 접근을 제공한다.', 23);

-- 아두이노를 활용한 임베디드 프로그래밍
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. ALU의 Full Name은 무엇인가?', 'Arthmetic Lojic Unit', 24);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. SoC(System On chip)에 대해 설명하시오', '하나의 집적회로에 집적된 컴퓨터나 전자 시스템 부품들을 가르킨다.', 24);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 임베디드란 무엇인가?', '임베디드란 PC이외의 장비에 사용되는 칩을 말한다.', 24);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 임베디드 시스템에는 어떤 프로세서 코어가 장착될수 있는지 설명하시오', '마이크로컨트롤러, DSP', 24);


--5강의실
-- java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. System.out.print("10 + 20 = " + 10 + 20);', 'X', 29);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. System.out.print(010);', 'O', 29);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 시각 - 시각의 결과는 시간이다.', 'O', 29);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 자바의 index는 1부터 시작한다.', 'X', 29);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. indexOf() 메소드는 검색어의 위치를 반환한다.', 'O', 29);

-- 오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 30);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 '123'이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 30);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 30);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 30);

-- 백엔드
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q1. Get과 Post 차이점?', '-Get:주로 웹 브라우저가 웹 서버에 데이터를 요청할 때 사용 -Post:는 웹 브라우저가 웹 서버에 데이터를 전달하기 위해 사용.', 31);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q2. Session과 Cookie 사용 이유', '- Session에 관련된 데이터는 Server에 저장된다. - 사용자 정보를 유지할 수 없다는 HTTP의 한계를 극복할 수 있는 방법', 31);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval,'Q3. MVC란?', '- MVC 패턴은 목적 코드의 재사용에 유용한 것은 물론, 사용자 인터페이스와 응용프로그램 개발에 소요되는 시간을 현저하게 줄여주는 형식이라고 많은 개발자들이 평가하고 있다.', 31);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. Singleton Design Patter(싱글톤 디자인 패턴, 싱글톤 패턴)이란?', '- 클래스 인스턴스가 하나만 만들어지도록 하고, 그 인스턴스에 대한 전역 접근을 제공한다.', 31);


--6강의실
-- java
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. System.out.print("10 + 20 = " + 10 + 20);', 'X', 35);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. System.out.print(010);', 'O', 35);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. 시각 - 시각의 결과는 시간이다.', 'O', 35);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. 자바의 index는 1부터 시작한다.', 'X', 35);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q5. indexOf() 메소드는 검색어의 위치를 반환한다.', 'O', 35);

-- 오라클
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q1. tblInsa. 입사일이 빠른 순서로 5순위까지만 가져오시오.', 'select name, ibsadate, rownum from(select name, ibsadate from tblinsa order by ibsadate asc)where rownum <= "5";', 36);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q2. tblAddressBook. 전화번호에 '123'이 들어간 사람 중 여학생만을 가져오시오.', 'select * from tbladdressbook where tel like "%123%" and gender = "f";', 36);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q3. tblAddressBook. 관리자의 실수로 몇몇 사람들의 이메일 주소가 중복되었다. 중복된 이메일 주소만 가져오시오.', 'select email from tbladdressbook group by email having count(*) >= 2', 36);
INSERT INTO tblTestQuestion VALUES(testQuestionSeq.nextval, 'Q4. tblAddressBook. 현재 주소(address)와 고향(hometown)이 같은 지역인 사람들을 가져오시오.', 'select * from tbladdressbook where address like "%"||hometown||"%" ', 36);

  */
