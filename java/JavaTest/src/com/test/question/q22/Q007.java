package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		
		System.out.println("누적값 입력: ");
		int num = Integer.parseInt(reader.readLine());
		
		
		for(int i=1;; i++) {			
			System.out.printf("%d",i);
			sum += i;
			
			if(sum >= num) {
				break;
			}else {
				System.out.printf(" + ");
			}
			
			}
		
		System.out.printf(" = " + sum);
		
	}
}


//	public static void main(String[] args) {
//	    
//	    int sum = 0;
//	    int i;
//	    
//	    for(i= 1; ; i++) {
//	       sum += i;
//	       
//	       if(sum > 1000) {
//	          System.out.printf("%d = %d",i, sum);
//	          break;
//	       }else {
//	          System.out.printf("%d + ",i );            
//	       }
//	 
//	    }//for문
//	    
//	 }//main
