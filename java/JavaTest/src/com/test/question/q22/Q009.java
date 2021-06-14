package com.test.question.q22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("컴퓨터가 1~10 사이의 숫자를 1개 생각했습니다.");
		
		int com = (int)(Math.random() * 10) + 1;
		
		for(int i = 1;;i++) {
			System.out.println("숫자 : ");
			
			int num = Integer.parseInt(reader.readLine());
			
			if(num == com) {
				
				System.out.println("맞췄습니다.");
				
				System.out.printf("컴퓨터가 생각할 숫자는 %d입니다.\n정답을 맞추는데 시도한 횟수는 %d회입니다.", com, i);
				
				break;
				
			} else {
				
				System.out.println("틀렸습니다.");
			}
			
		}
		
		
	}
}

/* for문을 무한루프로 지정했을 떼
 
 int count = 0; //시도 횟수
      
      for(;;) {
         System.out.print("숫자: ");
         int num = Integer.parseInt(reader.readLine());
         
         count++; // 시도한 횟수 증가
         
         if(num == computer) {
            System.out.println("정답입니다~!\n");
            System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n", computer);
            System.out.printf("정답을 맞추는데 시도한 횟수는 %d회입니다.\n", count);
            System.out.println("프로그램을 종료합니다.");
            break;
         }
         else {
            System.out.println("틀렸습니다!");
            System.out.println();
         }//if-else문

 */










