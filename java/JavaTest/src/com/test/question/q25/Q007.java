package com.test.question.q25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q007 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.println("숫자: ");
	String num = reader.readLine();
	
	String result = "";
	
	System.out.println(num.length());
	System.out.println(num.substring(0, num.length()));
	
	for(int i=num.length(); i>=0 ;) {
		result = "," +num.substring(i-3, i) + result;
		i-=3;
		if (i-3 == 0) {
			result = num.substring(i-3, i) + result;
			break;
		}else if (i-2 == 0) {
			result = num.substring(i-2, i) + result;
			break;
		} else if(i-1 ==0){
			result = num.substring(i-1, i) + result;
			break;
		}
	}
	
	
	}
}
