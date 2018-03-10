package org.itstep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public static Account getOne(String email) {

		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;

		try {
			if (connection != null) {
				String sql = "SELECT * FROM accounts WHERE asin=?";

				statement = connection.prepareStatement(sql);
				statement.setString(1, email);

				rSet = statement.executeQuery();

				Account account = new Account();
				while (rSet.next()) {
					account.setEmail(rSet.getString("email"));
					account.setPassword(rSet.getString("password"));
					account.setFirstName(rSet.getString(3));
					account.setSecondName(rSet.getString(4));

					return account;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(rSet, statement, connection);
		}
		return null;
	}

	public static List<Account> getAll() {

		Connection connection = ConnectionToDB.getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;

		try {
			if (connection != null) {
				String sql = "SELECT * FROM accounts";

				statement = connection.prepareStatement(sql);
				
				rSet = statement.executeQuery();

				List<Account> accounts = new ArrayList<>();
				
				while (rSet.next()) {
					
					Account account = new Account();
					
					account.setEmail(rSet.getString("email"));
					account.setPassword(rSet.getString("password"));
					account.setFirstName(rSet.getString(3));
					account.setSecondName(rSet.getString(4));

					accounts.add(account);
				}
				
				if(!accounts.isEmpty()) {
					return accounts;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionToDB.closeConnection(rSet, statement, connection);
		}
		return null;
	}

	public static Account update(Account account) {

		
		
		return null;
	}

	public static void delite(Account account) {

	}

}
