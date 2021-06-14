package com.project.manager;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 직원들의 모든 서류(지각/조퇴)가 담겨있는 파일을 읽어
 * 서명이 미완료된 서류들을 보여주는 클래스입니다.
 * (직원들의 출퇴근 정보가 올바르게 체크되었는지 파악하기 위한 클래스)
 * @author 3조
 */
public class CommuteDocument {

	private final static String DATA;

	static {
		DATA = "C:\\Project\\직원서류서명더미.txt";
	}

	public void commuteDocument() {

		System.out.println("===================");
		System.out.println("<미완료된 서류>");

		try {

			BufferedReader reader = new BufferedReader(new FileReader(DATA));

			String line = "";

			int i = 1;
			while ((line = reader.readLine()) != null) {

				// 구대혁■지각■2021-05-07

				String[] temp = line.split("■");

				System.out.printf("%d%s\t%s\t%s\n", i, temp[1], temp[2], temp[3]);
				i++;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("===================");
	}

}
