package com.ntc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class EmployeeDataAccess {



	public void insert() {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		try {
			connect = MySQL.getConnection();
			preparedStatement = connect.prepareStatement("insert into Student values (?, ?, ?, ?, ?)");
			//從1開始
			preparedStatement.setInt(1, 6);
			preparedStatement.setString(2, "Peter");
			preparedStatement.setString(3, "1999-08-08");
			//preparedStatement.setDate(3, new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse("1999-08-08").getTime()));
            //preparedStatement.setObject(3, LocalDate.of(1999,8,8));
            preparedStatement.setDouble(4, 63.03);
            preparedStatement.setInt(5, 3);
            preparedStatement.executeUpdate();
		} catch (Exception e) {

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
	            }
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {

			}
		}
	}
	
	public void update() {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		try {
			connect = MySQL.getConnection();
			preparedStatement = connect.prepareStatement("update employee set name=? where id=?");
			//從1開始
            preparedStatement.setString(1, "董家元");
            preparedStatement.setInt(2, 4);
            preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
	            }
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {

			}
		}
	}
	
	void getEmployeeByID(int empID){
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connect = MySQL.getConnection();
			preparedStatement = connect.prepareStatement("select * from Student where id=?");
			//從1開始
            preparedStatement.setInt(1, empID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // It is possible to get the columns via name
                // also possible to get the columns via the column number
                // which starts at 1
                // e.g. resultSet.getString(3);
                int id = resultSet.getInt("id");
                int deptID = resultSet.getInt("deptID");
                String name = resultSet.getString("name");
                double score = resultSet.getDouble("score");
                Date birth = resultSet.getDate("birth");
                System.out.println("ID: " + id);
                System.out.println("DeptID: " + deptID);
                System.out.println("Name: " + name);
                System.out.println("Score: " + score);
                System.out.println("Birth: " + birth);
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
	            }
				if (preparedStatement != null) {
					preparedStatement.close();
	            }
				if (connect != null) {
					connect.close();
				}
			} catch (SQLException e) {

			}
		}		
	}
}
