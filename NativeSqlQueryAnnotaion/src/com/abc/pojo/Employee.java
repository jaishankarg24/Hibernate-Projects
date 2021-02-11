package com.abc.pojo;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")

@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "getAllEmployees", query = "select * from `EMPLOYEE`", resultClass = Employee.class),

		@NamedNativeQuery(name = "deleteEmployee", query = "delete from `EMPLOYEE` where `ENO`=:eno") }) 
//@NamedNativeQuery(name = "getAllEmployees", query = "select * from `EMPLOYEE`", resultClass = Employee.class)
public class Employee {

	@Id
	@Column(name = "ENO")
	private int eno;

	@Column
	private String ename;

	@Column(name = "EAGE")
	private int eage;

	@Column(name = "EADDRESS")
	private String eaddress;

	@Column(name = "ESALARY")
	private String esalary;

	public int getEno() {
		return eno;
	}

	public String getEsalary() {
		return esalary;
	}

	public void setEsalary(String esalary) {
		this.esalary = esalary;
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
		return "[eno=" + eno + ", ename=" + ename + ", eage=" + eage + ", eaddress=" + eaddress + ", esalary=" + esalary
				+ "]";
	}

}
