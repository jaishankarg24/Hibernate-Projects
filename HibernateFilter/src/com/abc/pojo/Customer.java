package com.abc.pojo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name = "Customer")
@FilterDef(name="CUSTOMER_DETAILS", parameters= {@ParamDef(name="type", type="String"), @ParamDef(name="customerage", type="int")})
@Filter(name="CUSTOMER_DETAILS", condition=":type=customertype and :customerage<age")
public class Customer {

	@Id
	@Column(name = "cid")
	private int cid;

	@Column(name = "cname")
	private String cname;

	@Column(name = "cage")
	private int cage;

	@Column(name = "caddress")
	private String caddress;

	@Column(name = "customertype")
	private String customertype;
	

	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public int getCage() {
		return cage;
	}


	public void setCage(int cage) {
		this.cage = cage;
	}


	public String getCaddress() {
		return caddress;
	}


	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}


	public String getCustomertype() {
		return customertype;
	}


	public void setCustomertype(String customertype) {
		this.customertype = customertype;
	}


	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cage=" + cage + ", caddress=" + caddress + ", customertype=" + customertype  +"]";
	}

}
