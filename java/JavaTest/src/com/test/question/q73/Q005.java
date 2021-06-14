package com.test.question.q73;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q005 {
	
	public final static String DATAmember;
	public final static String DATAorder;
	public static HashMap<String, String> list;
	
	static {
		DATAmember = "C:\\Users\\신보경\\Desktop\\파일_입출력_문제\\검색_회원.dat";
		DATAorder = "C:\\Users\\신보경\\Desktop\\파일_입출력_문제\\검색_주문.dat";
		list = new HashMap<String, String>();
	}
	
	//검색 회원
	// 1,정재재,서울시 강동구 라동
//	2,황길돈,서울시 중구 다동
//	3,길형수,대구시 강남구 라동
//	4,전무석,대구시 강서구 마동
	

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름: ");
		String name = scan.nextLine();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(DATAmember));
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if(temp[1].equals(name)) {
					list.put("번호", temp[0]);
					list.put("이름", temp[1]);
					list.put("배송지", temp[2]);
					
				}
				
			}
			
			reader.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//검색 주문
//		1,마우스,19,53
//		2,모니터,13,57
//		3,키보드,15,36

		
		try {
			BufferedReader reader = new BufferedReader (new FileReader(DATAorder));
			
			String line ="";
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				String num = list.get("번호");
				
				if(temp[3].equals(num)) {
					list.put("상품명", temp[1]);
					list.put("개수", temp[0]);
				}
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println(e);
		
		}
		
		
		
		System.out.println("======구매내역======");
		System.out.println("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]");
		System.out.printf("%s\t%s\t%s\t%s\t%s\t"
							, list.get("번호")
							, list.get("이름")
							, list.get("상품명")
							, list.get("개수")
							, list.get("배송지"));
		
		
	}

}
