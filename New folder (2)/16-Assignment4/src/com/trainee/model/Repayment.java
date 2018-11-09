package com.trainee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="repayment")
public class Repayment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int repaymentId;
	double repayAmount;
	int installmentNo;
	
	public int getRepaymentId() {
		return repaymentId;
	}
	public void setRepaymentId(int repaymentId) {
		this.repaymentId = repaymentId;
	}
	public double getRepayAmount() {
		return repayAmount;
	}
	public void setRepayAmount(double repayAmount) {
		this.repayAmount = repayAmount;
	}
	public int getInstallmentNo() {
		return installmentNo;
	}
	public void setInstallmentNo(int installmentNo) {
		this.installmentNo = installmentNo;
	}
	@Override
	public String toString() {
		return "Repayment [repaymentId=" + repaymentId + ", repayAmount="
				+ repayAmount + ", installmentNo=" + installmentNo + "]";
	}
	public Repayment(int repaymentId, double repayAmount, int installmentNo) {
		super();
		this.repaymentId = repaymentId;
		this.repayAmount = repayAmount;
		this.installmentNo = installmentNo;
	}
	public Repayment() {
		super();
	}
	
	
}
