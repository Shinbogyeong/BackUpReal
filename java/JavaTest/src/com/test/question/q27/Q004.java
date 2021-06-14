package com.test.question.q27;

public class Q004 {
	public static void main(String[] args) {
		
		int[] nums = new int[20];
		int max = 0;
		int min = 21;
		
		for(int i=0; i<nums.length; i++) {//난수 20개 입력
			nums[i] = (int)(Math.random() * 20) +1;
			System.out.println(nums[i]);
		}
		
		for(int i=0; i<nums.length; i++) {
			if(max <=nums[i]) {
				max = nums[i];//큰 수를 max에 입력
			}
			if(min >= nums[i]){
				min = nums[i];//작은 수를 min에 입력
			}
			System.out.println(max);
		}
		
		
		System.out.print("원본 :");
		for(int i: nums) {
			System.out.printf("%d, ",i);
		}
		System.out.println("\b\b");
		System.out.printf("최대값 : %d\n최소값 : %d", max, min);
		
		
		
	}
}


		
