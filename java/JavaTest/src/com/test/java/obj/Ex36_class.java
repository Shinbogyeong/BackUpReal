package com.test.java.obj;

public class Ex36_class {

	public static void main(String[] args) {
		
		//1. 값형(원시형)배열
		//2. 참조형 배열
		
		int[] num = new int[3]; // int X 3개
		
		num[0] = 10;
		num[1] = 20;
		num[2] = 30;
		
		for(int n : num) {
			System.out.println(n);
		}
		
		
		
		Item item1 = null;
		Item item2 = new Item();
		Item item3;
		
		//초기화하지 않은 지역변수는 사용이 불가능 하다.
		//java.lang.NullPointerException or NullReferenceException or 널참조
		// -error찾아간 곳에 객체의 주소(pointer)가 아닌 널값이 없음
		//item1.setColor("노랑");
		
		
		//Item방을 만들려면
		// -> Item item
		
		//Item 객체(붕어빵)를 만들려면
		// -> new Item()
		
		
		Item[] items = new Item[3]; //Item X3개 - 배열만 만든것!! 그안에 값은 null
		
		items[0] = new Item(); //Item item1 = new Item(); 동일 //여기서 객체를 만든것
		items[1] = new Item();
		items[2] = new Item();
		
		// - 모든 예외 Top no.1
		items[0].setName("키보드");
		items[1].setColor("검정");
		items[2].setPrice(500000);
		
		System.out.println(items[0].getName());	
		System.out.println(items[0].getColor());	
		System.out.println(items[0].getPrice());	
		
		
		
		
		
		
		
		
	}//main

}//Ex36


class Item {
	
	private String name;
	private String color;
	private int price;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}


