package com.project.employee;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 직원들이 출근/퇴근할 때 체크를 하여 출퇴근을 확인하고 
 * 자신의 이번달 근무 현황(지각/조퇴 등)을 확인 할 수 있는 클래스입니다.
 * 0: 직원목록으로 돌아가기, 해당 클래스로 이동하기
 * @author 3조 
 */

public class Commute {

	private static Scanner scan;

	static {
		scan = new Scanner(System.in);
	}

	public void commute() throws FileNotFoundException {

		System.out.println("===================");
		System.out.println("1. 출근 체크");
		System.out.println("2. 퇴근 체크");
		System.out.println("3. 근태 확인");
		System.out.println("===================");
		System.out.print("선택(0:뒤로가기): ");

		String sel = scan.nextLine();

		if (sel.equals("0")) {
			// 종료
			System.out.println("목록으로 돌아갑니다.");
			EmployeeOption.option();

		} else if (sel.equals("1")) {
			// 출근 체크
			InCheck ic = new InCheck();
			ic.incheck();

		} else if (sel.equals("2")) {
			// 퇴근 체크
			OutCheck oc = new OutCheck();
			oc.outCheck();

		} else if (sel.equals("3")) {
			// 근태확인
			CommuteCheck ch = new CommuteCheck();
			ch.commuteCheck();

		} else {
			System.out.println("번호를 다시 선택해주세요.");
			commute();
		}
	}

}