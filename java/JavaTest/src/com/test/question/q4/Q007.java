package com.test.question.q4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//추가 조건 해야함!

public class Q007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("역의 개수 :");
		int stationNum = Integer.parseInt(reader.readLine());
		
		System.out.println("환승의 개수 :");
		int transferNum = Integer.parseInt(reader.readLine());
		
		System.out.printf("총 소요 시간은 %d분 입니다.", getTime(stationNum, transferNum));
		
		
	}//main
	
	public static int getTime(int stationNum, int transferNum) {
		
		int time = 2 * stationNum + 3 * transferNum ;
		
		return time;
	}

}
