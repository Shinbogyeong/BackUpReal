package com.test.java;

public class Question03 {
	public static void main(String[] args) {
		/*출력물
		 [날짜] 		[내역]	 		[금액]
	------------------------------------------------
	2020-01-01 		카페라테 			4,800원
	2020-01-01 		돼지불백 			8,500원
	2020-01-02 		마트 장본것들	 	125,840원
	2020-01-03 		교통 카드 충전 	45,000원
	2020-01-03 		편의점 			16,200
		 */
		
		String date_01 = "2020-01-01";
		String date_02 = "2020-01-02";
		String date_03 = "2020-01-03";

		String nameCafe = "카페라테";
		String nameBullback = "돼지불백";
		String nameMart = "마트 장본것들";
		String nameCard = "교통 카드 충전";
		String nameConvenience = "편의점";
		
		int payCafe = 4800;
		int payBullback = 8500;
		int payMart = 125840;
		int payCard = 45000;
		int payConvenience = 16200;
		
		System.out.println("[날짜]		[내역]		[금액]"	);
		System.out.println("---------------------------------------------");
		System.out.printf("%s\t%s\t\t%,d원\n", date_01, nameCafe, payCafe);
		System.out.printf("%s\t%s\t\t%,d원\n", date_01, nameBullback, payBullback);
		System.out.printf("%s\t%s\t%,d원\n", date_02, nameMart, payMart);
		System.out.printf("%s\t%s\t%,d원\n", date_03, nameCard, payCard);
		System.out.printf("%s\t%s\t\t%,d원\n", date_03, nameConvenience, payConvenience);
		
		
	}

}
