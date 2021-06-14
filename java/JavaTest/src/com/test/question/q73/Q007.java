package com.test.question.q73;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Q007 {

	
	public final static String DATA;
	public static ArrayList<Member> list;
	
	static {
		DATA = "C:\\Users\\신보경\\Desktop\\파일_입출력_문제\\출결.dat";
		list = new ArrayList<Member>();
	}
	
//	2018-8-13,길수명,8:23,18:50
//	2018-8-13,이무게,8:55,16:49
//	2018-8-13,정형유,8:12,19:29
//	2018-8-13,하형무,7:26,16:5
//	2018-8-13,유돈형,8:51,19:29
//	2018-8-14,하석게,9:44,16:40
//	2018-8-14,전돈명,6:42,18:28
//	2018-8-14,길명돈,9:57,17:54
//	2018-8-14,정게돈,7:35,18:59
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader reader =  new BufferedReader(new FileReader(DATA));
			
			String line = "";
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				//list에서 같은 이름을 가진 member객체 찾기
				//Member member = new Member();
				Member member = new Member();
				
				//이름설정
				member.setName(temp[1]);
				
				
				//9보다 크면 지각
				if(temp[2].charAt(0) > '8') {
					member.setLate(1);
					//System.out.println(member);
					//System.out.println(temp[2]);
				}
				//18보다 작으면 조퇴
				if(Integer.parseInt(temp[3].substring(0, 2)) < 18){
					member.setLeave(1);
					//System.out.println(member);
					//System.out.println(temp[3]);
				}
				
				
				boolean result = true;
				
				//list에 추가
				for(Member mem: list) {
					if(mem.getName().equals(temp[1])) {
						mem.setLate(mem.getLate() + member.getLate());
						mem.setLeave(mem.getLeave() + member.getLeave());
						result = false;
					} 
				}
				
				if (result != false) {
					list.add(member);
				}
				
				
				
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		
		
		//같은 이름의 멤버가 계속 생김
		//System.out.println(list);
		System.out.println(list.size());
		
		for(Member mem : list) {
			System.out.println("[이름]\t[지각]\t[조퇴]");
			System.out.printf("%s\t%d회\t%d회\n"
						, mem.getName() , mem.getLate(),mem.getLeave());
			
		}
		
	}//main

	
	
	//받은 이름과 다르면 새로운 멤버를호출, 같은 이름을 가진 멤버가 있으면 그 멤버를 호출 
//private static Member newMember(String name) {
//	
//	Member newM = new Member();
//	
//	for(Member member: list) {
//		if(member.getName().equals(name)) {
//			//원래 member를 삭제 하고싶음
//			return member;
//		}
//	}
//	
//	return newM;
//}

}


