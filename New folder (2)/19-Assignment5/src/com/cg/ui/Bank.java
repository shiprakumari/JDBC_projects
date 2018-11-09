package com.cg.ui;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="bank")
public class Bank {
	@Id
	private int bankId;
	private String bankName;
	private String bankOfficeLocation;
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="bankList")
	private List<Customer> customerList = new ArrayList<Customer>();
	
	public void addCustomer(Customer  cust){
		this.customerList.add(cust);
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankOfficeLocation() {
		return bankOfficeLocation;
	}

	public void setBankOfficeLocation(String bankOfficeLocation) {
		this.bankOfficeLocation = bankOfficeLocation;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	
}
