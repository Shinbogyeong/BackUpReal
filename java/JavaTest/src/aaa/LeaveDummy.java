package aaa;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import lombok.ToString;

public class LeaveDummy {
	
	public static final String DATA1;
	public static final String DATA2;
	public static final String DATA3;
	public static ArrayList<String> info;
	
	static {
		DATA1 = "C:\\Project\\직원더미.txt";
	    DATA2 = "C:\\Project\\직원연차더미.txt";
	    DATA3 = "C:\\Project\\직원연차사유더미.txt";
	    info = new ArrayList<String>();
	}
	
	public static void main(String[] args) {
//		try {
//			//
//				         BufferedReader reader = new BufferedReader(new FileReader(DATA3));
//			
//				         String line = "";
//				         String newLine = "";
//			
//				         while ((line = reader.readLine()) != null) {
//			
//				        	 String[] temp = line.split("■");
//				        	 String date = temp[5];
//				        	 String newDate = "2021-" + date.substring(5,7)+ "-";
//				        	 
//				        	 if(Integer.parseInt(date.substring(8,10))>3) {
//				        		 
//				        		 newDate += String.format("%02d", Integer.parseInt(date.substring(8,10)) - 3) ;
//				        	 } else if (Integer.parseInt(date.substring(8,10)) == 3	|| Integer.parseInt(date.substring(8,10)) == 2	) {
//				        		 newDate += "01";
//				        	 } else {
//				        		 newDate = "2021-01-01";
//				        		 
//				        	 }
//				        	 
//				        	 System.out.println(temp[0] + "■" + temp[1]+ "■" + temp[2] + "■" +temp[3] + "■" + temp[4] + "■" + temp[5] + "■" + temp[6]+ "■" + temp[7]+ "■" + newDate);
//				        	 System.out.println("===========");
//				        	 while(!(line = reader.readLine()).equals("===========")) {
//				        		 
//				        	 }
//				        	 info.add(newDate);
//				        	 
//				        	 
//				        	
//				        	 
//				        	 
//			
//				           
//			
//				         } // while
//			
//				         reader.close();
//			
//				         } catch (Exception e) {
//				         System.out.println("load: " + e);
//				         
//				      }
		
		try {

	         BufferedReader reader = new BufferedReader(new FileReader(DATA2));

	         String line = "";
	         String newLine = "";

	         while ((line = reader.readLine()) != null) {

	        	 String[] temp = line.split("■");
	        	 newLine = temp[0] + "■" + temp[1] +"■" +  temp[2] +"■" +  temp[3] +"■" +  temp[4]+ "■" ;
	        	 
	        	 while (!(line = reader.readLine()).equals("=============")) {
	        		 String[] ttemp = line.split(",");
	        		 for ( int i=0; i<ttemp.length ; i++) {
	        			 String a = newLine;
	        			 
	        			 String[] temp1 = new String [3];
	        				temp1[0]  = "오전반차";
	        				temp1[1] = "오후반차";
	        				temp1[2] = "연차";
	        				

	        				//연차사유
	        				String[] temppp = new String[10];
	        				temppp[0] = "개인적인 사유로 인한 연차 신청입니다.";
	        				temppp[1] = "병원방문으로 인해 연차 사용합니다.";
	        				temppp[2] = "제사참석을 위해 고향방문 해야해서 연차 사용합니다.";
	        				temppp[3]= "가정사로 인래 연차 사용합니다.";
	        				temppp[4] = "은행방문으로 인해 연차 사용합니다.";
	        				temppp[5] = "가정사로 인래 연차 사용합니다.";
	        				temppp[6] = "식도염로 인해 내시경 검사가 필요합니다.";
	        				temppp[7] = "디스크로 인해 병원방문이 필요합니다.";
	        				temppp[8] = "여행으로 인해 연차 사용합니다.";
	        				temppp[9] = "자녀가 아파서 연차 사용합니다.";

	        				int num1 = (int)(Math.random() * 3);
	        				int num = (int)(Math.random() * 10);
	        				
	        			 newLine += ttemp[i] + "■" +temp1[num1]+"■"+temppp[num] + "■";
	        			 
	        			 String date = ttemp[i];
	        			 String newDate = "2021-" + date.substring(5,7)+ "-";
	        			 
	        			 if(Integer.parseInt(date.substring(8,10))>3) {
	        				 
	        				 newDate += String.format("%02d", Integer.parseInt(date.substring(8,10)) - 3) ;
	        			 } else if (Integer.parseInt(date.substring(8,10)) == 3	|| Integer.parseInt(date.substring(8,10)) == 2	) {
	        				 newDate += "01";
	        			 } else {
	        				 newDate = "2021-01-01";
	        				 
	        			 }
	        			 System.out.println(newLine+ newDate + "■" + "결재완료");
	        			 System.out.println("===========");
	        			 newLine=a;
	        		 }
	        	 }
	        	 
	        	 
	        	
	        	 
	        	 

	           

	         } // while

	         reader.close();

	         } catch (Exception e) {
	         System.out.println("load: " + e);
	         
	      }
		
		
		
		
		
		//System.out.println(info);
		
		
//		for(int i=0; i<info.size(); i++) {
//			
//			//연차종류
//			String[] temp1 = new String [3];
//			temp1[0]  = "오전반차";
//			temp1[1] = "오후반차";
//			temp1[2] = "연차";
//			
//
//			//연차사유
//			String[] temp = new String[10];
//			temp[0] = "개인적인 사유로 인한 연차 신청입니다.";
//			temp[1] = "병원방문으로 인해 연차 사용합니다.";
//			temp[2] = "제사참석을 위해 고향방문 해야해서 연차 사용합니다.";
//			temp[3]= "가정사로 인래 연차 사용합니다.";
//			temp[4] = "은행방문으로 인해 연차 사용합니다.";
//			temp[5] = "가정사로 인래 연차 사용합니다.";
//			temp[6] = "식도염로 인해 내시경 검사가 필요합니다.";
//			temp[7] = "디스크로 인해 병원방문이 필요합니다.";
//			temp[8] = "여행으로 인해 연차 사용합니다.";
//			temp[9] = "자녀가 아파서 연차 사용합니다.";
//
//			int num1 = (int)(Math.random() * 3);
//			int num = (int)(Math.random() * 10);
//			
//			
//			System.out.println(info);
//			
//			System.out.println(info.get(i)+"■"+temp[num]+"■"+temp1[num1] + "■");
//			System.out.println("===========");
//		}
		
		
		
		
		
	}

}//main
