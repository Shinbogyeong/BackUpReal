package com.test.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex81_RegEx {
	
	public static void main(String[] args) {
		
		//m1();
		//m2();
		m3();
	}

	private static void m3() {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("dat\naver.dat"));
			
			String wholeText = "";
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				wholeText += line + "\r\n";
			}
		} catch ( Exception e) {
			System.out.println(e);
		}
		
	
	}

	private static void m2() {

		//Pattern 클래스
		// - 정규식 지원
		String txt = "안녕하세요. 홍길동입니다. 제전화번호는 010-1234-5678입니다. 집전화는 02-987-6543입니다. 연락주세요.";
		
		//txt -> 전화번호 있는지? 없는지?
		
		//정규식 객체 생성
		Pattern p = Pattern.compile("\\d{2,3} =\\d{3,4}-\\d{4}");
		
		//검색
		Matcher m = p.matcher(txt);
		
		//System.out.println(m.find());
		
		if(m.find()) {
			System.out.println("게시물 작성 금지!!!");
			
			
			//어떤 전화번호를 작성했길래??
			System.out.println(m.group());
		} else {
			System.out.println("게시물 작성 완료~");
		}
		
		//게시판 작성 -> 금지어 (바보, 멍청이)
		txt ="글을 쓰고있습니다.. 바보야";
		

		 //게시판 작성 -> 금지어(바보, 멍청이)
		 txt = "글을 쓰고있습니다...";
		 p = Pattern.compile("(바보|멍청이)");
		 
		 m = p.matcher(txt);
		 
		 if(m.find()) {
				System.out.println("금지어 사용");
				
				
				//어떤 전화번호를 작성했길래??
				System.out.println(m.group());
			} else {
				System.out.println("통과");
			}
		
		 
		 txt = "안녕하세요. 제몸무게는 75kg입니다. 키는 175cm입니다. 나이는 20살입니다.";
		 //숫자만 골라내시오
		 
		 p = Pattern.compile("\\d{1,}");
		 
		 m = p.matcher(txt);
		 
		 while (m.find()) { //iter.hashNext()
			 System.out.println(m.group());
		 }
		
	}

	private static void m1() {

		// 자바 + 정규식
		// - 자바의 일부메소드가 정규식을 지원
		 
		 String txt = "안녕하세요. 홍길동입니다. 제전화번호는 010-1234-5678입니다. 집전화는 02-987-6543입니다. 연락주세요.";
		 
		 //게시판 정책 -> 연락처 작성 금지 -> 마스킹 처리
		 //System.out.println(txt.replace("010-1234-5677", "XXX-XXXX-XXXX"));
		 
		 
		 //CharSequence -> String클래스의 부모 인터페이스
		 
		 System.out.println(txt.replaceAll("010-[0-9]{4}-[0-9]{4}",  "XXX-XXXX-XXXX"));
		 
		 String name = "홍길동,아무개,하하하,호호호,후후후";
		 
		 name.split(name);
		 
		 //분할 메소드 -> 구분자를 기준으로 문자를 자르는 기능
		 //String[] result = name.split(",{1,4}");
		 String[] result = name.split("[,\\.]");
		 
		 for (String n: result) {
			 System.out.println(n);
		 }
		 
		 
	}

}
