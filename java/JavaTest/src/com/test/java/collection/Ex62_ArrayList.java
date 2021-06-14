package com.test.java.collection;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


//mathod에 커서두고 F3은 정의된 곳으로 이공
public class Ex62_ArrayList {

	//학생 목록
	//Student[] list = new Student[?];
	private static ArrayList<Student> list;//만들자마자 초기화 하지마 생성자에서 함!
	private static Scanner scan;
	//main에서 쓸라문 static (main은 this를 쓸수업음)
	
	//정적생성자
	static {
		list = new ArrayList<Student>();
		scan = new Scanner(System.in);
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		
		//ArrayList 사용 -> 데이터 집합 -> 배열 사용 유사
		
		//배열 vs ArrayList? 
		// - 길이가 고정인가?
		// - 사용 편의성 -> ArrayList 편함
		
		//학생 관리
		// - 정원 5명
		// - 추후 증가/감소
		
		//학생
		// - 이름
		// - 나이
		// - 국어, 영어, 수학
		
		//학생 정보 관리
		//메뉴
		//1. 학생 추가
		//2. 학생 목록
		//3. 학생 삭제
		//4. 학생 검색
		
		
		dummy();
		
		System.out.println("[학생 정보 관리]");
		
		boolean loop = true;
		
		
		
		while(loop) {
			
			System.out.println("===================");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 목록");
			System.out.println("3. 학생 삭제");
			System.out.println("4. 학생 검색");
			System.out.println("5. 종료");
			System.out.println("===================");
			
			System.out.println("선택: ");
			String sel = scan.nextLine();
			
			if (sel.equals("1") ) {
				add();
			} else if (sel.equals("2") ) {
				list();
			} else if (sel.equals("3") ) {
				delete();
			} else if (sel.equals("4") ) {
				search();
			}  else {
				loop = false;
			}
			
			
			System.out.println("프로그램을 종료합니다.");
		}
		
	}//main


	private static void dummy() {

		//프로그램에서 사용할 임시 데이터 생성 메소드
		Random rnd = new Random();
		
		String[] name = {"홍길동", "가가가", "나나나", "다다다", "마마마", "바바바", "사사사"};
		
		for (int i=0; i<5; i++) {
			
			Student s = new Student();
			
			s.setName(name[rnd.nextInt(name.length)]);// 0~8	
			s.setAge(rnd.nextInt(5) + 15); //15~19
			
			Subject subject = new Subject();
			subject.setKor(rnd.nextInt(40) +61);// 60~100
			subject.setEng(rnd.nextInt(40) +61);
			subject.setMath(rnd.nextInt(40) +61);
			
			s.setSubject(subject);
			
			list.add(s);
		}
	}


	private static void add() {

		//학생 추가
		System.out.println("[학생 추가]");
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		
		System.out.print("국어: ");
		int kor = scan.nextInt();
		
		System.out.print("영어: ");
		int eng = scan.nextInt();
		System.out.print("수학: "); //100\r\n중 nextInt는 100만 가져옴 엔터는 NextLine 쓸때 따로 우리가 버려야함 
		int math = scan.nextInt(); //입렵값에 포함된 엔터를 버리지 않고 남겨둔다.
		
		scan.skip("\r\n"); //남아있는 엔터가 다음 NextLint()에 영향을 주지 않도록 \r\n을 skip
		
		//Case A.
		//Subject subject = new Subject(kor, eng, math);
		//Student s = new Student(name, age, subject);
		
		//Case B.
		Student s = new Student(name, age, kor, eng, math);
		
		//목록에 추가하기
		list.add(s);
		
		System.out.println("학생 추가가 완료되었습니다.");
		
		pause();
	}


	private static void pause() {
		System.out.println("계속 하시려면 엔터를 입력하세요."); //프로그램을 잠깐 멈춤
		scan.hasNextLine();
	}

	private static void list() {

		System.out.println("========================================");
		System.out.println("[이름]\t[나이]\t[국어]\t[영어]\t[수학]");
		System.out.println("========================================");
		
		for( Student s : list) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\n"
								, s.getName()
								, s.getAge()
								//,s.getSubject().getKor
								, s.getKor()
								, s.getEng()
								, s.getMath());
		}
		
		pause();
		
		
	}


	private static void delete() {

		System.out.println("[학생 삭제]");
		
		System.out.println("이름: ");
		String name = scan.nextLine();
		
		//indexOf사용 불가
		// -> 직접 탐색
		for(int i=0; i<list.size(); i++) {
			
			if (list.get(i).getName().equals(name)) {
				list.remove(i);
				break;
			}
		}
		
		
		System.out.println("학생 삭제를 완료했습니다.");
		pause();
	}


	private static void search() {

		System.out.println("[학생 검색]");
		
		System.out.println("이름: ");
		String name = scan.nextLine();
		
		for(int i=0; i<list.size(); i++) {
			
			//정확한 이름 검색
			//if(list.get(i).getName().equals(name))
			
			//if(list.get(i).getName().indexOf(name) > -1) {
			if(list.get(i).getName().contains(name)) {
				
				System.out.printf("%s\t%d\t%d\t%d\t%d\n"
						, list.get(i).getName()
						, list.get(i).getAge()
						//,s.getSubject().getKor
						, list.get(i).getKor()
						, list.get(i).getEng()
						, list.get(i).getMath());
			}
		
		
		}
		
	}


}//Ex62



class Student {
	
	private String name;
	private int age;
	
	//private int kor;
	//private int eng;
	//private int math;
	//private int[] subject;
	
	private Subject subject;
	
	public Student() {
		this.name = "";
		this.age = 0;
		this.subject = null;
	}
	
	public Student(String name, int age, Subject subject) {
		this.name = name;
		this.age = age;
		this.subject = subject;
	}
	
	public Student(String name, int age, int kor, int eng, int math) {
		this.name = name;
		this.age = age;
		this.subject = new Subject(kor, eng, math);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
	public void setKor(int kor) {
		this.subject.setKor(kor);
	}
	
	public void setEng(int eng) {
		this.subject.setEng(eng);
	}
	
	public void setMath(int math) {
		this.subject.setMath(math);
	}
	
	public int getKor() {
		return this.subject.getKor();
	}
	
	public int getEng() {
		return this.subject.getEng();
	}
	
	public int getMath() {
		return this.subject.getMath();
	}

	@Override
	public String toString() {
		return String.format("Studens [name=%s, age=%d, kor=%d, eng=%d, math=%d"
							, this.name
							, this.age
							, this.subject.getKor()
							, this.subject.getEng()
							, this.subject.getMath());
	}
	
	
}

class Subject {
	
	private int kor;
	private int eng;
	private int math;
	
	public Subject() {
		//this.kor =0;
		//this.eng =0;
		//this.math =0;
		this(0,0,0);
	}
	

	public Subject(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}



	public int getKor() {
		return kor;
	}



	public void setKor(int kor) {
		this.kor = kor;
	}



	public int getEng() {
		return eng;
	}



	public void setEng(int eng) {
		this.eng = eng;
	}



	public int getMath() {
		return math;
	}



	public void setMath(int math) {
		this.math = math;
	}



	@Override
	public String toString() {
		return "Subject [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
	
	
	
}













