package com.capgemini.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.business.Customer;
import com.capgemini.db.CustomerDAO;
import com.capgemini.db.CustomerDAOImpl;

public class Main {
	public static void add() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		int inp_id = 0;
		String inp_name = "";
		String inp_city = "";
		double inp_amt = 0.0;
		System.out.println("enter id");
		inp_id = scanner.nextInt();
		System.out.println("enter name");
		inp_name = scanner.next();

		System.out.println("enter city");
		inp_city = scanner.next();
		System.out.println("enter amount");
		inp_amt = scanner.nextDouble();
		Customer customer = new Customer();
		customer.setId(inp_id);
		customer.setName(inp_name);
		customer.setCity(inp_city);
		customer.setOutStandingAmount(inp_amt);
		CustomerDAO customerDAO = new CustomerDAOImpl();
		boolean result = customerDAO.addCustomer(customer);
		if (result == true) {
			System.out.println("record successfully added");
		} else {
			System.out.println("record not added");
		}
	}

	public static void update() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter id to update customer");
		int inp_id = 0;
		inp_id = scanner.nextInt();
		String inp_name = "";
		String inp_city = "";
		double inp_amt = 0.0;
		System.out.println("enter name to update");
		inp_name = scanner.next();
		System.out.println("enter city to update");
		inp_city = scanner.next();
		System.out.println("enter amount to update");
		inp_amt = scanner.nextDouble();
		Customer customer = new Customer();
		customer.setId(inp_id);
		customer.setName(inp_name);
		customer.setCity(inp_city);
		customer.setOutStandingAmount(inp_amt);
		CustomerDAO customerDAO = new CustomerDAOImpl();
		boolean result = customerDAO.updateCustomer(customer);
		if (result == true) {
			System.out.println("record successfully updated");
		} else {
			System.out.println("record not updated");
		}

	}

	public static void displayAll() throws ClassNotFoundException, SQLException {
		CustomerDAO customerDAO = new CustomerDAOImpl();
		List<Customer> CustomerList = customerDAO.getAllCustomers();
		// System.out.println(CustomerList);
		for (Customer customer : CustomerList) {
			System.out.print(customer.getId());
			System.out.print(customer.getName());
			System.out.print(customer.getCity());
			System.out.println(customer.getOutStandingAmount());

		}
	}

	public static void remove() throws ClassNotFoundException, SQLException {
		int inp_id = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id to remove:");
		inp_id = scanner.nextInt();

		CustomerDAO customerDAO = new CustomerDAOImpl();
		boolean result = customerDAO.removeCustomer(inp_id);
		if (result == true) {
			System.out.println("record successfully deleted");
		} else {
			System.out.println("record not deleted");
		}

	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		System.out.println("----Customer Application----");
		System.out.println("_____________________________");
		System.out.println("1. Add New Customer");
		System.out.println("2. Update Customer");
		System.out.println("3. Display All Customer");
		System.out.println("4. Delete Customer");
		System.out.println("5. Exit");
		Scanner scanner = new Scanner(System.in);
		int choice;
		System.out.println("Enter your choice");
		choice = scanner.nextInt();
		switch (choice) {
		case 1:
			add();
			break;
		case 2:
			update();
			break;
		case 3:
			displayAll();
			break;
		case 4:
			remove();
			break;
		case 5:
			System.out.println("Thank You");
			break;

		}
	}

}
