package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//숫자 10개를 입력받아 짝수의 합과 홀수의 합을 각각 출력하시오.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int odd = 0;//홀수
		int even = 0;//짝수
		
		for (int i=0; i<=9; i++) {
			
			System.out.println("숫자 : ");
			int num = Integer.parseInt(reader.readLine());
			
			if(num % 2 ==0) {
				even += num;
			}else {
				odd += num;
			}
		}
		
		System.out.printf("짝수의 합 : %d\n홀수의 합 : %d", even, odd);
		
	}

}
