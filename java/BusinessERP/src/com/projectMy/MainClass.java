package com.projectMy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author
 *
 *
 */

public class MainClass {

	private static Scanner scan;
	private final static String DATA;
	public static ArrayList<Employee> list;
	public static Employee logEmployee;

	static String id;
	static String pw;

	static {
		scan = new Scanner(System.in);
		DATA = "C:\\Project\\직원더미.txt";
		list = new ArrayList<Employee>();
		logEmployee = new Employee();
	}

	public static void main(String[] args) {

		load();
		
		

		//System.out.println("[프로젝트]");

		login();
		
		System.out.println("번호를 입력하세요");

		
		boolean loop = true;
		
		while (loop) {
			
			//메뉴
			//선택
			//분기
			System.out.println("1 .스케줄 관리");
			System.out.println("2 .연차 신청");
			System.out.println("3 .관리자 스케줄 관리");
			String num = scan.nextLine();
			
			if (num.equals("1")) {
				Schedule s = new Schedule();
				s.schedule();
			} else if (num.equals("2")) {
				AnnualLeave a = new AnnualLeave();
				a.annualLeave();
			}  else if (num.equals("3")) {
				ManagerSchedule m = new ManagerSchedule();
				m.managerSchedule();
			} else {
				loop = false;
				
			}
					
		}
		//ID: 20028420
		//PW: 7558
		//박창윤
		
		
		
		
		
		
		
		
	}// main

	private static void load() {

		try {

			BufferedReader reader = new BufferedReader(new FileReader(DATA));

			String line = "";

			while ((line = reader.readLine()) != null) {

				Employee employee = new Employee();

				// 1■김민수■인사부■부장■2014-12-07■20147245■1973-04-02■010-7599-0093■성남시 강남구 신도림동 195번지

				String[] temp = line.split("■");

				employee.setName(temp[1]);
				employee.setDivision(temp[2]);
				employee.setPosition(temp[3]);
				employee.setJoinDate(temp[4]);
				employee.setEmployeeNum(temp[5]);
				employee.setBirth(temp[6]);
				employee.setPhoneNum(temp[7]);
				employee.setAddress(temp[8]);

				list.add(employee);

			} // while

			reader.close();

		} catch (Exception e) {
			System.out.println("load: " + e);
		}

	}// load

	private static void login() {

		System.out.println("===================");
		System.out.print("ID: ");
		id = scan.nextLine();
		System.out.println("");
		System.out.print("PW: ");
		pw = scan.nextLine();
		
		int i=0;
		for (Employee e : list) {
			i++;
			if (id.equals("root")) {
				if (pw.equals("0000")) {
					System.out.println("===================");
					System.out.println("관리자 등록");
					
					break;
				} else {
					System.out.println("===================");
					System.out.println("비밀번호가 틀렸습니다.");
					login();
					break;
				}
			} else if (e.getEmployeeNum().equals(id)) {

				int index = e.getPhoneNum().lastIndexOf("-");
				e.getPhoneNum().substring(index + 1);
				if (pw.equals(e.getPhoneNum().substring(index + 1))) {
					System.out.println("===================");
					System.out.printf("%s로그인 완료\n", e.getName());

					logEmployee = e;
					
					//EmployeeOption em = new EmployeeOption();
					//em.option();
					break;
				}else {
					System.out.println("===================");
					System.out.println("비밀번호가 틀렸습니다.");
					login();
					break;
				}
				
			} else {
				if(i==99) {
					System.out.println("===================");
					System.out.println("다시 입력하세요.");
					login();
				}
			}

		}

	
	}

}// Project