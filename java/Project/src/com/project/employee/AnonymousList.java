package com.project.employee;

/**
 * 익명게시판에 대한 데이터를 담기 위해 Setter, Getter를 만들어 놓은 클래스입니다.
 * @author 3조
 *
 */
public class AnonymousList {
   
   private String seq;
   private String title;
   private String regdate;
   private String content;
   
   /**
    * 익명게시판의 게시글 번호를 얻기 위해 Getter를 설정해 놓은 메서드입니다.
    * @return
    */
   public String getSeq() {
      return seq;
   }
   
   /**
    * 익명게시판의 게시글 번호를 저장하기 위해 Setter를 설정해 놓은 메서드입니다.
    * @param seq
    */
   public void setSeq(String seq) {
      this.seq = seq;
   }
   
   /**
    * 익명게시판의 게시글 제목을 얻기 위해 Getter를 설정해 놓은 메서드입니다.
    * @return
    */
   public   String getTitle() {
      return title;
   }
   
   /**
    * 익명게시판의 게시글 제목을 저장하기 위해 Setter를 설정해 놓은 메서드입니다.
    * @param title
    */
   public void setTitle(String title) {
      this.title = title;
   }
   
   /**
    * 익명게시판의 게시글 등록날짜를 얻기 위해 Getter를 설정해 놓은 메서드입니다.
    * @return
    */
   public String getRegdate() {
      return regdate;
   }
   
   /**
    * 익명게시판의 게시글 등록날짜를 저장하기 위해 Setter를 설정해 놓은 메서드입니다.
    * @param regdate
    */
   public void setRegdate(String regdate) {
      this.regdate = regdate;
   }
   
   /**
    * 익명게시판의 게시글 내용을 얻기 위해 Getter를 설정해 놓은 메서드입니다.
    * @return
    */
   public String getContent() {
      return content;
   }
   
   /**
    * 익명게시판의 게시글 내용을 저장하기 위해 Setter를 설정해 놓은 메서드입니다.
    * @param content
    */
   public void setContent(String content) {
      this.content = content;
   }
   
   /**
    * 익명게시판 번호, 제목, 날짜 등록일에 대한 결과를 불러올 수 있는 메서드
    */
   @Override
   public String toString() {
      return "AnonymousList [seq=" + seq + ", title=" + title + ", regdate=" + regdate + ", content=" + content + "]";
   }
   

}