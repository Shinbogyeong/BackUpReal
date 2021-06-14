package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//숫자 2개를 입력 받아 시작 숫자에서 종료 숫자까지 1씩 증가하며 출력하시오
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("시작 숫자:");
		int start = Integer.parseInt(reader.readLine());
		
		System.out.println("종료 숫자:");
		int finish = Integer.parseInt(reader.readLine());
		
		System.out.println("증가치 :");
		int increase = Integer.parseInt(reader.readLine());
		
		for(int i = start; i<=finish; i+=increase) {
			
			System.out.println(i);
			
		}
		
	}
	

}
