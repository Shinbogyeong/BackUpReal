package com.project.employee;


/**
 * 구매한 상품 목록들을 담기 위한 Setter,Getter
 * 상품 번호, 이름, 가격, 사원번호, 날짜를 담는 클래스이다.
 * @author 3조
 *
 */

public class buylist {   //구매한 상품 목록을 띄우기 위한 get/set
   
   private String buylist_prodNo;      //상품 번호
   private String buylist_prodname;   //상품 이름
   private String buylist_prodprice;   //상품 가격
   private String buylist_empNo;      //사원 번호
   private String buylist_date;      //구매 날짜
   
   public String getBuylist_prodNo() {
      return buylist_prodNo;
   }
   public void setBuylist_prodNo(String buylist_prodNo) {
      this.buylist_prodNo = buylist_prodNo;
   }
   public String getBuylist_prodname() {
      return buylist_prodname;
   }
   public void setBuylist_prodname(String buylist_prodname) {
      this.buylist_prodname = buylist_prodname;
   }
   public String getBuylist_prodprice() {
      return buylist_prodprice;
   }
   public void setBuylist_prodprice(String buylist_prodprice) {
      this.buylist_prodprice = buylist_prodprice;
   }
   public String getBuylist_empNo() {
      return buylist_empNo;
   }
   public void setBuylist_empNo(String buylist_empNo) {
      this.buylist_empNo = buylist_empNo;
   }
   public String getBuylist_date() {
      return buylist_date;
   }
   public void setBuylist_date(String buylist_date) {
      this.buylist_date = buylist_date;
   }
   
   

}