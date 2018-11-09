package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		
		Qualification qualification =new Qualification("PGDM",8);
		Doctor doctor=new Doctor();
		doctor.setName("Ram");
		doctor.setFees(7000.00);
		doctor.setQualification(qualification);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(doctor);
		em.getTransaction().commit();
		em.close();
		factory.close();
		

	}

}
