package com.test.question.q25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q004 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int gif = 0, jpg = 0, png =0 , hwp = 0, doc = 0;
		
		for(int i=0; i<5; i++) {

		System.out.println("파일명 :");
		String name = reader.readLine();
		
			if (name.endsWith(".gif")) {
				gif++;
			} 
			if (name.endsWith(".jpg")) {
				jpg++;
			} 
			if(name.endsWith(".png")) {
				png++;
			} 
			if (name.endsWith(".hwp")) {
				hwp++;
			} 
			if (name.endsWith(".doc")) {
				doc++;
			} 
		}
		
		System.out.printf("gif: %d개 \njpg: %d개\npng: %d개\nhwp: %d개\ndoc: %d개", gif, jpg, png, hwp, doc);

		
	}

}
