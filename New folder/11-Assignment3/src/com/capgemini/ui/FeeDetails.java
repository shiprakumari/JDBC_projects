package com.capgemini.ui;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FeeDetails {
	@Id
	@Column(name="Fee_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int feeId;
	@Column(name="Total_Fee")
	private double totalFee;
	@Column(name="Installments")
	private int noOfInstallment;
	
	@OneToOne(mappedBy= "feeDetails")
	private Course course;
	
	public int getFeeId() {
		return feeId;
	}
	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	public int getNoOfInstallment() {
		return noOfInstallment;
	}
	public void setNoOfInstallment(int noOfInstallment) {
		this.noOfInstallment = noOfInstallment;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	

}
