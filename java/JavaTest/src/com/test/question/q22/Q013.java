package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q013 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String name = "";
		String coke = "콜라";
		String sprite = "사이다";
		String vita = "비타500";
		
		int charge = 0;
		int coke_m = 700;
		int sprite_m = 600;
		int vita_m = 500;
		
		
		System.out.println("=====================");
		System.out.println("       자판기");
		System.out.println("=====================");
		System.out.printf("1. %-9s : %d원\n", coke, coke_m);
		System.out.printf("2. %-9s : %d원\n", sprite, sprite_m);
		System.out.printf("3. %-9s : %d원\n", vita, vita_m);
		System.out.println("---------------------");
		System.out.println("금액 투입(원) :");
		int money = Integer.parseInt(reader.readLine());
		System.out.println("---------------------");
		System.out.println("음료 선택(번호)");
		int num = Integer.parseInt(reader.readLine());
		
		switch(num) {
		case 1: 
			name = coke;
			charge = money - coke_m;
			break;
		case 2:
			name = sprite;
			charge = money - sprite_m;
			break;
		case 3:
			name = vita;
			charge = money - vita_m;
			break;
		}
		
		System.out.printf("+%s를 제공합니다.\n+잔돈 %d원을 제공합니다." , name, charge);
	}
}
