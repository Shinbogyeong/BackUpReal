package com.test.question.q25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q010 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("금액(원)");
		String money = reader.readLine();
		
		int length = money.length();
		
		String num = "";
		String[] won = new String[5];
		won[0] = "만";
		won[1] = "천";
		won[2] = "백";
		won[3] = "십";
		won[4] = "";
		
		
		for(int i=0; i<money.length(); i++) {
			switch(money.charAt(i) - 48) {
			case 1: 
				num += "일";
				break;
			case 2: 
				num += "이";
				break;
			case 3: 
				num += "삼";
				break;
			case 4: 
				num += "사";
				break;
			case 5: 
				num += "오";
				break;
			case 6: 
				num += "육";
				break;
			case 7: 
				num += "칠";
				break;
			case 8: 
				num += "팔";
				break;
			case 9: 
				num += "구";
				break;
			case 0: // 0일땐 출력하지 않음
				break;
			}
			
			

			if(length == 5 ) {
				num += won[0];
			} else if(length == 4){
				num += won[1];
			}else if(length == 3){
				num += won[2];
			}else if(length == 2){
				num += won[3];
			}else if(length == 1){
				num += won[4];
			}else if(length == 0){
				num += won[5];
			}
			
			length--;
			
			
		}
		
		System.out.println("일금" + num + "원");
		
		
	}

}
