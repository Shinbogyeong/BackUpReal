package com.test.question.q25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q008 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("단어:");
		String txt = reader.readLine();
		int index = 0;
		String result = "";
		
		for(int i=1; i<txt.length(); i++) {
			if(txt.charAt(i) < 97) {//소문자(97)보다 작으면 대문자로 이해하고 substring으로 문장 나누고 resulㅅ문자에 더함
				result += txt.substring(index, i) + " ";
				index = i;
			}
			if(i == txt.length()-1) {//마지막문장에는 대문자가 없기때문에 출력하지 않아서 이전 대문자부터 result값에 더함
				result += txt.substring(index);
			}
		}
		
		
		System.out.printf("결과: %s", result);
		
	}

}
