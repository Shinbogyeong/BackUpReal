package com.test.question.q25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q001 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("문장 입력: ");
		String txt = reader.readLine();
		
		for (int i=0; i<txt.length(); i++) {
			System.out.printf("%c",txt.charAt(txt.length() - 1 - i));
		}
		

		//charAt()방법과, substring()방법 중 선택해서 사용하면 된다.
//		for (int i = txt.length() - 1; i>=0; i--) {
//	         
//	         newTxt += txt.charAt(i);
//	         //newTxt += txt.substring(i, i+1); // 서브스트링으로 하는 방법.
//	         
//	      }//for
		
		 
//	      }
	}
}
