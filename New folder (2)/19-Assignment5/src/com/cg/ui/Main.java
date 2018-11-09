package com.cg.ui;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Bank bank =new Bank();
		bank.setBankId(10);
		bank.setBankName("SBI");
		bank.setBankOfficeLocation("chennai");
		
		Bank bank1 =new Bank();
		bank1.setBankId(20);
		bank1.setBankName("PNB");
		bank1.setBankOfficeLocation("Delhi");
		
		
		Bank bank2 =new Bank();
		bank2.setBankId(30);
		bank2.setBankName("ICICI");
		bank2.setBankOfficeLocation("Pune");
		
		Bank bank3 =new Bank();
		bank3.setBankId(40);
		bank3.setBankName("HDFC");
		bank3.setBankOfficeLocation("Noida");
		
		Customer customer =new Customer();
		customer.setCustomerId(101);
		customer.setCustomerName("Shipra");
		customer.setDob(new Date(21-05-1999));
		
		Customer customer2 =new Customer();
		customer2.setCustomerId(103);
		customer2.setCustomerName("Soumya");
		customer2.setDob(new Date(01-06-1997));
		

		Customer customer3 =new Customer();
		customer3.setCustomerId(106);
		customer3.setCustomerName("Shreya");
		customer3.setDob(new Date(1999,5,15));
		
		customer.addBank(bank);
		customer.addBank(bank1);
		customer.addBank(bank2);
		
		bank1.addCustomer(customer);
		bank1.addCustomer(customer);
		
		customer2.addBank(bank);
		customer2.addBank(bank2);
		customer2.addBank(bank3);
		
		customer3.addBank(bank);
		customer3.addBank(bank1);
		customer3.addBank(bank2);
		customer3.addBank(bank3);
		
	em.persist(customer);
	em.persist(customer2);
	em.persist(customer3);
	em.getTransaction().commit();
	em.close();
	factory.close();
		
	
		
		

	}

}
