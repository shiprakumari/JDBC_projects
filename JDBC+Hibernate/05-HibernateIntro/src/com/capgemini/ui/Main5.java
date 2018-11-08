package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.business.Contact;

public class Main5 {

	public static void main(String[] args) {
	Contact contact1 = new Contact(106,"shipra","9939033389");
	Contact contact2 = new Contact(107,"soumya","8484957689");
	Contact contact3 = new Contact(108,"varun","7890235674");
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	//EntityTransaction t = em.getTransaction();
	em.getTransaction().begin();
	/*em.persist(contact1);
	em.persist(contact2);
	em.persist(contact3);
	em.getTransaction().commit();*/
	contact3.setPhoneNumber("5687545646");
	em.merge(contact3);
	
	em.close();
	emf.close();
	
	
	Contact contact4= null;
	emf=Persistence.createEntityManagerFactory("JPA-PU");
	em=emf.createEntityManager();
	contact4=em.find(Contact.class, 108);
	contact4.setPhoneNumber("7564756346");
	em.merge(contact4);
	System.out.println(contact4.equals(contact3));
	
}
}
