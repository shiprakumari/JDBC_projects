package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.business.Employee;
//updation of record 
public class Main3 {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		Employee employee =null;
		employee = em.find(Employee.class, 101);
		employee.setBasicSalary(20000);
		em.getTransaction().begin();
		em.merge(employee);
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
