package com.trainee.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		//em.getTransaction().begin();
		Loan loan = em.find(Loan.class, 10);
		System.out.println(loan);
		em.close();
		factory.close();

	}

}
