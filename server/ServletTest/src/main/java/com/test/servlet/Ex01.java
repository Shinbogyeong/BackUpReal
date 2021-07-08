package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. 서블릿 클래스 선언
//a. javax.servlet.http.HttpServlet 클래스를 상속한다.(간편함) -> 주로 사용함
public class Ex01 extends HttpServlet{
	
	//2. doGet/doPost 메소드 선언
	//a. 매개변수 작성(2개)
	//	1. javax.servlet.http:HttpServletRequest
	//	2. javax.servlet.http:HttpServletResponse
	//b. 예외 미루기(2개)
	//	1. java.io.IOException : 페이지를 동적으로 만드는 작업(외부 입출력 발생)
	//	2. javax.servlet.ServletException : 서블릭과 관련 예외 처리
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		//3. 동적 HTML 문서 작성 구현
		PrintWriter writer = response.getWriter();
		
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<h1>Number</h1>");
		Random rnd = new Random();     
		writer.write("<div>num:" + rnd.nextInt(100)+ "</div>");
		writer.write("</body>");
		writer.write("</html>");
      
		writer.close(); //***
		
	}

}
