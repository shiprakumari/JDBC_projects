package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TripMain1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		Trip trip = null;
		//em.getTransaction().begin();
		trip = em.find(Trip.class, 1);
		System.out.println(trip);
		System.out.println(trip.getInfo());
		//em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
