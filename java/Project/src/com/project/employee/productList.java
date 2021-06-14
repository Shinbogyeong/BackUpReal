package com.project.employee;


/**
 * 물건을 판매할때에 필요한 정보들의 get/set
 * 상품 번호, 이름, 가격을 정해준뒤에 판매할때 필요한 클래스이다.
 * @author 3조
 */


public class productList {

   private String product_no;      //상품 번호
   private String product_name;   //상품 이름
   private String product_price;   //상품 가격
   public String getProduct_no() {
      return product_no;
   }
   public void setProduct_no(String product_no) {
      this.product_no = product_no;
   }
   public String getProduct_name() {
      return product_name;
   }
   public void setProduct_name(String product_name) {
      this.product_name = product_name;
   }
   public String getProduct_price() {
      return product_price;
   }
   public void setProduct_price(String product_price) {
      this.product_price = product_price;
   }
   
}