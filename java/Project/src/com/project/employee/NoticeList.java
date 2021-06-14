package com.project.employee;

/**
 * 공지사항에 대한 데이터를 담기 위해 Setter, Getter를 만들어 놓은 클래스입니다.
 * @author 3조
 *
 */
public class NoticeList {
   
   private String seq;
   private String title;
   private String regDate;
   private String content;
   
   /**
    * 공지사항의 번호를 얻기 위해 Getter를 설정해 놓은 메서드입니다.
    * @return
    */
   public String getSeq() {
      return seq;
   }
   
   /**
    * 공지사항의 번호를 저장하기 위해 Setter를 설정해 놓은 메서드입니다.
    * @param seq
    */
   public void setSeq(String seq) {
      this.seq = seq;
   }
   
   /**
    * 공지사항의 제목을 얻기 위해 Getter를 성정해 놓은 메서드입니다.
    * @return
    */
   public String getTitle() {
      return title;
   }
   
   /**
    * 공지사항의 제목을 저장하기 위해 Setter를 설정해 놓은 메서드입니다.
    * @param title
    */
   public void setTitle(String title) {
      this.title = title;
   }
   
   /**
    * 공지사항의 등록일을 얻기 위해 Getter를 설정해 놓은 메서드입니다.
    * @return
    */
   public String getRegDate() {
      return regDate;
   }
   
   /**
    * 공지사항의 등록일을 저장하기 위해 Setter를 설정해 놓은 메서드입니다.
    * @param regDate
    */
   public void setRegDate(String regDate) {
      this.regDate = regDate;
   }
   
   /**
    * 공지사항의 내용을 얻기 위해 Getter를 설정해 놓은 메서드입니다.
    * @return
    */
   public String getContent() {
      return content;
   }
   
   /**
    * 공지사항의 내용을 저장하기 위해 Setter를 설정해 놓은 메서드입니다.
    * @param content
    */
   public void setContent(String content) {
      this.content = content;
   }

}