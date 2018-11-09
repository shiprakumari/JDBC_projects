package com.trainee.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		Person person1= new Person("Shyam", 20, 10000.00, 'M');
		Person person2 = new Person("Ram",22,5000.00,'M');
		Person person3 = new Person("Mohan",25,9000.00,'M');
		Person person4 = new Person("Radha",23,12000.00,'F');
		Person person5 = new Person("Usha",27,15000.00,'F');
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(person1);
		em.persist(person2);
		em.persist(person3);
		em.persist(person4);
		em.persist(person5);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
