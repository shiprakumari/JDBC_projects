package com.capgemini.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

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
		String sql = "insert into Customer values (?,?,?,?)";
		int imp_id=0;
		String imp_name=" ";
		String imp_city=" ";
		double imp_amt=0.0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		imp_id =scanner.nextInt();
		System.out.println("Enter Name");
		imp_name= scanner.next();
		
		System.out.println("Enter City");
		imp_city= scanner.next();
		
		System.out.println("Enter Amount: ");
		imp_amt=scanner.nextDouble();
		PreparedStatement statement = connection.prepareStatement(sql);
		//PreparedStatement statement = connection.prepareStatement(SQl);
		statement.setInt(1, imp_id);
		statement.setString(2, imp_name);
		statement.setString(3, imp_city);
		statement.setDouble(4,imp_amt);
		int r = statement.executeUpdate();
		System.out.println(r + "rows inserted");
		statement.close();
		connection.close();
	}
	

	public static void deleteRecord() throws ClassNotFoundException,
			SQLException {
		
		Connection connection = createConnection();

		Scanner scanner = new Scanner(System.in);
		int imp_id=0;
		System.out.println("Enter id: ");
		imp_id =scanner.nextInt();
		String sql = "delete from Customer where c_id=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, imp_id);	
		int r = statement.executeUpdate();
		System.out.println(r + "rows deleted");
		statement.close();
		connection.close();
	}

	public static void updateRecord() throws ClassNotFoundException,
			SQLException {
		
		Connection connection = createConnection();

		Scanner scanner = new Scanner(System.in);
		
		int imp_id=0;
		double imp_amt=0.0;
		String sql = "update Customer set c_amt =c_amt + ? where c_id=?";
		System.out.println("updation operation:");
		System.out.println("Enter id: ");
		imp_id =scanner.nextInt();
		System.out.println("enter amount");
		imp_amt=scanner.nextDouble();
		//String sql = "update Customer set c_amt =c_amt + 1000 where c_id=?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setDouble(1, imp_amt);
		statement.setInt(2, imp_id);	
		int r = statement.executeUpdate();
		System.out.println(r + "rows updated");
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

	public static void displayOneRecord() throws ClassNotFoundException,
	SQLException{
		Scanner scanner=new Scanner(System.in);
		Connection connection = createConnection();
		int imp_id=0;
		System.out.println("enter id");
		imp_id= scanner.nextInt();
		
		
		String SQl = "select * from Customer where c_id=?";
		//Statement statement = connection.createStatement();
		
		PreparedStatement statement = connection.prepareStatement(SQl);
		//ResultSet rs = statement.executeQuery();
		statement.setInt(1, imp_id);
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
		//insertRecord();
		 updateRecord();
		//deletRecord();
		//displayAllRecords();
		//displayOneRecord();
		//insertRecord();
		//deleteRecord();

	}

}
