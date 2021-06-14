package com.test.question.q25;

public class Q005 {
	public static void main(String[] args) {
		
		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";
		int sum = 0;
		int index =0;
		
		while(true) {
			index = content.indexOf(word, index);
			
			if(index == -1) {
				break;
			}

			index += word.length();
			sum ++;
		}
		System.out.printf("'%s'를 총 %d회 발견했습니다.", word, sum);
	
		
		
		
		
	}
}

