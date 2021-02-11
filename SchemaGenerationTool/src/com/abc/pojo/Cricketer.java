package com.abc.pojo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "CRICKETER")
public class Cricketer {
	
	@Id
	@Column(name = "ENO" , nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eno;

	@Column(name = "ENAME")
	private String ename;

	@Column(name = "EAGE")
	private int eage;

	@Column(name = "EADDRESS")
	private String eaddress;
	
	@Column(name="EMAIL")
	private String email;


	public Cricketer() {
		System.out.println("Cricketer Object created by HBN software!!!");
	}

	public Cricketer(String ename, int eage, String eaddress, String email) {
		//this.eno= eno;
		super();
		this.ename = ename;
		this.eage = eage;
		this.eaddress = eaddress;
		this.email=email;
	
	}
	
	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEage() {
		return eage;
	}

	public void setEage(int eage) {
		this.eage = eage;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	
	@Override
	public String toString() {
		return "Cricketer[eno="+eno+", ename="+ename+", eage=" +eage+"]";
		
	}

}

