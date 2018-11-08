package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.business.Employee;

public class Main4 {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		Employee employee =null;
		employee =em.find(Employee.class, 102);
		em.getTransaction().begin();
		em.remove(employee);
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
