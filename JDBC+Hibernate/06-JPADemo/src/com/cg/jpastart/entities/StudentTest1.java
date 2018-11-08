package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentTest1 {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		Student student =null;
		student =em.find(Student.class, 1);
		System.out.println(student.getStudentId());
		System.out.println(student.getName());
		em.close();
		factory.close();
	}

}
