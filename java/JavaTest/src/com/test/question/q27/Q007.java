package com.test.question.q27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("삽입 위치:");
		int location = Integer.parseInt(reader.readLine());
		
		System.out.println("값");
		int value = Integer.parseInt(reader.readLine());
		
		
		int[] nums = new int[] {5, 6, 1, 3, 2, 0, 0, 0, 0, 0};//지정

		//원문 출력
		String txt = output(nums);//String문을 받는 메소드
		
		System.out.printf("원본 : [ %s]\n", txt);
		
		//insert후 출력
		
		insert(nums, location, value);
		
		txt = output(nums);
		
		System.out.printf("결과 : [ %s]", txt);
	
		
	}
	
	

	private static String output(int[] list) { //output
		
		String txt = "";
		
		for(int i=0; i<list.length; i++) {
			if(i == list.length -1) { //마지막 ',제외출력
				txt += list[i];
			}else {
				txt += list[i] + ", ";
			}
		}
		return txt;
	}



	private static void insert(int[] nums, int location, int value) {

		for(int i=nums.length-2; i>=location; i--) {
			nums[i+1] =	nums[i];
			if(i == location) {
				nums[i] = value;
			}
		}
	}
	
	
	

}
