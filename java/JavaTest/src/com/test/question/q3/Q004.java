package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
		
		System.out.println("사용자가 페달을 밟은 횟수 : ");
		int num = Integer.parseInt(reader.readLine());
		
		double circle = 66.04 * 3.14;// 26인치는 66.04cm, 원주율은 3.14라고 가정
		circle /= 100; //m로 환산
		int total = (int) (circle * num);
		
		System.out.printf("사용자가 총 %,d회 페달을 밟아 자전거가 총 %,dm를 달렸습니다.", num, total);
		
	}

}
