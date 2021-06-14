package com.test.question.q28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {
public static void main(String[] args) throws NumberFormatException, IOException {
	 
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("행: ");
		int line1 = Integer.parseInt(reader.readLine());
		System.out.println("열: ");
		int line2 = Integer.parseInt(reader.readLine());
		
		int[][] num = new int[line1][line2];
		
		int n = 1;
		for(int i=0; i<num.length; i++) {
			for(int j=0; j<num[0].length; j++) {
					num[num.length-i - 1][num[0].length-j - 1] = n;
					n++;
			}
		}
		
		
		
		output(num);
	}

	private static void output(int[][] num) {

		for (int i=0; i<num.length; i++) {
			for(int j=0; j<num[0].length; j++) {
				System.out.printf("%3d", num[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

}
