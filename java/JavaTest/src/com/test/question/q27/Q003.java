package com.test.question.q27;

public class Q003 {
	public static void main(String[] args) {
		
		int[] list = new int[] {10, 20, 30, 40};
		
		String result = dump(list);
		
		System.out.printf("nums = %s\n", result);
	}

	private static String dump(int[] list) {
		String txt = "[";
		
		for(int i=0; i<list.length; i++) {
			txt += list[i] + ", ";
		}
		txt= txt.substring(0, txt.length()-2) + "]";
		
		return txt;
	}

}
