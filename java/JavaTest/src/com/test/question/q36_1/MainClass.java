package com.test.question.q36_1;

public class MainClass {

	public static void main(String[] args) {
		
		Packer packer = new Packer();
		
		//연필
		Pencil p1 = new Pencil();
		p1.setHardness("HB");
		packer.packing(p1);
		
		Pencil p2 = new Pencil();
		p2.setHardness("B");
		packer.packing(p2);
		
		//지우개
		Eraser e1 = new Eraser();
		e1.setSize("Large");
		packer.packing(e1);
		
		//볼펜
		BallPointPen b1 = new BallPointPen();
		b1.setTickness(0.3);
		b1.setColor("black");
		packer.packing(b1);
		
		BallPointPen b2 = new BallPointPen();
		b2.setTickness(1.5);
		b2.setColor("red");
		packer.packing(b2);
		
		//자
		Ruler r1 = new Ruler();
		r1.setLength(30);
		r1.setShape("줄자");
		packer.packing(r1);
		
		//결과 확인
		packer.coutPacking(0);
		packer.coutPacking(1);
		packer.coutPacking(2);
		packer.coutPacking(3);
		packer.coutPacking(4);
		
		
		
		
	}
}
