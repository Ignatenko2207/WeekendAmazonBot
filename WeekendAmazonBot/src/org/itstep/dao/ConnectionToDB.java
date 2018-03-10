package org.itstep.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionToDB {

	private static final String USER_NAME = "postgres";

	private static final String USER_PASSWORD = "248842";

	private static final String URL = "jdbc:postgresql://localhost:5432/weekend_db";
	
//	private static final String USER_NAME = "postgres";
//
//	private static final String USER_PASSWORD = "248842";
//
//	private static final String URL = "jdbc:postgresql://localhost:5432/weekend_db";

	protected static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	protected static void closeConnection(PreparedStatement statement, Connection connection) {

		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected static void closeConnection(ResultSet rSet, PreparedStatement statement, Connection connection) {
		try {
			rSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
