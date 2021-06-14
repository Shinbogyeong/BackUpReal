package com.test.question.q36_2;

public class Barista {
	
	public Espresso makeEspresso(int bean) {
		
		Espresso e1 = new Espresso();
		e1.setBean(bean);
		
		Coffee.espresso ++;
		Coffee.bean += bean;
		Coffee.beanTotalPrice += Coffee.beanUnitPrice * bean;
		
		return e1;
	}
	
	public Espresso[] makeEspresso(int bean, int count) {
		
		Espresso en[] = new Espresso[count];
		for(int i=0; i<count; i++) {
			en[i] = new Espresso();
			en[i].setBean(bean);
		}
		
		Coffee.espresso += count;
		Coffee.bean += bean * count;
		Coffee.beanTotalPrice += Coffee.beanUnitPrice * (bean * count);
		
		return en;
	}
	
	public Latte makeLatte(int bean, int milk) {
		
		Latte l1 = new Latte();
		l1.setBean(bean);
		l1.setMilk(milk);
		
		Coffee.latte ++;
		Coffee.bean += bean;
		Coffee.milk += milk;
		Coffee.beanTotalPrice += Coffee.beanUnitPrice * bean;
		Coffee.milkTotalPrice += Coffee.milkUnitPrice * milk;
		
		return l1;
	}
	
	public Latte[] makeLattes(int bean, int milk, int count) {
		
		Latte[] ln = new Latte[count];
		for(int i=0; i<count; i++) {
			ln[i] = new Latte();
			ln[i].setBean(bean);
			ln[i].setMilk(milk);
		}
		
		Coffee.latte += count;
		Coffee.milk += milk;
		Coffee.bean += bean * count;
		Coffee.beanTotalPrice += Coffee.beanUnitPrice * bean* count;
		Coffee.milkTotalPrice += Coffee.milkUnitPrice * count * milk;
		return ln;
	}
	
	public Americano makeAmericano(int bean, int water, int ice) {
		
		Americano a1 = new Americano();
		a1.setBean(bean);
		a1.setWater(water);
		a1.setIce(ice);
		
		Coffee.americano ++;
		Coffee.bean += bean;
		Coffee.water += water;
		Coffee.ice += ice;
		Coffee.beanTotalPrice += Coffee.beanUnitPrice * bean;
		Coffee.waterTotalPrice += Coffee.waterUnitPrice * water;
		Coffee.iceTotalPrice += Coffee.iceUnitPrice * ice;
		
		return a1;
	}
	
	public Americano[] MakeAmericanos(int bean, int water, int ice, int count) {
		
		Americano an[] = new Americano[count];
		for(int i=0; i<count; i++) {
			an[i] = new Americano();
			an[i].setBean(bean);
			an[i].setWater(water);
			an[i].setIce(ice);
		}
		
		Coffee.americano += count;
		Coffee.bean += bean * count;
		Coffee.water += water * count;
		Coffee.ice += ice * count;
		Coffee.beanTotalPrice += Coffee.beanUnitPrice * bean * count;
		Coffee.waterTotalPrice += Coffee.waterUnitPrice * water * count;
		Coffee.iceTotalPrice += Coffee.iceUnitPrice * ice * count;
		
		return an;
	}
	
	public void result() {
		System.out.println("==============================");
		System.out.println("판매 결과");
		System.out.println("==============================\n\n");
		System.out.println("------------------");
		System.out.println("음료 판매량");
		System.out.println("------------------");
		System.out.printf("에스프레소: %d잔\n", Coffee.espresso);
		System.out.printf("아메리카노: %d잔\n", Coffee.americano);
		System.out.printf("라테: %d잔\n", Coffee.latte);
		System.out.println("------------------");
		System.out.println("원자재 소비량");
		System.out.println("------------------");
		System.out.printf("원두: %dg\n", Coffee.bean);
		System.out.printf("물: %,dml\n", Coffee.water);
		System.out.printf("얼음: %d개\n", Coffee.ice);
		System.out.printf("우유: %,dml\n", Coffee.milk);
		System.out.println("------------------");
		System.out.println("매출액");
		System.out.println("------------------");
		System.out.printf("원두: %,d원\n", Coffee.beanTotalPrice); 
		System.out.printf("물: %,.0f원\n", Coffee.waterTotalPrice);
		System.out.printf("얼음: %,d원\n", Coffee.iceTotalPrice);
		System.out.printf("우유: %,d원", Coffee.milkTotalPrice); 
		
		
		
	}

}
