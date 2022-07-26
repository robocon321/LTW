package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductCategoryDAO;
import jdbc.ConnectDB;
import model.Account;
import model.Admin;
import model.ProductCategory;

public class ProductCategoryImplDAO implements ProductCategoryDAO {

	@Override
	public boolean insert(ProductCategory productCategory) {
		try {
			String sql = "INSERT INTO ProductCategory (name, parent_id) VALUES(?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, productCategory.getName());
			st.setInt(2, productCategory.getParentId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(ProductCategory productCategory) {
		try {
			String sql = "UPDATE ProductCategory SET name = ?, parent_id = ? WHERE category_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, productCategory.getName());
			st.setInt(2, productCategory.getParentId());
			st.setInt(3, productCategory.getCategoryId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}
	
	@Override
	public ProductCategory get(int id) {
		try {
			String sql = "SELECT * FROM ProductCategory WHERE category_id = " + id;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			ProductCategory productCategory = new ProductCategory(rs.getInt(1), rs.getNString(2), rs.getInt(3));
			ConnectDB.closeConnection();
			return productCategory;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<ProductCategory> getAll() {
		try {
			ArrayList<ProductCategory> list = new ArrayList<ProductCategory>();
			String sql = "SELECT * FROM ProductCategory";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new ProductCategory(rs.getInt(1), rs.getNString(2), rs.getInt(3)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {
			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			String sql = "DELETE FROM ProductCategory WHERE category_id = "+id;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			st.executeQuery(sql);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


	@Override
	public List<ProductCategory> findBetween(String search, int start, int size) {
		try {
			ArrayList<ProductCategory> list = new ArrayList<ProductCategory>();
			String sql = "SELECT * FROM ProductCategory WHERE name LIKE ? ORDER BY category_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, "%" +search+ "%");
			st.setInt(2, start);
			st.setInt(3, size);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new ProductCategory(rs.getInt(1), rs.getNString(2), rs.getInt(3)));
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
			ArrayList<ProductCategory> list = new ArrayList<ProductCategory>();
			String sql = "SELECT COUNT(*) FROM ProductCategory WHERE name LIKE ?";
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
