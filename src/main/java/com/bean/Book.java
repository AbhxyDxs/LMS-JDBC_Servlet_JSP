package com.bean;

public class Book {
    private String bookId;
    private String bookName;
    private String bookCategory;
    private double bookPrice;

    // Constructor
    public Book(String bookId, String bookName, String bookCategory, double bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookCategory = bookCategory;
        this.bookPrice = bookPrice;
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

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	//for pulling values outside, in a required format
    public String toString() {
        return "Book ID: " + bookId + ", Name: " + bookName + ", Category: " + bookCategory + ", Price: " + bookPrice;
    }
}