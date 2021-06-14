package com.test.question.q36;

public class Box {
	
	//요구사항]다량의 객체를 잘 제어할 수 있는지?
	private Macaron[] list = new Macaron[10];
	
	public void cook() {
		//마카롱 만들기
		//1.객체 생성
		//2. 각 값을 랜덤으로 대입
		//3. 상자에 담기
		for(int i=0; i<this.list.length; i++) {
			
			Macaron m = new Macaron();
			list[i] = m;
			
			//size
			list[i].setSize((int)(Math.random() * 11) + 5);
			
			//Color //swich문일 때 복잡함.. 
			String color[] = new String[]{"red", "blue", "yellow", "white", "pink", "puple", "green", "black"}; //8가지
			
			list[i].setColor(color[(int)(Math.random() * color.length)]);
			
			//thickness
			list[i].setThickness((int)(Math.random() * 20) + 1);
		}
		System.out.printf("마카롱을 %d개 만들었습니다.\n\n", this.list.length);
	}
	
	
	
	public void check() {
		
		int pass = 0;
		int fail = 0;
		for(int i=0; i<this.list.length; i++) {
			if(//유효하지 않을때 
					(list[i].getSize() < 8 || list[i].getSize() > 14)
					|| (list[i].getThickness() < 3 || list[i].getThickness() > 18 )
					||list[i].getColor().equals("black")
				) {
				fail++;
			} else  { 
				pass++;
			}
		}
		System.out.printf("QC 합격 개수  : %d개 \nQC 불합격 개수 : %d개\n\n", pass, fail);
		
	}

	
	
	public void list() {
		
		for(int i=0; i<this.list.length; i++) {
			System.out.printf("%d번 마카롱 : %dcm(%s, %dmm) : %s\n"
								, i+1, list[i].getSize(), list[i].getColor(), list[i].getThickness(), check(i) );
		}
	}


	//합격여부 출력
	private String check(int i) {
		if(//유효하지 않을때 
				(list[i].getSize() < 8 || list[i].getSize() > 14)
				|| (list[i].getThickness() < 3 || list[i].getThickness() > 18 )
				||list[i].getColor().equals("black")
			) {
			return "불합격";
		} else  { 
			return "합격";
		}
	}

}
