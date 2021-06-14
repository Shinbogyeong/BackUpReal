package com.test.question.q73;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class Q006 {
	
	public final static String DATA;
	public static Stack<String> brakets;
	
	
	static {
		DATA = "C:\\Users\\신보경\\Desktop\\파일_입출력_문제\\괄호.java";
		brakets = new Stack<String>();
	}
	
	
	//서로짝이 맞으려면? 갯수 같아야함 "{", "}" && "(", ")"
	public static void main(String[] args) {
		
		try {
			
			BufferedReader reader = new BufferedReader (new FileReader(DATA));
			
			String line = "";
			while((line = reader.readLine()) != null) {
				
				//문장의 한글자씩 읽는다.
				for (int i=0; i<line.length(); i++) {
					char word = line.charAt(i);
					
					//글자가 {,},(,)중에 하나면 Stack에 저장
					if(word =='{' || word == '}' || word == '(' || word == ')'	) {
						brakets.push(word+"");
					}
				}//for
				
			}
			
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(brakets.size());
		
		int largeLeftB = 0;
		int largeRightB = 0;
		int smallLeftB = 0;
		int smallRightB = 0;
		boolean result = true;
		
		while(!brakets.isEmpty()) {
			
			String braketsType = brakets.pop();
			
			if(braketsType.equals("{")) {
				largeLeftB++;
			} else if(braketsType.equals("}")) {
				largeRightB++;
			} else if(braketsType.equals("(")) {
				smallLeftB++;
			} else if(braketsType.equals(")")) {
				smallRightB++;
			}
			System.out.println(braketsType);
			System.out.println(brakets.size());
			
			//},)이게 더 많을수없음
			if((largeRightB > largeLeftB) && (smallRightB > smallLeftB)) {
				result = false;
			}
			
			
			
//			String braketsA = brakets.pop();
//			String braketsB = brakets.pop();
//			if
		}//while
		
		
		//각 괄호의 갯수가 틀리면 짝이 맞지 않는다.
		System.out.printf("%d, %d, %d, %d"
				, largeLeftB, largeRightB, smallLeftB, smallRightB);
		
		if((largeRightB != largeLeftB) || (smallRightB != smallLeftB)) {
			result = false;
		}
		
		if(result == false) {
			System.out.println("올바르지 않은 소스입니다.");
		} else {
			System.out.println("올바른 소스입니다.");
		}
		
	}//main

}
