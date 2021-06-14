package com.test.question.q6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("점수 :");
		int score = Integer.parseInt(reader.readLine());
		
		if (score >= 90 && score <= 100) {
			System.out.printf("입력한 %d점은 성적 %s입니다.", score, "A");
		} else if (score >= 80 && score < 90) {
			System.out.printf("입력한 %d점은 성적 %s입니다.", score, "B");
		} else if (score >= 70 && score < 80) {
			System.out.printf("입력한 %d점은 성적 %s입니다.", score, "C");
		} else if (score >= 60 && score < 70) {
			System.out.printf("입력한 %d점은 성적 %s입니다.", score, "D");
		} else if (score >= 0 && score < 60) {
			System.out.printf("입력한 %d점은 성적 %s입니다.", score, "F");
		} else {
			System.out.println("점수가 올바르지 않습니다.");
		}
	
//		char grade;
//	      if(score >= 0 && score <= 100) {
//	         
//	         if(score >= 90) {
//	            grade = 'A';
//	         }else if(score >= 80) {
//	            grade = 'B';
//	         }else if(score >= 70) {
//	            grade = 'C';
//	         }else if(score >= 60) {
//	            grade = 'D';
//	         }else{
//	            grade = 'F';
//	         }         
//	         System.out.printf("입력한 %d점은 성적 %c입니다.\n", score, grade);
//	      }else {
//	         System.out.println("올바르지 않은 점수입니다.");
//			}

	
	
	
	}

}
