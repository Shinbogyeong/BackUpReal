package com.test.question.q73;

import java.util.Arrays;

public class Dummy {
	
	public static void main(String[] args) {
		
		
		int count = 100;
		//휴대폰 번호
		String[] phoneNum = new String[count];
		String[] address = new String[count];
		
		//주소
		String[] a1 = {"서울특별시", "인천광역시", "하남시", "구리시", "김포시", "과천시", "성남시", "부천시", "의정부시"};
		String[] a2 = {"동대문구", "서대문구", "중구", "남구", "강남구", "강동구", "수정구", "중랑구", "동작구", "부평구", "마포구", "영등포구", "서대문구", "은평구", "수지구"};
		String[] a3 = {"쌍문동", "방학동", "신봉동", "연남동", "역삼동", "길동", "천호동", "봉천동", "삼청동", "평창동", "구로동", "하계동", "중계동", "신도림동", "응암동", "수색동","명일동", "회현동", "노량진동", "대방동"};
		
		
		for(int i=0; i<count; i++) {
			
			//휴대폰 번호
			String pnum = String.format("%08d", (int)(Math.random()*100000000)) + "";
			phoneNum[i] = "010-" + pnum.substring(0,4) + "-" + pnum.substring(4);
			
			
			//주소
			address[i] = a1[(int)(Math.random() *a1.length)]
					+ " "
					+ a2[(int)(Math.random() *a2.length)]
					+ " "
					+ a3[(int)(Math.random() *a3.length)]
					+ " "
					+((int)(Math.random() * 330) + 1)
					+ "번지";
			
			
			//출근
			String workIn = String.format("%02d-%02d",((int)(Math.random()*2)+7), (int)(Math.random()*60));;
			String workOut = String.format("%02d-%02d",((int)(Math.random()*2)+18), (int)(Math.random()*60));
			
			
			
	
			//System.out.println(workIn);
			System.out.println(workOut);
			
			
			//출력해보기
//			System.out.println(phoneNum[i]);
//			System.out.println(address[i]);
			
			
		}
		
		
	}

}
