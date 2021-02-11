package com.abc.pojo;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HOCKEY")
public class Hockey {

	@Id
	@Column(name = "ENO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eno;

	@Column(name = "ENAME")
	private String ename;

	@Column(name = "EAGE")
	private int eage;

	@Column(name = "EADDRESS")
	private String eaddress;

	@Column(name = "EMAIL")
	private String email;

	public Hockey() {
		System.out.println("Employee Object created by HBN software!!!");
	}

	public Hockey(String ename, int eage, String eaddress, String email) {
		this.ename = ename;
		this.eage = eage;
		this.eaddress = eaddress;
		this.email = email;
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

}
