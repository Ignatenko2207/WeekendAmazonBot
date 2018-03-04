package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.itstep.model.Account;

public class AccountDAO {

	public static Account save(Account account) {
		
		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		try {
			if (connection != null) {
				String sql = "INSERT INTO accounts (email, password, first_name, second_name) VALUES(?,?,?,?)";

				statement = connection.prepareStatement(sql);
				statement.setString(1, account.getEmail());
				statement.setString(2, account.getPassword());
				statement.setString(3, account.getFirstName());
				statement.setString(4, account.getSecondName());
				
				statement.executeUpdate();
				
				return account;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(statement, connection);
		}
		return null;
	}

	public static Account get(Account account) {

		return null;
	}

	public static Account update(Account account) {

		return null;
	}

	public static void delite(Account account) {

	}

}
