package com.university.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.university.bean.RegistrationBean;

public class DatabaseConnection {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public DatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university?" + "user=root&password=root@123");
			System.out.println("Connected to DB");

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (InstantiationException e) {
			e.printStackTrace();

		} catch (IllegalAccessException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
	}	  

	public RegistrationBean signIn(String email, String password) {
		RegistrationBean reg = new RegistrationBean();
		String firstname = null, lastname=null;
		ResultSet rs;
		//	Registration objLoggedInUser = new Registration();
		try {
			// statements allow to issue SQL queries to the database
			//statement = connect.createStatement();
			// resultSet gets the result of the SQL query

			preparedStatement = connect.prepareStatement("SELECT * FROM user_db WHERE email=? and password=?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			rs = preparedStatement.executeQuery();
			System.out.println(rs);

			while (rs.next()) {
				firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");
			}
			reg.setFirstName(firstname);
			reg.setLastName(lastname);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reg;

	}
	
//	public RegistrationBean registerUserInDb(String fName,String lName,String emailid,String pass,String cPass) throws Exception{
//		String firstName = fName;
//		String lastName = lName;
//		String email = emailid;
//		String password = pass;
//		String conpassword = cPass;
//		int rowcount;
//		RegistrationBean rb = new RegistrationBean();
//		try{
//			preparedStatement = connect.prepareStatement("SELECT firstname FROM user_db WHERE email=?");
//
//			preparedStatement.setString(1,email);
//			System.out.println(preparedStatement.toString());
//
//			resultSet = preparedStatement.executeQuery();
//			resultSet.last();
//			rowcount = resultSet.getRow();
//			if (rowcount > 0) {
//				return false;
//			}
//			else{
//				String query = "INSERT INTO `university`.`user_db` (`email`, `password`, `firstname`, `lastname`, `conpassword`) VALUES ('" + email+ "','" + pass + "','" + fName+ "','" + lName+ "','" + cPass+ "');";			
//				rowcount = preparedStatement.executeUpdate(query);
//
//				if (rowcount > 0){
//					ResultSet rs1;
//					String query1 = "SELECT * FROM user_db WHERE email=" + email + "";
//					preparedStatement = connect.prepareStatement(query1);
//					rs1 = preparedStatement.executeQuery();
//					System.out.println(rs1);
//
//					while (rs1.next()) {
//						firstname = rs1.getString("firstname");
//						lastname = rs1.getString("lastname");
//						email = rs1.getString("email");
//					}
//					reg.setFirstName(firstname);
//					reg.setLastName(lastname);
//				}					
//				else
//					return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
}