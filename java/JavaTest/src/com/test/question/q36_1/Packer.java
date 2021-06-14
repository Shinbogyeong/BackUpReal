package com.test.question.q36_1;

public class Packer {
	
	private static int pencilCount;
	private static int eraserCount;
	private static int ballPointPenCount;
	private static int rulercount;
	
	public void packing(Pencil pencil) {
		System.out.printf("포장 전 검수 : %s입니다.\n", pencil.info());
		this.pencilCount ++;
		System.out.println("포장을 완료했습니다.");
	}
	
	public void packing(Eraser eraser) {
		System.out.printf("포장 전 검수 : %s입니다.\n", eraser.info());
		this.eraserCount ++;
		System.out.println("포장을 완료했습니다.");
	}
	
	public void packing(BallPointPen ballPointPen) {
		System.out.printf("포장 전 검수 : %s입니다.\n", ballPointPen.info());
		this.ballPointPenCount ++;
		System.out.println("포장을 완료했습니다.");
	}
	
	public void packing(Ruler ruler) {
		System.out.printf("포장 전 검수 : %s입니다.\n", ruler.info());
		this.rulercount ++;
		System.out.println("포장을 완료했습니다.");
	}
	
	public void coutPacking(int type) {
		System.out.println("\n==================");
		System.out.println("포장 결과");
		System.out.println("==================");
		
		if(type == 0 || type == 1) {
			System.out.printf("연필 %d회\n", this.pencilCount); }
		if(type == 0 || type == 2) {
			System.out.printf("지우개 %d회\n", this.eraserCount);}
		if(type == 0 || type == 3) {
			System.out.printf("볼펜 %d회\n", this.ballPointPenCount); }
		if(type ==0 || type == 4) {
			System.out.printf("자 %d회\n", this.rulercount); }
	}

}
