package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.business.Employee;
//create and insert the value in table
public class Main {

	public static void main(String[] args) {
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	Employee employee = new Employee();
	employee.setEmpId(101);
	employee.setEmpName("Radha");
	employee.setBasicSalary(10000.00);
	employee.setEmpGender('F');
	employee.setEmpGrade('A');
	
	EntityTransaction t = em.getTransaction();
	t.begin();
	
	em.persist(employee);
	t.commit();
	
	em.close();
	emf.close();
	System.out.println("object is stored in db");
	
	}

}
