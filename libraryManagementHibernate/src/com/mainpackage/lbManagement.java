package com.mainpackage;

import javax.persistence.*;

@Entity
@Table(name="library")
public class lbManagement {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="bookname")
	private String bookname;
	
	@Column(name="bookamount")
	private int bookamount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getBookamount() {
		return bookamount;
	}

	public void setBookamount(int bookamount) {
		this.bookamount = bookamount;
	}
}
