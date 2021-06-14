package com.test.question.q69;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Name;

public class Q007 {
	
	public static void main(String[] args) {
		
		String pathA = "C:\\Users\\신보경\\Desktop\\027_파일_디렉토리\\파일_디렉토리_문제\\동일 파일\\MusicA";
		String pathB = "C:\\Users\\신보경\\Desktop\\027_파일_디렉토리\\파일_디렉토리_문제\\동일 파일\\MusicB";
		
		File dirA = new File(pathA);
		File dirB = new File(pathB);
		
		File[] listA = dirA.listFiles();
		File[] listB = dirB.listFiles();
		

		//musicA와 musicB가 동시에 가지고있는 파일
		ArrayList<String> list = new ArrayList<String>();
		
		
		//동일 파일 출력
		for (File nameA : listA) {
			for (File nameB : listB) {
				if(nameA.getName().equals(nameB.getName())) {
					System.out.println(nameB.getName());
					list.add(nameA.getName());
				} 
			}
			
		}//for문
		
		System.out.println();
		System.out.println();


		System.out.println("======================");
		//MusicA에만 존재하는 파일을 출력하시오.
		for (File nameA : listA) {
			boolean isExist = false;
			for(String name: list) {
				
				if(nameA.getName().equals(name)) {
					isExist = true;
				} 
			}
				if(!isExist) {
					System.out.println(nameA.getName());
				}
		}
		System.out.println();
		System.out.println();
		
		
		System.out.println("======================");
		//MusicB에만 존재하는 파일을 출력하시오.
		for (File nameB : listB) {
			boolean isExist = false;
			for(String name: list) {
				
				if(nameB.getName().equals(name)) {
					isExist = true;
				} 
			}
			if(!isExist) {
				System.out.println(nameB.getName());
			}
		}
		System.out.println();
		System.out.println();
		
		
		
	}

}
