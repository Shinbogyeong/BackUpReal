package com.test.question.q73;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Q004 {
	
	public final static String DATA;
	public static Scanner scan;
	
	static {
		DATA = "C:\\Users\\신보경\\Desktop\\파일_입출력_문제\\단일검색.dat";
		scan = new Scanner(System.in);
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("이름: ");
		
		String name = scan.nextLine();
		
		try {
			
			BufferedReader reader = new BufferedReader (new FileReader(DATA));
			
			String line = "";
			
			while((line = reader.readLine()) != null) {
				
				//1,유게무,광주시 강동구 다동, 010-3086-6664
				
				String[] temp = line.split(",");
				
				if(temp[1].equals(name)) {
					
				System.out.println("[" + name + "]");
				System.out.println("번호 : " + temp[0] );
				System.out.println("주소 : " + temp[2] );
				System.out.println("전화 : " + temp[3] );
				
				}
				
			}//while
			
			reader.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	

	
	

}
