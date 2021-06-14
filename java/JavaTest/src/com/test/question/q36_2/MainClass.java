package com.test.question.q36_2;

public class MainClass {
	
	public static void main(String[] args) {
		
		Barista barista = new Barista();
		
		Espresso e1 = barista.makeEspresso(30);
		e1.drink();
		
		Latte l1 = barista.makeLatte(30, 250);
		l1.drink();
		
		Americano a1 = barista.makeAmericano(30, 300, 20);
		a1.drink();
		
		Espresso[] e2 = barista.makeEspresso(25, 10);
		for(Espresso e : e2) {
			e.drink();
		}
		
		Latte[] l2 = barista.makeLattes(25, 300, 5);
		for(Latte l : l2) {
			l.drink();
		}
		
		Americano[] a2 = barista.MakeAmericanos(20, 350, 30, 15);
		for(Americano a : a2) {
			a.drink();
		}
		
		barista.result();
	}

}
