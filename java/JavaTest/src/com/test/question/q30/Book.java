package com.test.question.q30;

public class Book {
	
	private String title;
	private int price;
	private String author;
	private String publisher;
	private String pubYear = "2020";
	private String isbn;
	private int page;
	
	
	
	//getter, setter
	
	//제목
	public void setTitle(String title) throws Exception {
		
		for(int i=0; i<title.length(); i++) {
			
			int word = title.charAt(i);
			if(
					   (word >= (int)'a' && word <= (int)'z')
					|| (word >= (int)'A' && word <= (int)'Z')
					|| (word >= (int)'가' && word <= (int)'힣')//'가'44032, '힣55203
					|| (word >= (int)'0' && word <= (int)'9')
					|| (word == ' ')
					&& title.length() >0 && title.length() <50
					
					) {
				this.title = title;
			} else {
				throw new Exception("잘못된 제목입니다.");
			}
			
		}
		
	}
	
	public String getTitle() {
		return this.title;
	}
	
	//가격
	public void setPrice(int price) throws Exception {
		
		if(price > 0 && price < 1000000) {
			this.price = price;
		}else {
			throw new Exception("잘못된 가격입니다.");
		}
	}
	
	public int getPrice() {
		return this.price;
	}
	
	//저자
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	//ISBN
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getIsbn() {
		return this.isbn;
	}
	
	//PAGE
	public void setPage(int page) throws Exception {
		if(page >= 0) {
			this.page = page;
		} else {
			throw new Exception("잘못된 페이지입니다.");
		}
	}
	
	public int getPage() {
		return this.page;
	}
	
	
	//쓰기 전용
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	//읽기 전용
	public String getPubYear() {
		return this.pubYear;
	}
	
	public String info() {
		String txt = "";
		txt= "제목: " + getTitle() +
			"\n저자: " + getAuthor() +
			"\n가격: " + getPrice() +
			"\n페이지수: " + getPage() +
			"\n발행년도: " + getPubYear() +
			"\nISBN: " + getIsbn()
			;
		return txt;
	}
	

}






