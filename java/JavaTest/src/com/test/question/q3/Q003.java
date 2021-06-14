package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
		
		System.out.println("너비(cm) : ");
		int width = Integer.parseInt(reader.readLine());

		System.out.println("높이(cm) : ");
		int height = Integer.parseInt(reader.readLine());
		
		int area = width * height;
		int perimeter = width * 2 + height * 2;
		
		//연산 결과를 따로 변수에 저장 후 출력하는 방법 -> 가독성 Up > 선호
		//A. 출력 + 계산.
		//B. 출력, 계산 > 선호
		System.out.printf("사각형의 넓이는 %dcm입니다.\n", area);
		System.out.printf("사각형의 둘레는 %dcm입니다.\n", perimeter);
		
		
		
	}
	
}