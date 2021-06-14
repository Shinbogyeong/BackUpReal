package com.test.java;

public class Ex06_Escape {
	
	public static void main(String[] args) {
		
		//특수 문자 > Escape Sequence
		//- 컴파일러와 미리 약속된 문자 >소스에는 특정한 문자를 작성했지만,
		//실행 시 특정 행동을 하는 문자
		//- 자료형: char
		
		//1. \n
		// - new line
		// - 개행문자 > 엔터
		char c1 = '\n';
		
		String str = "안녕하세요.\n 홍길동입니다.";
		System.out.println(str);
		
		String str1 = "안녕하세요.";
		String str2 = "홍길동입니다.";
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println();// 빈줄 출력
		
		//문자열 리터럴내에는 엔터를 입력할 수 없다. > 문자열 리터럴은 단일 라인이어야 함.
		//String str3 = "안녕하세요."
		//		 " 홍길동입니다."
		
		
		//2. \r
		// - carriage return
		// - 커서(캐럿)의 위치를 현재 라인의 첫번재 열로 이동해라(home 키 눌러라~)
		
		str = "반갑습니다.\r홍길동";
		System.out.println(str);//cmd결과: 홍길동니다. 
		System.out.println();
		
		//cmd>java.exe -jar ex06.jar
		
		
		//일반적으로 행을 바꿀때> 엔터키를 누른다.
		// -> 엔터(\r + \n)
		
		//-> 엔 -> 윈도우"\r\n"
		//운영체제마다 다름(\r\n, \r, \n)		
		
		
		//3. \t
		// - 탭문자 : 가까운 탭의 위치로 이동해라- 열맞추려고
		str1 = "이름:\t홍길동";
		str2 = "나이:\t20세";
		String str3 ="핸드폰:\t010-1111-1111";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println();		
		
		
		//4.\b
		// - backspace
		str ="홍길동\b입니다.";
		System.out.println(str);//홍길입니다.
		
		
		
		//5. \", \', \\
		//str = "홍길동 왈 : "안녕하세요"";
		str = "홍길동 왈 : \"안녕하세요\"";
		System.out.println(str);
		
		//Invalid escape sequence (valid ones are  \b  \t  \n  \f  \r  \"  \'  \\ )
		//[요구사항] D:\class\java
		str ="D:\\class\\java";
		System.out.println(str);
		
		System.out.println("안녕하세요\n" + "제 이름은 신보경입니다." );
		
	}

}
