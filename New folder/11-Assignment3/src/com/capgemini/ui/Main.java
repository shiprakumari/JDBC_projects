package com.capgemini.ui;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Course course= new Course();
		course.setName("MBBS");
		
		FeeDetails details= new FeeDetails();
		details.setTotalFee(50000.00);
		details.setNoOfInstallment(8);
		course.setFeeDetails(details);
		em.persist(course);
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}

}
