package com.test.question.q30;

import java.util.Calendar;

public class Bugles {
	
	private int price;
	private int weight;
	private Calendar creationTime = Calendar.getInstance();
	private int expiration;
	private int expirationTime; //남은 유통기한 날짜
	

	
	//getter, setter
	
	//weight
	public void setSize(int weight) throws Exception {
		
		if(weight == 300 || weight == 500 || weight == 850)	{
			this.weight = weight;
		} else {
			throw new Exception("잘못된 용량입니다.");
		}
		
	}
	
	//price
	public int getPrice() {
		
		switch(this.weight) {
		case 300 :
			price = 850;
			break;
		case  500 :
			price = 500;
			break;
		case 850 :
			price = 1950;
			break;
		}
		
		return price;
		
	}
	
	//setCreationTime
	//'1' ~ '9' -> 48 ~ 57
	public void setCreationTime(String creationTime) {
		
		String newCreationTime = "";
		
		for(int i = 0; i<creationTime.length(); i++) { //숫자가 아닌 문자 제외
			if(creationTime.charAt(i) >= '0' && creationTime.charAt(i) <= '9') {
				newCreationTime += creationTime.substring(i, i+1);
			}
		}
		
		int year = Integer.parseInt(newCreationTime.substring(0, 4));
		int month = Integer.parseInt(newCreationTime.substring(4, 6));
		int date = Integer.parseInt( newCreationTime.substring(6));

		this.creationTime.set(year, month - 1, date);//month -1!!
		
	}
	
	//getExpiration
	public int getExpiration() {
		
		//유통기한 설정
		switch(this.weight) {
		case 300 :
			expiration = 7;
			break;
		case  500 :
			expiration = 10;
			break;
		case 850 :
			expiration = 15;
			break;
		}
		
		creationTime.add(Calendar.DATE, expiration ); //생산일자 + 유통기한
		
		Calendar now = Calendar.getInstance();
		
		long creationTimeTick = creationTime.getTimeInMillis();//2021.3.29
		long nowTick = now.getTimeInMillis();//2021.3.19
		
		expirationTime = (int) ((creationTimeTick - nowTick) / 1000 / 60 / 60 / 24);
		
		return (int) ((creationTimeTick - nowTick) / 1000 / 60 / 60 / 24);
	}
	
	public void eat() {
		if( expirationTime >= 0) {
			System.out.println("과자를 맛있게 먹습니다.");
			System.out.println();
		} else {
			System.out.println("유통기한이 지나 먹을 수 없습니다.");
			System.out.println();
		}
	}
	

}
