package com.cg.jpastart.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NameMain {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		
		String myQuery="from Student";
		Query query = em.createQuery(myQuery);
		List<Student> studentList = null;
		studentList= query.getResultList();
		for(Student student: studentList)
		{
			String n = student.getName();
			n=n.toUpperCase();
			student.setName(n);
			em.getTransaction().begin();
			em.merge(student);
			em.getTransaction().commit();
		}
		
		em.close();
		
		factory.close();
		
	}

}
