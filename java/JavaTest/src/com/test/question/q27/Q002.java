package com.test.question.q27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {
	//학생의 이름을 n개입력받아 아래와 같이 출력하시오.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("학생 수:");
		int num = Integer.parseInt(reader.readLine());
		
		String[]name = new String[num];
		
		for(int i=0; i <name.length ; i++) {
			System.out.println("학생명:");
			name[i] = reader.readLine();
		}
		
		System.out.printf("입력한 학생은 총 %d명입니다.\n", num);
		for(int i=0; i <name.length ; i++) {
			System.out.printf("%d. %s\n", i+1, name[i]);
		}
		
	}

}
