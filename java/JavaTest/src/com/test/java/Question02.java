package com.test.java;

public class Question02 {
	public static void main(String[] args) {
		
		/*
		 [학생] [국어]  [영어]  [수학]  [평균]
		----------------------------------------------
		홍길동	80 		90 	  95 	  88
		아무개 	76		86 	  79 	  80
		하하하 	89 		92 	  85 	  88
		 
		 데이터(이름,국어,영어,수학 x 3개)를 저장할 변수를 각각 만드시오.
		 */
		String name1 = "홍길동";
		String name2 = "아무개";
		String name3 = "하하하";
		
		int korScore_1 = 80;
		int engScore_1 = 90;
		int mathScore_1 = 95;

		int korScore_2 = 76;
		int engScore_2 = 86;
		int mathScore_2 = 79;
		
		int korScore_3 = 89;
		int engScore_3 = 92;
		int mathScore_3 = 85;
		
		System.out.println("[학생]	[국어]	[영어]	[수학]	[평균]");
		System.out.println("--------------------------------------");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t", name1, korScore_1, engScore_1, mathScore_1, (korScore_1 + engScore_1 + mathScore_1)/3);
		
		System.out.printf("%s\t%d\t%d\t%d\t%d\t", name2, korScore_2, engScore_2, mathScore_2, (korScore_2 + engScore_2 + mathScore_2)/3);
		
		System.out.printf("%s\t%d\t%d\t%d\t%d\t", name3, korScore_3, engScore_3, mathScore_3, (korScore_3 + engScore_3 + mathScore_3)/3);
		
	
	}

}
