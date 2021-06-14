package com.test.java.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex72_File {
	
	private static Scanner scan;// this를 못읽으니까 static
	private final static String DATA;//경로를 스테틱으로
	
	static {
		scan = new Scanner(System.in);
		DATA = ".\\dat\\student.dat";//.이 지금 폴더를 가르킴 다음은 폴더이름(dat) //상대경로
		//DATE = "C:\\class\\java\\JavaTest\\dat\\student.dat"; //절대 경로
	}
	
	
	public static void main(String[] args) {
		
		//File file = new File(DATA);
		//System.out.println(file.exists());//파일이 있음(경로가 있는지
		
		//학생 정보 관리
		// - 순수 파일 입출력 기반
		// - 데이터를 지속적으로 관리(****) -> 데이터 구조 설계(저장할 파일 생성 + 저장할 구조(패턴)
		//		- JavaTest > dat폴더 생성
		//				- student.dat 파일 생성
		
		// - 데이터의 정의
		//		- 학생 정보?
		//			- 이름, 나이, 국어, 영어, 수학//CSV형식으로 작성!
		//			- 홍길동,14,100,90,80
		
		//데이터 조작 -> CRUD -> Create, Read, UPdate, Delete
		
		//기능
		// - 학생 정보 저장하기 (C)
		// - 학생 정보 목록 (R)
		// - 학생 정보 삭제하기 (D)
		
		System.out.println("[학생 정보 관리]");
		
		boolean loop = true;
		
		while (loop) {
			
			//메뉴 출력
			//선택
			//분기
			
			String seq = menu();
			
			if (seq.equals("1")) {
				add();
			} else if(seq.equals("2")) {
				list();
			} else if(seq.equals("3")) {
				delete();
			} else {
				loop = false;
			}
			
		}
		
		
		
		
		System.out.println("프로그램 종료");
		
	}//main
	
	private static void pause() {
		System.out.println("엔터를 누르시면 다음으로 진행합니다.");
		scan.nextLine();//Block
	}
	
	
	private static void delete() {
		
		//*** 중요
		System.out.println("[학생 삭제]");
		
		try {
			//명단 출력			
			BufferedReader reader = new BufferedReader(new FileReader(DATA));
			
			String line = "";
			
			System.out.println("[이름]");
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(","); //split가 뭐징..
				System.out.printf("%s\n"
										, temp[0]);
				
			}
			
			reader.close();
			
			System.out.println("삭제할 학생을 선택하세요.");
			System.out.println("선택(이름): ");//번호로 해라 그냥
			
			String name = scan.nextLine();
			
			
			
			reader = new BufferedReader(new FileReader(DATA));
			
			String result = ""; //누적 변수
			line = "";
			
			
			while ((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (!temp[0].equals(name)) {
					result += line + "\r\n";
				}
				
				
			}
			
			reader.close();
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DATA));
			
			writer.write(result);
			
			writer.close();
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		pause();
		
		
	}

	private static void list() {
		
		System.out.println("[학생 목록]");
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DATA));
			
			String line = "";
			
			System.out.println("[이름]\t[나이]\t[국어]\t[영어]\t[수학]\t");
			
			while ((line = reader.readLine()) != null) {
				
				//학생 1명 -> 모든 학생 탐색
				String[] temp = line.split(","); //split가 뭐징..
				System.out.printf("%s\t%5s\t%5s\t%5s\t%5s\t\n"
										, temp[0]
										, temp[1]
										, temp[2]
										, temp[3]
										, temp[4]);
									
				
				
			}
			
			reader.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pause();
	}

	private static void add() {
		
		Utill utill = new Utill();
		
		System.out.println("[학생 추가]");
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		String age = utill.get("나이");
		String kor = utill.get("국어");
		String eng = utill.get("영어");
		String math = utill.get("수학");
		
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DATA, true));
			
			//홍길동,12,100,90,80
			writer.write(String.format("%s,%s,%s,%s,%s\n", name,  age, kor, eng, math));
			
			writer.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		pause();
		
	}

	private static String menu() {
		
		System.out.println("=========================");
		System.out.println("1. 학생 정보 등록하기");
		System.out.println("2. 학생 정보 목록보기");
		System.out.println("3. 학생 정보 삭제하기");
		System.out.println("4. 종료");
		System.out.println("=========================");
		System.out.println("선택: ");

		String sel = scan.nextLine();
		
		return sel;
		
		
	}
	
	
	

}
























