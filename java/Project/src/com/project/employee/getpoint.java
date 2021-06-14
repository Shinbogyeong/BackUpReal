package com.project.employee;


/**
 * 물품을 구매하기 위한 Setter,Getter
 * 상품의 번호, 이름, 상품, 가격을 담는 클래스이다.
 * @author 3조
 */

public class getpoint {      //물품을 구매하기 위한 get/set

   private String seq;         //물품 번호
   private String name;      //물품 이름
   private String product;      //물품 종류
   private String cost;      //물품 가격
   
   public String getSeq() {
      return seq;
   }
   public void setSeq(String seq) {
      this.seq = seq;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getProduct() {
      return product;
   }
   public void setProduct(String product) {
      this.product = product;
   }
   public String getCost() {
      return cost;
   }
   public void setCost(String cost) {
      this.cost = cost;
   }
   @Override
   public String toString() {
      
      return " [seq=" + seq + ", name=" + name + ", product=" + product + ""
            + ", cost=" +cost + "]";
   }//toString
   
   
}//fin(getpoint)