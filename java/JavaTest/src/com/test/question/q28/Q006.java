package com.test.question.q28;

public class Q006 {
public static void main(String[] args) {
		
		int[][] num = new int[5][5];
		
		int n = 1;
		int sumi = 0;
		int sumj =0;
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				num[i][j] = n;
				
				sumj += num[j][i];
				sumi += num[i][j];
				
				num[i][4] = sumi; 
				num[4][j] = sumj; 
				
				n++;
			}
			num[4][4] += num[i][4];
			
			sumi = 0;
			sumj = 0;
			
			
		}
		
		
		
		
		output(num);
	}

	private static void output(int[][] num) {

		for (int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%4d", num[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

}
