package com.test.question.q27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("최대 범위:");
		int max = Integer.parseInt(reader.readLine());
		System.out.println("최소 범위:");
		int min = Integer.parseInt(reader.readLine());
		
		
		int[] num = new int[20];
		
		for(int i=0; i<num.length; i++) {//num[]에 난수 저장
			num[i] = (int)(Math.random() * 20) + 1;
		}
		
		String result = dump(num);
		
		System.out.printf("원본 : %s\n", result);//출력
		
		System.out.printf("결과 :");
		
		for(int i=0; i<num.length; i++) {
			if(num[i]>=min && num[i]<=max) {//num[i]가 max보다 작고, min보다 크면 출력
				System.out.printf("%d ", num[i]);
			}
		}
		
		
		
		
	}

	private static String dump(int[] num) {
		String txt = "";
		
		for(int i=0; i<num.length; i++) {
			txt += num[i] + ", ";
		}
		txt= txt.substring(0, txt.length()-2);
		
		return txt;
	}

}
