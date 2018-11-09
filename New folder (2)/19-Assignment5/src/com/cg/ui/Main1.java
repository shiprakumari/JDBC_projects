package com.cg.ui;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main1 {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Bank bank4 =new Bank();
		bank4.setBankId(60);
		bank4.setBankName("BOI");
		bank4.setBankOfficeLocation("chennai");
		
		Bank bank1 =new Bank();
		bank1.setBankId(70);
		bank1.setBankName("UBI");
		bank1.setBankOfficeLocation("Delhi");
		
		
		Bank bank2 =new Bank();
		bank2.setBankId(80);
		bank2.setBankName("UCO");
		bank2.setBankOfficeLocation("Pune");
		

		Customer customer4 =new Customer();
		customer4.setCustomerId(110);
		customer4.setCustomerName("Shilpa");
		customer4.setDob(new Date(1999,5,23));
		
		Customer customer5 =new Customer();
		customer5.setCustomerId(115);
		customer5.setCustomerName("Usha");
		customer5.setDob(new Date(1999,5,15));
		
		customer4.addBank(bank2);
		customer4.addBank(bank1);
		customer4.addBank(bank4);
		
		customer5.addBank(bank2);
		customer5.addBank(bank4);
		customer5.addBank(bank1);
		
		bank1.addCustomer(customer4);
		bank1.addCustomer(customer5);
		
		bank2.addCustomer(customer5);
		bank2.addCustomer(customer4);
		
		bank4.addCustomer(customer5);
		bank4.addCustomer(customer4);
		
		em.persist(customer5);
		em.persist(customer4);
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}

}
