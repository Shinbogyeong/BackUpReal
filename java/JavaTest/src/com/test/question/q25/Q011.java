package com.test.question.q25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q011 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("문장을 입력하세요:");
		String txt = reader.readLine();
		
		//'1' = 49, '9' = 67
		
		int sum = 0;
		for(int i=0; i<txt.length(); i++) {
			if(txt.charAt(i) >= 49 && txt.charAt(i) <= 67) {//숫자를 발견하면 sum에 누적
				sum += txt.charAt(i) - 48;
			}
		}
		
		System.out.printf("문장에 존재하는 모든 숫자의 합은 %d입니다.",sum);
	}
}
