package com.trainee.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main1 {

	public static void main(String[] args) {
		//String JPQL ="from Person";
		//String JPQL ="select p from Person p";
		//String JPQL = "select p from Person p where p.personId=7";
		String JPQL= "select p.salary from Person p where p.salary between :startRange and :endRange";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		//em.getTransaction().begin();
		
		Query query =em.createQuery(JPQL);
		query.setParameter("startRange",5000.00) ;
		query.setParameter("endRange", 7000.00);
		
		/*
		//Query query = em.createQuery(JPQL);
		List<Person> persons = query.getResultList();
		for(Person person: persons){
			System.out.print(person.getName());
			System.out.print(person.getPersonId());
			System.out.print(person.getSalary());
			System.out.print(person.getGender());
			System.out.println(person.getAge());
			
		}*/
		
		em.close();
		factory.close();
	}

}
