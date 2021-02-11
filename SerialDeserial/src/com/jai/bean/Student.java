package com.jai.bean;

import java.io.Serializable;


public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int sid;
	private String name;
	private String saddress;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
	
}
