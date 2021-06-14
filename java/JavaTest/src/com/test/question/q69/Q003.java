package com.test.question.q69;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q003 {
	//보기
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("파일이동을 실행합니다.\n같은 이름을 가지는 파일이 이미 존재합니다.\n덮어쓸까요?(y/n)");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String asw = reader.readLine(); 
		
		
		String org = "C:\\class\\java\\file\\AAA\\test.txt";
		String copy = "C:\\class\\java\\file\\BBB\\test.txt";
		
		File dirOrg = new File(org);
		File dirCopy = new File(copy);
		
		if(asw.equals("y")) {
			dirCopy.delete();
			dirOrg.renameTo(dirCopy);
			System.out.println("y.파일을 덮어썼습니다.");
			
		} else if (asw.equals("n")){
			System.out.println("n.작업을 취소합니다.");
		} else {
			System.out.println("잘못입력하셨습니다.");
		}
		
		
		
	}

}
