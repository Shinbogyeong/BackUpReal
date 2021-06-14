package com.test.question.q27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("배열의 길이:");
		int len = Integer.parseInt(reader.readLine());
		
		int[] nums = new int[len];
		int[] result = new int[(int)(len/2)]; //result의 길이는 nums/2 //(int)안넣어도 됨?
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = (int)(Math.random() * 10) + 1;
		}
		for(int i=0; i<result.length; i++) {
			result[i] = nums[i*2] + nums[i*2 + 1];
		}
		
		System.out.print("nums = [");
		output(nums);
		System.out.println("]");
		
		System.out.print("result = [");
		output(result);
		System.out.println("]");
			
	}
	
	public static void output(int[] list) {
		for(int i=0; i<list.length; i++) {
			if(i==list.length-1) { //마지막 ','를 제거하기 위해 나눈다.
				System.out.printf("%d",list[i]);
			}else {
			System.out.printf("%d, ",list[i]);
			}
		}
		
		
	}
}
