package com.test.question.q25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("주민등록번호:");
		String jumin = reader.readLine();
		int sum = 0;
		int j = 2;
		
		if(jumin.indexOf('-') >-1) { //'-'가 들어갔을 때 '-'제외하기
			String str1 = jumin.substring(0, jumin.indexOf('-'));
			String str2 = jumin.substring(jumin.indexOf('-') + 1);
			jumin = str1 + str2;
		}
		
		for(int i=0; i<12; i++) {
			sum += ((int)jumin.charAt(i) - 48) * j;
			j++;
			
			if (j == 10) {//곱하는 수가 10이상이면 2로 돌아감.
					j = 2;
				}

		}
		
		sum %= 11;
		
		if(sum<=1) { //sum이 2자리수 이상일 때
			sum = 1- sum;
		} else {
			sum = 11 - sum;
		}
		
		
		if((jumin.charAt(12) - 48) == sum) {
			System.out.println("올바른 주민등록번호입니다.");
		} else {
			System.out.println("올바르지 않은 주민등록번호입니다.");
		}
		
		
		
		
		
	}
}
