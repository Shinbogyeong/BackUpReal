package com.test.question.q28;

public class Q005 {
	public static void main(String[] args) {
		
		int[][] num = new int[3][5];
		
		for (int i=0; i<3; i++) {
			for(int j=0; j<5; j++) {
				num[i][j];
			}
		}
		

		output(num);
	}

	private static void output(int[][] num) {

		for (int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.printf("%3d", num[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

}
