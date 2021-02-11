package com.abc.pojo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
//@NamedQuery(name="getEmployee", query="from Employee")
//@NamedQuery(name="getEmployee", query="from Employee where eno=10")
@NamedQueries(value = { @NamedQuery(name = "getEmployees", query = "from Employee"), @NamedQuery(name = "deleteEmployee", query = "delete from Employee where eno=10") })
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
		return "Employee [eno=" + eno + ", ename=" + ename + ", eage=" + eage + ", eaddress=" + eaddress + "]";
	}

}
