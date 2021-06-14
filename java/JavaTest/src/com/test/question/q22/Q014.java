package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q014 {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int even = 0;
		int odd = 0;
		System.out.println((int)Math.pow(10, 0));
		
		System.out.println("9자리 숫자 입력:");
		int num = Integer.parseInt(reader.readLine());
		//123456789
		
		for(int j=0; j<=8; j++) {
			for(int i =0; i<10; i++) {
				if(i == (int)(num / Math.pow(10, 8-j))) {
					if(i % 2 == 0) {
						even += i;
					} else {
						odd += i;
						
					}
					num -= i * Math.pow(10, 8-j);
				}
			}
		}
		System.out.printf("짝수의 합 : %d\n홀수의 합: %d", even, odd);
		
		
		
		
		if (num >= 999999999) {
			System.out.println("동작할 수 없습니다.");
		}
		
		
		
	}

}
