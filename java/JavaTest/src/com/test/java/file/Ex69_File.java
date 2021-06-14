package com.test.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

import com.test.util.MyFile;

public class Ex69_File {
	
	private static int count = 0;
	private static int dcount = 0;
	private static long size = 0;
	
	public static void main(String[] args) {
		
		//Ex69_java
		
		//파일 & 디렉토리 조작
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		
		//m6();
		//m7();
		//m8();
		//m9();
		//m10();
		m11();
		//m12();
		//m13();
		
	}//main

	private static void m13() {
		
		// - 크기 : 718MB (753,803,141 바이트)
		// - 내용 : 파일 11,814, 폴더 2,522
				

		String path = "C:\\eclipse";
		File dir = new File(path);
		
		if(dir.exists()) {
			
			countFile(dir);
			System.out.printf("총 파일 개수: %,d개\n", count);//총 파일 개수: 11,814개
			System.out.printf("총 폴더 개수: %,d개\n", dcount);//폴더 개수: 2,523개(ecilps포함)
			System.out.printf("총 폴더 크기: %,dB\n개", size);
			System.out.printf("총 폴더 크기: %,.0fB\n개", (double)size / 1024 / 1024);
			
		}
	}

	
	private static void countFile(File dir) {
		
		File[] list = dir.listFiles();
		
		for (File sub : list) {
			if(sub.isFile()) {
				count++;
				size += sub.length();//폴더는 값이 없음 파일만 사이즈 재라~
			}
		}
		
		for (File sub : list) {
			if(sub.isDirectory()) {
				//***
				countFile(sub);//재귀 호출
				
			}
		}
		dcount++;;//이 메소드 호출이 곧 폴더 1개가 존재한다
	}

	
	
	
	private static void m12() {

		//재귀 메소드
		// - 팩토리얼
		// - 디렉토리 구조(***)
		
		//특정 폴더에 들어있는 파일 갯수?
		// - 크기 : 718MB (753,803,141 바이트)
		// - 내용 : 파일 11,814, 폴더 2,522
		
		String path = "C:\\eclipse";
		File dir = new File(path);
		
		int count = 0; //누적 변수
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (File sub : list) {
				if(sub.isFile()) {
					count++;
				}
			}
			
			for (File sub: list) {
				if(sub.isDirectory()) {
					File[] sublist = sub.listFiles();
					
					for(File subsub : sublist) {
						if (subsub.isFile()) {
							count++;
						}
					}
					
					for(File subsub :sublist) {
						if (subsub.isDirectory()) {
							File[] subsublist = subsub.listFiles();
							
							for(File subsubsub : subsublist) {
								if (subsubsub.isFile()) {
									count++;
								}
							}
							
							//....
						}
					}
				}
			}
			
			System.out.printf("총 파일 개수: %d개", count);
			
		}
		
		
		
	}

	private static void m11() {
		System.out.println("m11");
		
		//폴더의 내용보기
		// - 자식 폴더 + 자식 파일 목록
		
		String path = "C:\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			//String[] list = dir.list();
			
			//for (String name : list) {
				
				//System.out.println(name);
				
				//이름 -> 파일 객체 -> 정보 얻어오기
				//File file = new File(path + "\\" + name);
				
				//System.out.println(file.getName());
				
				//System.out.printf("%s - %d\n", file.getName(),file.isFile()? "파일" : "폴더");
				
			
			
			
			File[] list = dir.listFiles();//사용빈도높음
			
			//for (File file :list) {
			//	System.out.printf("%s - %d\n", file.getName(),file.isFile()? "파일" : "폴더");
			//}
			
			
			//출력 -> 탐색기처엄 출력
			for (File sub : list) {
				
				if(sub.isDirectory()) {
					System.out.printf("[%s]\n", sub.getName());
				}
				
			}
			for (File sub : list) {
				
				if(sub.isFile()) {
					System.out.printf("[%s]\n", sub.getName());
				}
				
			}
			
		}
			
	}
		
	

	
	
	private static void m10() {
		MyFile file  = new MyFile();
		
		String orgPath = "C:\\\\class\\\\java\\\\file\\\\JavaTest.zip";
		String copyPath = "C:\\\\class\\\\java\\\\file\\\\BBB\\\\JavaTest.zip";
		
		if(file.copy(orgPath, copyPath)) {
			System.out.println("복사성공");
		}
	}

	
	
//	private static void m9() {
//		
//		//파일 복사
//		// - C:\\class\\java\\file\\JavaTest.zip
//		// - C:\\class\\java\\file\\AAA\\JavaTest.zip
//		
//		File  org = new File("C:\\\\class\\\\java\\\\file\\\\JavaTest.zip");
//		File copy = new File("C:\\\\class\\\\java\\\\file\\\\AAA\\\\JavaTest.zip");
//		
//		//파일 복새 -> 바이트 단위 복사
//		//1. FileInputStream : 파일의 내용을 바이트 단위 읽기
//		//2. FileOuputStream : 파일의 내용을 바이트 단위 쓰기
//		
//		try {
//			
//			FileInputStream fis = new FileInputStream(org); //원본파일
//			FileOutputStream fos = new FileOutputStream(copy); //복사 파일
//			
//			//버퍼(512KB ~ 1KB내외)
//			byte[] buffer = new byte[1024];
//			
//			int length = 0;
//			
//			//복사
//			while ((length = fis.read(buffer)) >0) {
//				System.out.println(length);//1024
//				fos.write(buffer, 0, length);
//			}
//			System.out.println("파일 복사 완료");
//			
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		
//	}
//
//	
	
	private static void m8() {

		//폴더 삭제하기
		// - 빈폴더만 삭제 가능
		// - 내용물이 있으면.. 개발자가 그 안의 모든 내용물을 각각 직접 삭제한 뒤.. 해당 빈폴더로 만들고 난뒤 삭제한다.
		String path = "C:\\class\\java\\file\\member";
		File dir = new File(path);
		
		if(dir.exists()) {
			System.out.println(dir.delete());
		}
		
	}

	
	
	private static void m7() {

		//폴더명 바꾸기 + 폴더 이동하기 == 파일명 바꾸기 + 파일 이동하기
		String path = "C:\\class\\java\\file\\GGG";//원본
		File dir = new File(path);
		
		String path2 = "C:\\class\\java\\file\\AAA\\GGG"; //결과
		File dir2 = new File(path2);
		if (dir.exists()) {
			dir.renameTo(dir2);
			System.out.println("완료");
		}
		
	}

	
	
	private static void m6() {

		
		//폴더 생성
		String path = "C:\\class\\java\\file\\DDD\\EEE\\FFF"; //희망하는 폴더의 경로
		File dir = new File(path);
		
		if(!dir.exists()) {
			//생성
			//dir.mkdir(); //make directory -> path와 동일한 경로에 폴더를 생성한다.
			System.out.println(dir.mkdirs());
			System.out.println("생성완료");
		} else {
			//이미있음
			System.out.println("같은 이름의 폴더가 이미 존재합니다.");
		} 
		System.out.println();
		
		//요구사항] 회원 > 회원별 개인 폴더 작성하기
		//C:\class\java\file\member\[개인폴더]홍길동
		String[] member = {"홍길동", "아무개", "하하하", "호호호" };
		
		for (String name : member) {
			path = String.format("C:\\class\\java\\file\\member\\[개인폴더]%s", name);
			System.out.println(dir.mkdirs());
			
			
			System.out.println(name + ".개인폴더 생성완료.");
		}
		
		//요구사항] 2021년 날짜별 폴더 생성
		// - C:\class\java\file\date\2021-01-01
		// - ..
		// - C:\class\java\file\date\2021-12-31
		// - Calensdar사용

		Calendar c = Calendar.getInstance();
		c.set(2021, 0, 1); //2021-01-01
		
		//System.out.println(c.getActualMaximum(Calendar.DAY_OF_MONTH));
		//System.out.println(c.getActualMaximum(Calendar.DAY_OF_YEAR));//년도가 가진 날에 최대 숫자//365
		
		for (int i=0; i<c.getActualMaximum(Calendar.DAY_OF_YEAR); i++) {
			
			path = String.format("C:\\class\\java\\file\\date\\%tF", c);
			dir = new File(path);
			
			if(dir.mkdirs()) {
				System.out.printf("%tF\n", c);
			} else {
				System.out.println("failed");
			}
			c.add(Calendar.DATE, 1);
		}
		
		
		
		
	}

	
	
	private static void m5() {

		//파일 삭제
		String path2 = "/C:\\class\\java\\file\\BBB\\m3.txt";
		File file = new File(path2);
		
		if (file.exists()) {
			
			//***진짜 삭제(휴지통 X)
			// - 복구 불가능
			System.out.println(file.delete());
		}
		
	
	}

	
	
	private static void m4() {

		//파일 조작
		// - 이름 바꾸기
		
		///C:\class\java\file\AAA\m3.txt
		//m3.txt -> m4.txt(이름바꾸기)
		String path = "C:\\class\\java\\file\\AAA\\\\m4.txt";
		File file = new File(path);
		
		String path2 = "/C:\\class\\java\\file\\BBB\\m3.txt";
		File file2 = new File(path2);
		
		if (file.exists()) {
			
			//파일명 바꾸기
			file.renameTo(file2);
			
			System.out.println("완료");
			
			
		}
				
		
		
	}

	private static void m3() {

		//파일 조작
		// - 생성(X), 이동(O), 이름 바꾸기(O), 복사(X), 삭제(O)
		
		//C:\class\java
		//C:\class\java\file\AAA 폴더생성
		//C:\class\java\file\BBB 폴더생성
		//C:\class\java\file\AAA\m3.txt 파일생성
		
		//파일 이동(m3.txt)
		//AAA -> (이동) -> BBB
		
		//이동할 파일 참조 객체
		String path = "C:\\class\\java\\file\\AAA\\m3.txt";
		File file = new File(path);
		
		//이동이 끝난 뒤에 모습을 참조할 객체
		String path2 = "C:\\class\\java\\file\\BBB\\m3.txt";
		File file2 = new File(path2);
		
		if(file.exists()) {
			
			//이동하기
			// - true: 성공
			// - flase: 실패(같은 파일이 이미 있는 경우)
			
			if (file2.exists()) {
				//
				System.out.println("이미 동일한 파일이 존재합니다.");
				
				//추가 업무
				//? 1. 덮어쓰기, 2. 그만두기
				//1. 기존 파일 삭제 -> 이동하기
				
			}else {
				
				//이동하기
				boolean result = file.renameTo(file2);
				System.out.println(result);
				
			}
			
			System.out.println("완료");
			
			
			
		} else {
			System.out.println("없습니다.");
		}
		
		
	}

	private static void m2() {
		
		//운영체제
		// - 파일, 폴더 = 동일한 객체
		// - 폴더는 파일의 한 종료
		// - 폴더는 공간이 아니다.(***)
		
		
		//특정 폴더 정보 얻어오기
		//C:\class\java
		
		//경로
		String path = "C:\\class\\java";
		
		//참조 객체 생성
		File dir = new File(path);//클래스 같음
		
		if(dir.exists()) {
			
			System.out.println(dir.getName()); //java (***)
			System.out.println(dir.isFile()); //false - 너파일이니? (***)
			System.out.println(dir.isDirectory()); //true - 너 폴더니? (***)
			//폴더 대상으로 잘 안씀
			//System.out.println(dir.length()); //폴더는 크기가 중요하지 않다.(0B취급)//4096
			System.out.println(dir.getPath()); //경로
			System.out.println(dir.getAbsolutePath()); //경로
			
			//-------------------------------------------------------
			System.out.println(dir.lastModified()); //최종 수정 시간(Tick값)1619499968019
			System.out.println(dir.canRead()); //true
			System.out.println(dir.canWrite()); //true
			System.out.println(dir.isHidden()); //false
			
			
		} else {
			System.out.println("폴더가 존재하지 않습니다.");
		}
		
	}

	private static void m1() {
		
		//특정 파일 정보 얻어오기
		// - C:\class\java\\m1.jxt
		
		//외부 파일 접근 > 파일에 대한 참조 객체(대리인) 생성 > 참조 객체 조작 > 외부 파일 조작
		
		//경로
		String path = "C:\\class\\java\\m1.txt";
		
		//참조 객체 생성
		File file = new File(path); //path는 실제로 있는 파일? 없는 파일? -> 상관없이 객체가 만들어지낟.
		
		System.out.println(file.exists()); //해당 경로의 파일이 실제로 존재합니까?
		
		if (file.exists()) {
			
			System.out.println("파일이 존재합니다.");
			
			//업무 진행
			//파일 정보 가져오기
			//---------------------------------------------------------------
			System.out.println(file.getName()); //m1.txt (***)
			System.out.println(file.isFile()); //true - 너파일이니? (***)
			System.out.println(file.isDirectory()); //false - 너 폴더니? (***)
			System.out.println(file.length()); //28 //파일 크기(바이트)
			System.out.println(file.getPath()); //경로
			System.out.println(file.getAbsolutePath()); //경로
			//---------------------------------------------------------------
			
			
			//Tick -> Calendar
			Calendar c = Calendar.getInstance();
			//c.getTimeInMillis();틱값 가져오기
			c.setTimeInMillis(1619499985755L);
			
			System.out.printf("%tF %tT\n", c, c);
			
			System.out.println(file.lastModified()); //최종 수정 시간(Tick값)1619499985755 
			System.out.println(file.canRead()); //true
			System.out.println(file.canWrite()); //true
			System.out.println(file.isHidden()); //false
			
			
			
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		
		
		
	}//m1
	
	

}
