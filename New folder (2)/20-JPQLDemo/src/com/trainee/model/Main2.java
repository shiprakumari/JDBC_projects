package com.trainee.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main2 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		//Query query = em.createNamedQuery("maleFilterQuery");
		//Query query = em.createNamedQuery("femaleFilterQuery");
		Query query = em.createNamedQuery("FilterBySalaryRange");
		
		query.setParameter("startRange",5000.00) ;
		query.setParameter("endRange", 7000.00);
		List<Person> persons = query.getResultList();
		for(Person person: persons){
			System.out.print(person.getName());
			System.out.print(person.getPersonId());
			System.out.print(person.getSalary());
			System.out.print(person.getGender());
			System.out.println(person.getAge());
	}
		em.close();
		factory.close();

}
}
