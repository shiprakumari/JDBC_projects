package com.capgemini.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.business.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionManager.createConnection();
		String sql ="insert into customer values(?,?,?,?)";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setInt(1, customer.getId());
		statement.setString(2, customer.getName());
		statement.setString(3, customer.getCity());
		statement.setDouble(4, customer.getOutStandingAmount());
		int r= statement.executeUpdate();
		if(r>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean removeCustomer(int customerId) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionManager.createConnection();
		String sql= "delete from Customer where c_id= ?";
		PreparedStatement statement= connection.prepareStatement(sql);
		statement.setInt(1,customerId);
		int r= statement.executeUpdate();
		if(r>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionManager.createConnection();
		String sql ="update  customer set c_name=?,c_city=?,c_amt=? where c_id=?";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1, customer.getName());
		statement.setString(2, customer.getCity());
		statement.setDouble(3, customer.getOutStandingAmount());
		statement.setInt(4, customer.getId());
		int r= statement.executeUpdate();
		if(r>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean findCustomer(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionManager.createConnection();
		String sql="select * from Customer";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		List<Customer> customers = new ArrayList<>();
		while(resultSet.next()){
		int id= resultSet.getInt(1);
		String name= resultSet.getString(2);
		String city= resultSet.getString(3);
		double amount =resultSet.getDouble(4);
		Customer customer=new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setCity(city);
		customer.setOutStandingAmount(amount);
		customers.add(customer);
	}
		resultSet.close();
		statement.close();
		ConnectionManager.closeConnection(connection);
		return customers;
		
	}

}
