package com.capgemini.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.business.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public boolean addEmployee(Employee employee) {
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return true;
		}catch(Exception e){
		return false;}
	}

	@Override
	public boolean removeEmployee(int id) {
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Employee employee=em.find(Employee.class,101);
			em.remove(employee);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return true;
		}catch(Exception e){
		return false;}
		
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(employee);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return true;
		}catch(Exception e){
		return false;
		}
	}

	@Override
	public Employee findEmployee(int id) {
		Employee employee = null;
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();
			
			employee = em.find(Employee.class, id);
			em.close();
			emf.close();
			return employee;
			
			
		}catch(Exception e){
		return employee;
		}
	}
		

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> empList= null;
		try{
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();
			Query q = em.createQuery("from Employee");
			empList=q.getResultList();
			em.close();
			emf.close();
			return empList;
		}catch(Exception e){
		return empList;
		}
	}

}
