package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AdminDAO;
import jdbc.ConnectDB;
import model.Account;
import model.Admin;

public class AdminImplDAO implements AdminDAO {

	@Override
	public boolean insert(Admin admin) {
		try {
			String sql = "INSERT INTO Admin (uname, pwd, first_name, last_name, address, email, phone, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, admin.getUsername());
			st.setString(2, admin.getPassword());
			st.setNString(3, admin.getFirstName());
			st.setNString(4, admin.getLastName());
			st.setNString(5, admin.getAddress());
			st.setNString(6, admin.getEmail());
			st.setNString(7, admin.getPhone());
			st.setBoolean(8, admin.isStatus());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(Admin admin) {
		try {
			String sql = "UPDATE Admin SET uname = ?, pwd = ?, first_name = ?, last_name = ?, address = ?, email = ?, phone = ?, status = ?  WHERE admin_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, admin.getUsername());
			st.setString(2, admin.getPassword());
			st.setNString(3, admin.getFirstName());
			st.setNString(4, admin.getLastName());
			st.setNString(5, admin.getAddress());
			st.setString(6, admin.getEmail());
			st.setNString(7, admin.getPhone());
			st.setBoolean(8, admin.isStatus());
			st.setInt(9, admin.getAdminId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}

	}

	@Override
	public boolean disable(int id) {
		try {
			String sql = "UPDATE Admin SET status = 0 WHERE admin_id = ?";
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
			String sql = "UPDATE Admin SET status = 1 WHERE admin_id = ?";
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
	public Admin get(int id) {
		try {
			String sql = "SELECT * FROM Admin WHERE admin_id = ? AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4), rs.getNString(5),
					rs.getNString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9));
			ConnectDB.closeConnection();
			return admin;
		} catch (Exception e) {
			ConnectDB.closeConnection();
			return null;
		}

	}

	@Override
	public Admin get(String uname) {
		try {
			String sql = "SELECT * FROM Admin WHERE uname = ? AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, uname);
			ResultSet rs = st.executeQuery();
			rs.next();
			Admin admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4), rs.getNString(5),
					rs.getNString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9));
			ConnectDB.closeConnection();
			return admin;
		} catch (Exception e) {
			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<Admin> getAll() {
		try {
			ArrayList<Admin> list = new ArrayList<Admin>();
			String sql = "SELECT * FROM Admin WHERE status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4), rs.getNString(5),
						rs.getNString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9)));
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
	public List<Admin> findBetween(String search, int start, int size) {
		try {
			ArrayList<Admin> list = new ArrayList<Admin>();
			String sql = "SELECT * FROM Admin WHERE uname LIKE ? AND status = 'TRUE' ORDER BY admin_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" +search+ "%");
			st.setInt(2, start);
			st.setInt(3, size);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4), rs.getNString(5),
						rs.getNString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9)));
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
			ArrayList<Admin> list = new ArrayList<Admin>();
			String sql = "SELECT COUNT(*) FROM Admin WHERE uname LIKE ? AND status = 'true'";
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
