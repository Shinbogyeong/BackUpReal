package com.test.question.q69;

import java.io.File;
import java.util.Scanner;

public class Q002 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("폴더 선택:");
		String path = scan.nextLine();
		System.out.println("파일 확장자: ");
		String type = scan.nextLine();
		
//		String path = "C:\\class\\java\\JavaTest";
//		String type = "md";
		
		
		
		File dir = new File(path);
		
		if(dir.exists()) {
			File[] list = dir.listFiles();
			
			for(File name : list) {
				//각각의 파일의 이름의 마지막에서 type명의 길이까지가  type명과 같응면
				if(name.getName().toUpperCase().endsWith(type.toUpperCase())) {
					System.out.println(name.getName());
				}
				
				
			}
			
			
		}
		
// 		  for(File sub : list) {
//        int index = sub.getName().lastIndexOf(".");
//        String ext = sub.getName().substring(index+1); //확장자이름
//        if(answer.toLowerCase().equals(ext.toLowerCase())) {
//           System.out.printf("[%s]\n", sub.getName());
//        }
     
     }
		
		
		
	
	
	

}
