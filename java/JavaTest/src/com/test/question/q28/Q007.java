package com.test.question.q28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("국어 점수:");
		int kor = Integer.parseInt(reader.readLine()) / 10;
		
		System.out.println("영어 점수:");
		int eng = Integer.parseInt(reader.readLine()) / 10;
		
		System.out.println("수학 점수:");
		int math = Integer.parseInt(reader.readLine()) / 10;
		
		
		String[][] score = new String[10][3];
		
		
		for(int i=0; i<score.length; i++) {//10
			for(int j=0; j<score[0].length; j++) {//3
				if (i<kor) { //국어점수 i의 범위는 0~9니까 kor점수도 -1해준다.
					score[9-i][0] = "ㅁ";//위부터 출력
				} else {
					score[9-i][0] = "";
				}
				
				if (i<eng ) { //영어점수
					score[9-i][1] = "ㅁ";
				} else {
					score[9-i][1] = "";
				}
				
				if (i<math) { //수학점수
					score[9-i][2] = "ㅁ";
				} else {
					score[9-i][2] = "";
				}
				
			}
		}
		
		
		output(score);
		
		
		
	}
	
	private static void output(String[][] score) {

		for (int i=0; i<score.length; i++) {
			for(int j=0; j<score[0].length; j++) {
				System.out.printf("%4s", score[i][j]);//***
			}
			System.out.println();
		}

		System.out.println("-----------------");
		System.out.println(" 국어 영어 수학");
		System.out.println();
		System.out.println();
	}

}
