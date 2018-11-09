package com.trainee.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Loan loan = new Loan();
		//loan.setLoanId(10);
		loan.setCustomerName("Harry");
		loan.setLoanAmount(200000);
		//loan.setRepaymentList(repaymentList);
		
		Repayment repayment = new Repayment();
		//repayment.setRepaymentId(101);
		repayment.setRepayAmount(5000);
		repayment.setInstallmentNo(5);
		
		
		Repayment repayment2 = new Repayment();
		//repayment2.setRepaymentId(102);
		repayment2.setRepayAmount(20000);
		repayment2.setInstallmentNo(20);
		
		loan.addRepayment(repayment);
		loan.addRepayment(repayment2);
		
		em.persist(repayment);
		em.persist(repayment2);
		
		em.persist(loan);
		em.getTransaction().commit();
		em.close();
		factory.close();
		

	}

}
