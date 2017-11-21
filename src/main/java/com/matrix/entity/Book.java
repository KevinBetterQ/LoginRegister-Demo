package com.matrix.entity;

import java.io.Serializable;

public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
    private int id;
    private String bookName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    @Override
    public String toString() {
    	return "id: " + getId() + ",bookName: " + getBookName();
    }

}