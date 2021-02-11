package com.abc.pojo;

import javax.persistence.Cacheable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "CUSTOMER")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Customer {

	@Id
	@Column(name = "CID")
	private int eno;

	@Column(name = "CNAME")
	private String ename;

	@Column(name = "CAGE")
	private int eage;

	@Column(name = "CADDRESS")
	private String eaddress;

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

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	@Override
	public String toString() {
		return "Customer [eno=" + eno + ", ename=" + ename + ", eage=" + eage + ", eaddress=" + eaddress + "]";
	}

}
