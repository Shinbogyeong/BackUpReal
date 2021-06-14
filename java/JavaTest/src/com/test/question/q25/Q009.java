package com.test.question.q25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q009 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("문장을 입력하세요;");
		String txt = reader.readLine();
		
		int sum = 0;
		
		String[] oldValue = new String [2];
		oldValue[0] = "바보";
		oldValue[1] = "멍청이";

		String[] newValue = new String [2];
		newValue[0] = "**";
		newValue[1] = "***";
		
		
		for(int i=0; i<=1; i++) {
			if(txt.indexOf(oldValue[i]) > -1) { //금지어를 발견했을 때
				txt = txt.replace(oldValue[i], newValue[i]); //문장 변경해서 저장
				sum++;
			}
		}

		System.out.println(txt);
		System.out.printf("금지어를 %d회 마스킹했습니다.", sum);
		
		
	}

}
