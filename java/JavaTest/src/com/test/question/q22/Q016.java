package com.test.question.q22;

public class Q016 {
	public static void main(String[] args) {
		
		int num = 0;
		int sum = 0;
		System.out.print("1 ");
		
		
		for(int i=1; i<=100; i+=num) {
			System.out.printf("+ %d ", i);
			num += i;
			sum += num;
		}
		System.out.printf(" = %d", sum);
		
	}

}
