package com.test.question.q27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q008 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("삭제 위치:");
		int location = Integer.parseInt(reader.readLine());
		
		int[] num = new int[5];
		
		for(int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random() * 9);
		}
		
		System.out.printf("원본 :");
		System.out.println(output(num));
		
		delete(num, location);

		System.out.printf("결과 :");
		System.out.println(output(num));
		
		
	}

	

	private static void delete(int[] num, int location) {

		for(int i=location-1; i<num.length; i++) {
			if (i == num.length-1) {
				num[i] = 0;
			} else {
				num[i] = num[i+1];
			}
		}
	}



	private static String output(int[] num) {
		String txt = "[";
		for(int i =0; i<num.length; i++) {
			txt = txt + num[i] + ", ";
		}
		
		return txt.substring(0,txt.length()-2) + "]";
	}

}
