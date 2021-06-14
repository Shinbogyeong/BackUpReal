package com.test.question.q23;

public class Q011 {
	public static void main(String[] args) {
	
		// i가 나눠지는 수를 변수로 num으로 받고, num이 3이상 일때는 출력하지 않음
		int num =0;
		
		for (int i=2; i<=100; i++) {
			
			for (int j=i; j>=1; j--) {
				
				if(i % j == 0) {
					num+=1;
				}	
				
				if(num >= 3) {
					break;
				}
			
			}//for문
			
			if(num == 2) {
				System.out.printf("%d, ", i);	
			}
			num = 0;
		}
		
		System.out.println("\b\b");
		
		
//		//i가 나누어지는 수가 나오면 break 그 수가 본인과 일치하면 출력
//		
//		int i=0; 
//	      int j=0;
//	      
//	      for( i = 2; i<100; i++) {
//	         
//	         for(j = 2; j <= i; j++) {
//	            if(i % j == 0) {
//	               break;
//	            }
//	         }
//	         
//	         if(i == j){
//	            System.out.printf("%d, ", i);      
//	         }
//	      }
//		
		
		
	}

}
