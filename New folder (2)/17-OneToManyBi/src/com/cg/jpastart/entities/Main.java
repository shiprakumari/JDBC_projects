package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		Employee employee =em.find(Employee.class, 1001);
		System.out.println(employee.getName()+","+employee.getSalary()+","+employee.getDepartment().getName());
		em.close();
		factory.close();

	}

}
