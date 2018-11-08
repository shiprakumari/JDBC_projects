package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.business.Employee;
//finding details with id
public class Main1 {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		Employee employee = null;
		employee =em.find(Employee.class,101);
		System.out.println(employee);
		em.close();
		emf.close();
	}

}
