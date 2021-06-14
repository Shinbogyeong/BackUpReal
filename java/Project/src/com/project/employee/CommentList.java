package com.project.employee;

import java.util.ArrayList;

/**
 * 댓글 데이터에 대한 Getter, Setter를 저장하는 클래스입니다.
 * @author 3조
 *
 */
public class CommentList {
   
   private String seq;
   private ArrayList<String> comment = new ArrayList<String>();
   
   /**
    * 익명게시판의 댓글 번호를 얻기 위해 Getter를 설정해 놓은 메서드입니다.
    * @return
    */
   public String getSeq() {
      return seq;
   }
   
   /**
    * 익명게시판의 댓글 번호를 저장하기 위해 Setter를 설정해 놓은 메서드입니다.
    * @param seq
    */
   public void setSeq(String seq) {
      this.seq = seq;
   }
   
   /**
    * 익명게시판의 댓글 내용을 얻기 위해 Getter를 설정해 놓은 메서드입니다.
    * @return
    */
   public ArrayList<String> getComment() {
      return comment;
   }
   
   /**
    * 익명게시판의 댓글 내용을 저장하기 위해 Setter를 설정해 놓은 메서드입니다.
    * @param comment
    */
   public void setComment(ArrayList<String> comment) {
      this.comment = comment;
   }
   
   /**
    * 익명게시판의 댓글을 추가할 수 있는 메소드입니다.
    * @param comment
    */
   public void addComment(String comment) {
      this.comment.add(comment);
   }
   
   /**
    * 익명게시판의 댓글의 번호, 내용을 호출할 수 있는 메서드입니다.
    */
   @Override
   public String toString() {
      return "CommentList [seq=" + seq + ", comment=" + comment + "]";
   }
   
   /**
    * 익명게시판의 댓글의 번호, 내용을 호출할 수 있는 메서드입니다.
    * @return
    */
   public String getCommentList() {
      
      String line = "";
      
      for (int i=0; i<comment.size(); i++) {
         
         line += comment.get(i) + "■";
         
      }
      
      return line;
      
   }
   
   
   
}