package com.test.question.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader (System.in));
		
		System.out.print("첫번째 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());
		//double num1 = Double.parseDouble(reader.readLine()); // 더 많은 숫자를 입력받기 위해 자료형을 double로 사용
		
		System.out.print("두번째 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());
		// double num2 = Double.parseDouble(reader.readLine());
			
		
		//산술 연산의 결과 > 오버플로우발생 조심 > 추후 대응 코드 작성 필요!!
		System.out.printf("%,d + %,d = %,d\n", num1, num2, num1+num2);
		//System.out.printf("%,.0f + %,.0f = %,.0f\n", num1, num2, num1+num2);
		System.out.printf("%,d - %,d = %,d\n", num1, num2, num1-num2);
		System.out.printf("%,d * %,d = %,d\n", num1, num2, num1*num2);
		System.out.printf("%,d / %,d = %,.1f\n", num1, num2, (double)num1/num2);
		//(double)(int / int)는 안됨 int끼리의 연산은 소수점 이하 손실
		System.out.printf("%,d %% %,d = %,d\n", num1, num2, num1%num2);
		
		
		
	}
}
