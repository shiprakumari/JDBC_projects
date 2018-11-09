package com.cg.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="custom")
public class Customer {
	@Id
	int customerId;
	String customerName;
	Date dob;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="customer_bank",joinColumns={@JoinColumn(name="customer_Id")},inverseJoinColumns={@JoinColumn(name="bank_id")})
	List<Bank> bankList = new ArrayList<Bank>();
	
	public void addBank(Bank bk){
		this.bankList.add(bk);
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Bank> getBankList() {
		return bankList;
	}

	public void setBankList(List<Bank> bankList) {
		this.bankList = bankList;
	}
	
	

}
