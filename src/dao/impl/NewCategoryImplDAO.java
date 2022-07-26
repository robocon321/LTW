package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.NewCategoryDAO;
import jdbc.ConnectDB;
import model.Account;
import model.Admin;
import model.NewCategory;

public class NewCategoryImplDAO implements NewCategoryDAO{

	@Override
	public boolean insert(NewCategory newCategory) {
		try {
			String sql = "INSERT INTO NewCategory(name, parent_id) VALUES(?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, newCategory.getName());	
			st.setInt(2, newCategory.getParentId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(NewCategory newCategory) {
		try {
			String sql = "UPDATE NewCategory SET name = ?, parent_id = ? WHERE new_category_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, newCategory.getName());
			st.setInt(2, newCategory.getParentId());
			st.setInt(3, newCategory.getNewCategoryId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return false;
		}

	}



	@Override
	public NewCategory get(int id) {
		try {
			String sql = "SELECT * FROM NewCategory WHERE new_category_id =" + id;
			Connection conn = ConnectDB.openConnection();	
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			rs.next();
			NewCategory newCategory = new NewCategory(rs.getInt(1), rs.getNString(2), rs.getInt(3));
			ConnectDB.closeConnection();
			return newCategory;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<NewCategory> getAll() {
		try {
			List<NewCategory> list = new ArrayList<NewCategory>();
			String sql = "SELECT * FROM NewCategory";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				list.add(new NewCategory(rs.getInt(1), rs.getNString(2), rs.getInt(3)));
			}
			ConnectDB.closeConnection();
			return list;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			String sql = "DELETE FROM NewCategory WHERE new_category_id = ? AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}catch(Exception e) {
			ConnectDB.closeConnection();
			return false;
		}	}


	@Override
	public List<NewCategory> findBetween(String search, int start, int size) {
		try {
			ArrayList<NewCategory> list = new ArrayList<NewCategory>();
			String sql = "SELECT * FROM NewCategory WHERE name LIKE ? ORDER BY new_category_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" +search+ "%");
			st.setInt(2, start);
			st.setInt(3, size);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				list.add(new NewCategory(rs.getInt(1), rs.getNString(2), rs.getInt(3)));
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
			String sql = "SELECT COUNT(*) FROM NewCategory WHERE name LIKE ?";
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
