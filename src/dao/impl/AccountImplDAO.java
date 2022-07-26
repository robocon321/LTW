package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AccountDAO;
import jdbc.ConnectDB;
import model.Account;
import model.Admin;

public class AccountImplDAO implements AccountDAO {

	@Override
	public boolean insert(Account account) {
		try {
			String sql = "INSERT INTO Account(uname, pwd, first_name, last_name, address, email, phone, created_date, created_by , status) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, account.getUsername());
			st.setString(2, account.getPassword());
			st.setNString(3, account.getFirstName());
			st.setNString(4, account.getLastName());
			st.setNString(5, account.getAddress());
			st.setString(6, account.getEmail());
			st.setString(7, account.getPhone());
			st.setDate(8, account.getCreatedDate());
			st.setInt(9, account.getCreatedBy());
			st.setBoolean(10, account.isStatus());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {
			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(Account account) {
		try {
			String sql = "UPDATE Account SET uname = ?, pwd = ?, first_name = ?, last_name = ?, address = ?, email = ?, phone = ?, created_date = ?, created_by = ?, status = ?  WHERE user_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, account.getUsername());
			st.setString(2, account.getPassword());
			st.setNString(3, account.getFirstName());
			st.setNString(4, account.getLastName());
			st.setNString(5, account.getAddress());
			st.setString(6, account.getEmail());
			st.setString(7, account.getPhone());
			st.setDate(8, account.getCreatedDate());
			st.setInt(9, account.getCreatedBy());
			st.setBoolean(10, account.isStatus());
			st.setInt(11, account.getUserId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean disable(int id) {
		try {
			String sql = "UPDATE Account SET status = 0 WHERE user_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean enable(int id) {
		try {
			String sql = "UPDATE Account SET status = 1 WHERE user_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {
			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public Account get(int id) {
		try {
			String sql = "SELECT * FROM Account WHERE user_id = ? AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			Account account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4),
					rs.getNString(5), rs.getNString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getInt(10),
					rs.getBoolean(11));
			ConnectDB.closeConnection();
			return account;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public Account get(String uname) {
		try {
			String sql = "SELECT * FROM Account WHERE uname = ? AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, uname);
			ResultSet rs = st.executeQuery();
			rs.next();
			Account account = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4),
					rs.getNString(5), rs.getNString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getInt(10),
					rs.getBoolean(11));
			ConnectDB.closeConnection();
			return account;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<Account> getAll() {
		try {
			ArrayList<Account> list = new ArrayList<Account>();
			String sql = "SELECT * FROM Account WHERE status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4), rs.getNString(5),
						rs.getNString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getInt(10),
						rs.getBoolean(11)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<Account> findBetween(String search, int start, int size) {
		try {
			ArrayList<Account> list = new ArrayList<Account>();
			String sql = "SELECT * FROM Account WHERE uname LIKE ? AND status = 'TRUE' ORDER BY user_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" +search+ "%");
			st.setInt(2, start);
			st.setInt(3, size);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4), rs.getNString(5),
						rs.getNString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getInt(10),
						rs.getBoolean(11)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			ConnectDB.closeConnection();
			return null;
		}			
	}
	
	@Override
	public int count(String search) {
		try {
			ArrayList<Account> list = new ArrayList<Account>();
			String sql = "SELECT COUNT(*) FROM Account WHERE uname LIKE ? AND status = 'true'";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" +search+ "%");
			ResultSet rs = st.executeQuery();
			rs.next();
			int result = rs.getInt(1);
			ConnectDB.closeConnection();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			ConnectDB.closeConnection();
			return 0;
		}			
	}
	
}
