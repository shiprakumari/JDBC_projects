package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main1 {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		FeeDetails details =em.find(FeeDetails.class, 1);
		System.out.println(details.getTotalFee()+"\t"+details.getNoOfInstallment());
		Course course = em.find(Course.class, 1);
		System.out.println(course.getName()+"\t"+course.getFeeDetails().getTotalFee()+"\t"+course.getFeeDetails().getNoOfInstallment());
		em.close();
		factory.close();
	}

}
