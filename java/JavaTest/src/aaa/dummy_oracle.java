package aaa;

import java.util.Calendar;

public class dummy_oracle {

	public static void main(String[] args) {
		
	/*
	 -- 수강신청
		--INSERT INTO tblEnrollment VALUES(enrollmentSeq.nextval, 교사평가 고유번호, 개설과정 고유번호, 교육생 고유번호);

	--개설과정 1, 1강의실, 30명
	INSERT INTO tblEnrollment VALUES(enrollmentSeq.nextval, 1, 1, 1); X 30
	INSERT INTO tblEnrollment VALUES(enrollmentSeq.nextval, 2, 1, 2);
	INSERT INTO tblEnrollment VALUES(enrollmentSeq.nextval, 3, 1, 3);
	 * */	
		
//		for(int i= 203; i<=228; i++) {
//			System.out.printf("INSERT INTO tblEnrollment VALUES(enrollmentSeq.nextval, %d, 8, %d);", i,i);
//			System.out.println();
//		}
		
		
		for(int i= 31; i<=60; i++) {
			System.out.printf("INSERT INTO tblCompleteStudent VALUES(completeStudentSeq.nextval, '2021-03-12', '수료완료', %d);", i);
			System.out.println();
		}
		
	}
	
	public static void completeStudent() {
	      
	      Calendar completeDate = Calendar.getInstance();
	      
	      completeDate.set(Calendar.YEAR, 0);
	      completeDate.set(Calendar.MONTH, 0);
	      completeDate.set(Calendar.DATE, 0);
	      
	      String condition = "";
	      int student = 60;
	      
	      for (int i=0; i<student; i++) {
	      
	         if (completeDate.equals("(null)")) {
	            
	            condition = "중도탈락";
	            
	         } else {
	            
	            condition = "수료";
	            
	         }
	         
	         System.out.printf("INSERT INTO tblCompleteStudent values (completeStudentSeq.nextVal, %tF, %s, tblEnrollment.enrollmentSeq);", completeDate, condition);
	         System.out.println();
	      
	      }
	      
	   }//completeStudent
	
}
