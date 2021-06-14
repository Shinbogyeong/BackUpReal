package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//숫자 1개를 입력받아 1부터 입력한 숫자까지의 합을 출력하시오.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("숫자:");
		int num = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		
		System.out.printf("1 ~ %d = %,d", num, sum);
	}
}
