package com.capgemini.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static Connection createConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String dbURL = "jdbc:mysql://localhost:3306/demodb";
		String userName = "root";
		String password = "pass";
		Connection connection = DriverManager.getConnection(dbURL, userName,
				password);
		System.out.println("connected successfully");
		return connection;

	}

	public static void insertRecord() throws ClassNotFoundException,
			SQLException {
		Connection connection = createConnection();
		String SQl = "insert into Customer values (5,'Tourism Services','Mumbai',9000.00)";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(SQl);
		System.out.println(r + "rows inserted");
		statement.close();
		connection.close();
	}

	public static void updateRecord() throws ClassNotFoundException,
			SQLException {
		Connection connection = createConnection();
		String SQl = "update Customer set c_amt =c_amt + 1000 where c_id=1";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(SQl);
		System.out.println(r + "c_amt updated");
		statement.close();
		connection.close();
	}

	public static void deleteRecord() throws ClassNotFoundException,
			SQLException {
		Connection connection = createConnection();
		String SQl = "delete from Customer where c_id=5";
		Statement statement = connection.createStatement();
		int r = statement.executeUpdate(SQl);
		System.out.println(r + "row deleted");
		statement.close();
		connection.close();
	}
	public static void displayAllRecords() throws ClassNotFoundException,
	SQLException{
		Connection connection = createConnection();
		String SQl = "select * from Customer";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(SQl);
		while(rs.next()){
		System.out.print(rs.getInt(1)+"\t");
		System.out.print(rs.getString(2)+"\t");
		System.out.print(rs.getString(3)+"\t");
		System.out.println(rs.getDouble(4));
	}
		rs.close();
		statement.close();
		connection.close();
		
	}

	public static void displayOneRecord(int id) throws ClassNotFoundException,
	SQLException{
		Connection connection = createConnection();
		
		String SQl = "select * from Customer where c_id= " +id;
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(SQl);
		if(rs.next()){
			System.out.print(rs.getInt(1)+"\t");
			System.out.print(rs.getString(2)+"\t");
			System.out.print(rs.getString(3)+"\t");
			System.out.println(rs.getDouble(4));
		}
		rs.close();
		statement.close();
		connection.close();
		
	}
	

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		// insertRecord();
		// updateRecord();
		//deleteRecord();
		//displayAllRecords();
		displayOneRecord(1);

	}

}
