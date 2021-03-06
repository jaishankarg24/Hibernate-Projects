package com.abc.pojo;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "ENO")
	//@GenericGenerator(name = "incrementGen", strategy = "increment")
	//@GeneratedValue(generator ="incrementGen")
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	//@TableGenerator(name="tableGen", table="my_table", pkColumnName="id", pkColumnValue="10", valueColumnName="next_high")
	//@GeneratedValue(strategy=GenerationType.TABLE, generator="tableGen")

	@GenericGenerator(name = "nativeGen", strategy = "native")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "nativeGen")
	
	private int eno;

	@Column
	private String ename;

	@Column(name = "EAGE")
	private int eage;

	@Column(name = "EADDRESS")
	private String eaddress;

	@Column(name = "ESALARY")
	private String esalary;

	public String getEsalary() {
		return esalary;
	}

	public void setEsalary(String esalary) {
		this.esalary = esalary;
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

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public Employee(int eno, String ename, int eage, String eaddress, String esalary) {
		this.eno=eno;
		this.ename = ename;
		this.eage = eage;
		this.eaddress = eaddress;
		this.esalary = esalary;
	}

}
