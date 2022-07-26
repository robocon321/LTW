package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ListNewCategoryDAO;
import jdbc.ConnectDB;
import model.ListNewCategory;

public class ListNewCategoryImplDAO implements ListNewCategoryDAO {

	@Override
	public boolean insert(ListNewCategory listNewCategory) {
		try {
			String sql = "INSERT INTO ListNewCategory(new_id, new_category_id) VALUES(?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, listNewCategory.getNewId());
			st.setInt(2, listNewCategory.getNewCategoryId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(ListNewCategory oldItem, ListNewCategory newItem) {
		try {
			String sql = "UPDATE ListNewCategory SET new_id = ?, new_category_id = ?  WHERE new_id = ? AND new_category_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, newItem.getNewId());
			st.setInt(2, newItem.getNewCategoryId());
			st.setInt(3, oldItem.getNewId());
			st.setInt(4, oldItem.getNewCategoryId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public List<ListNewCategory> getAll() {
		try {
			ArrayList<ListNewCategory> list = new ArrayList<ListNewCategory>();
			String sql = "SELECT * FROM ListNewCategory";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new ListNewCategory(rs.getInt(1), rs.getInt(2)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public boolean delete(ListNewCategory listNewCategory) {
		try {
			String sql = "DELETE FROM ListNewCategory WHERE new_id = ? AND new_category_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, listNewCategory.getNewId());
			st.setInt(2, listNewCategory.getNewCategoryId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public List<ListNewCategory> getCategorys(int newId) {
		try {
			ArrayList<ListNewCategory> list = new ArrayList<ListNewCategory>();
			String sql = "SELECT * FROM ListNewCategory WHERE new_id = "+newId;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new ListNewCategory(rs.getInt(1), rs.getInt(2)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<ListNewCategory> getNews(int newCategoryId) {
		try {
			ArrayList<ListNewCategory> list = new ArrayList<ListNewCategory>();
			String sql = "SELECT * FROM ListNewCategory WHERE new_category_id = "+newCategoryId;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new ListNewCategory(rs.getInt(1), rs.getInt(2)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<ListNewCategory> findBetween(int start, int end) {
		try {
			ArrayList<ListNewCategory> list = new ArrayList<ListNewCategory>();
			String sql = "SELECT * FROM ListNewCategory LIMIT "+start+", "+end;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new ListNewCategory(rs.getInt(1), rs.getInt(2)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}
}
