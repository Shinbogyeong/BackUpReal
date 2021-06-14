package com.test.question.q25;

public class Q013 {
	public static void main(String[] args) {
		
		String txt = "안녕녕하하하하세요....홍홍홍홍홍홍길동입입니다다다다다..";
		int sum = 0;
		
		
		for(int i=1; i<txt.length(); i++) {
			
			if( txt.charAt(i) == txt.charAt(i-1)) {
				sum ++;
			} else {
				System.out.printf("'%c' : 발견횟수 %d회\n", txt.charAt(i-1), sum +1);
				sum = 0;
			}
		}
		
		
		
		
		
	}//main

}
