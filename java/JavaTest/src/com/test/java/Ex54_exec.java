package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex54_exec {
	
	private static Object inheritance;

	public static void main(String[] args) throws Exception{
		
		//자바 프로그램에서 외부 프로그램 호출하기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("선택: ");
		
		String sel = reader.readLine();
		
		/*
		while (true) {
			if(sel.equals("1")) {
				Process p1 = new ProcessBuilder("notepad.exe").start();
			} else if(sel.equals("2")) {
				Process p1 = new ProcessBuilder("mspaint.exe").start();
			} else if(sel.equals("3")) {
				Process p1 = new ProcessBuilder("msedge.exe").start();
			} else if(sel.equals("4")) {
				Process p1 = new ProcessBuilder("clac.exe").start();
			}
			
			
			
			
			System.out.println("확인");
		}
		*/
		
		//Process p1 = new ProcessBuilder("notepad.exe"
		//		,"C:\\class\\java").start();
		
		Process p1 = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\" --new-window --remote-debugging-port=9122 --user-data-dir=\"C:\\Users\\신보경\\AppData\\Local\\Google\\Chrome\\User Data", "https://youtu.be/cIcL8vzbf-s").start();
		
		
	}

}
