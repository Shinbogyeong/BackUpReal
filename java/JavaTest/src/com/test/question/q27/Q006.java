package com.test.question.q27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q006 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작 숫자: ");
		int start = Integer.parseInt(reader.readLine());
		
		System.out.print("종료 숫자: ");
		int end = Integer.parseInt(reader.readLine());
		
		System.out.println("숫자의 개수:");
		int numNum = Integer.parseInt(reader.readLine());
		
		
		int[] num = new int[numNum];
		for(int i=0; i<num.length; i++) {
			num[i] = (int)(Math.random() * end - start +1) + 1;
			
			for(int j=0; j<i; j++) {
				if(num[i] == num[j]) { //같으면 num[i]를 다시 초기화
					i--;
					break;
				}
			}
			
		}
		
		//출력
		
		System.out.printf("[");
		for(int i=0; i<num.length; i++) {
				if(i == num.length-1) {
					System.out.printf("%d", num[i]);
				} else {
					System.out.printf("%d, " , num[i]);
				}
			
			}
		System.out.printf("]");
			
		
		
		}
		
		
	}

