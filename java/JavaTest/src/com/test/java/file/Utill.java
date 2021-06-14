package com.test.java.file;

import java.util.Scanner;

public class Utill {

	public String get(String lable) {
		Scanner scan = new Scanner(System.in);
		System.out.print(lable + ":");
		return scan.nextLine();
	}
}
