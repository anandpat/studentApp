package com.anand.studentApp.models;

public class Book {

	private String bookId;
	private String bookName;
	private char isAvailable;
	private BookIssue issue;
	
	public BookIssue getIssue() {
		return issue;
	}
	public void setIssue(BookIssue issue) {
		this.issue = issue;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public char getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(char isAvailable) {
		this.isAvailable = isAvailable;
	}
}
