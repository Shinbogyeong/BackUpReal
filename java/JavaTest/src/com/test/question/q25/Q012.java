package com.test.question.q25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q012 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("연산식을 입력하시오:");
		String txt = reader.readLine();
		
		txt = txt.replace(" ", "");
		System.out.println(txt);
		
		String oper = "";
		
//		if (txt.indexOf(oper) == txt.length() - 1) {
//			System.out.println("피연산자가 부족합니다.");
//		}//어떻게 체크?
		
		if(txt.indexOf("+") > -1) {
			oper = "+";
		} else if(txt.indexOf("-") > -1) {
			oper = "-";
		} else if(txt.indexOf("*") > -1) {
			oper = "*";
		} else if(txt.indexOf("/") > -1) {
			oper = "/";
		} else if(txt.indexOf("%") > -1) {
			oper = "%";
		}
		
		int num1 =  Integer.parseInt(txt.substring(0, txt.indexOf(oper)));
		int num2 = Integer.parseInt(txt.substring(txt.indexOf(oper) + 1));
		
		
		switch(oper) {
		case "+" :
			System.out.printf("%d + %d = %d",num1 , num2, num1 + num2);
			break;
		case "-" :
			System.out.printf("%d - %d = %d",num1 , num2, num1 - num2);
			break;
		case "*" :
			System.out.printf("%d * %d = %d",num1 , num2, num1 * num2);
			break;
		case "/" :
			System.out.printf("%d / %d = %d",num1 , num2, num1 / num2);
			break;
		case "%" :
			System.out.printf("%d %% %d = %d",num1 , num2, num1 % num2);
			break;
		default :
			System.out.println("산술연산자가 존재하지 않습니다.");
			break;
		} 
		
		
		
		
	}

}
