package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String result = "";
		String add = "";
		
		
		for(int i = 1; i<=10; i++) {
			System.out.println("숫자: ");
			int num = Integer.parseInt(reader.readLine());
			
			switch(num){
			case 1 : 
				add ="일";
				break;
			case 2 : 
				add ="이";
				break;
			case 3 : 
				add ="삼";
				break;
			case 4 : 
				add ="사";
				break;
			case 5 : 
				add ="오";
				break;
			case 6 : 
				add ="육";
				break;
			case 7 : 
				add ="칠";
				break;
			case 8 : 
				add ="팔";
				break;
			case 9 : 
				add ="구";
				break;
			case 0 : 
				add ="영";
				break;
				}//switch
			
			result += add;
			
			if(num >= 10) {
				System.out.println("2자리 이상 숫자를 입력하셨습니다. 프로그램을 종료합니다.");
				break;
			}
		}//for
		
		if(result.length() == 10)
		System.out.printf("결과 : %s",result);
		}
		
	}

