package com.abc.model;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "ENO")
	private int eno;

	@Column(name = "ENAME")
	private String ename;

	@Column(name = "EAGE")
	private int eage;

	@Column(name = "EADDRESS")
	private String eaddress;

	@UpdateTimestamp
	@Column(name = "TIMESTAMP")
	private Date timeStamp = new Date();

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Employee() {
		System.out.println("Employee object created by HBN software!!!!");
	}

	public Employee(int eno, String ename, int eage, String eaddress) {
		this.eno = eno;
		this.ename = ename;
		this.eage = eage;
		this.eaddress = eaddress;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
		System.out.println("Setting ENO");
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
		System.out.println("Setting ENAME");
	}

	public int getEage() {
		return eage;
	}

	public void setEage(int eage) {
		this.eage = eage;
		System.out.println("SETTING EAGE");
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
		System.out.println("SETTING  EADDRESS");
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", eage=" + eage + ", eaddress=" + eaddress + "]";
	}

}
