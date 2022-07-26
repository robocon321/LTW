package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;
import jdbc.ConnectDB;
import model.Account;
import model.New;
import model.Product;

public class ProductImplDAO implements ProductDAO{

	@Override
	public boolean insert(Product product) {
		try {
			String sql = "INSERT INTO Product(name, description, image_main, price, promotions_price, include_vat, quantity, detail, view_count, brand, category_id, launch_date, created_date, created_by, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, product.getName());
			st.setNString(2, product.getDescription());
			st.setNString(3, product.getImageMain());
			st.setInt(4, product.getPrice());
			st.setInt(5, product.getPromotionPrice());
			st.setBoolean(6, product.isIncludeVat());
			st.setInt(7, product.getQuantity());
			st.setNString(8, product.getDetail());
			st.setInt(9, product.getViewCount());
			st.setNString(10, product.getBrand());
			st.setInt(11, product.getCategoryId());
			st.setDate(12, product.getLaunchDate());
			st.setDate(13, product.getCreatedDate());
			st.setInt(14, product.getCreatedBy());
			st.setBoolean(15, product.isStatus());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}catch(Exception e) {
			ConnectDB.closeConnection();
			return false;
		}		

	}

	@Override
	public boolean edit(Product product) {
		try {
			String sql = "UPDATE Product SET name = ?, description = ?, image_main = ?, price = ?, promotions_price = ?, include_vat = ?, quantity = ?, detail = ?, view_count = ?, brand = ?, category_id = ?, launch_date = ?, created_date = ?, created_by = ?, status = ? WHERE product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, product.getName());
			st.setNString(2, product.getDescription());
			st.setNString(3, product.getImageMain());
			st.setInt(4, product.getPrice());
			st.setInt(5, product.getPromotionPrice());
			st.setBoolean(6, product.isIncludeVat());
			st.setInt(7, product.getQuantity());
			st.setNString(8, product.getDetail());
			st.setInt(9, product.getViewCount());
			st.setNString(10, product.getBrand());
			st.setInt(11, product.getCategoryId());
			st.setDate(12, product.getLaunchDate());
			st.setDate(13, product.getCreatedDate());
			st.setInt(14, product.getCreatedBy());
			st.setBoolean(15, product.isStatus());
			st.setInt(16, product.getProductId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return false;
		}	
	}

	@Override
	public boolean enable(int id) {
		try {
			String sql = "UPDATE Product SET status = 1 WHERE product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return false;
		}

	}

	@Override
	public boolean disalbe(int id) {
		try {
			String sql = "UPDATE Product SET status = 0 WHERE product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public Product get(int id) {
		try {
			List<Product> list = new ArrayList<Product>();
			String sql = "SELECT * FROM Product WHERE product_id = "+id+" AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			Product product = new Product(rs.getInt(1), 
						rs.getNString(2),
						rs.getNString(3), 
						rs.getNString(4), 
						rs.getInt(5), 
						rs.getInt(6), 
						rs.getBoolean(7), 
						rs.getInt(8), 
						rs.getNString(9), 
						rs.getInt(10), 
						rs.getNString(11), 
						rs.getInt(12),
						rs.getDate(13), 
						rs.getDate(14), 
						rs.getInt(15), 
						rs.getBoolean(16));
			ConnectDB.closeConnection();
			return product;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<Product> getAll() {
		try {
			List<Product> list = new ArrayList<Product>();
			String sql = "SELECT * FROM Product WHERE status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getNString(2),
						rs.getNString(3), 
						rs.getNString(4), 
						rs.getInt(5), 
						rs.getInt(6), 
						rs.getBoolean(7), 
						rs.getInt(8), 
						rs.getNString(9), 
						rs.getInt(10), 
						rs.getNString(11),
						rs.getInt(12),
						rs.getDate(13), 
						rs.getDate(14), 
						rs.getInt(15), 
						rs.getBoolean(16)));
			}
			ConnectDB.closeConnection();
			return list;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public int getCurrentId() {
		try {
			String sql = "SELECT MAX(product_id) FROM Product";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			return 0;
		}
	}

	@Override
	public List<Product> findBetween(String search, int start, int size) {
		try {
			ArrayList<Product> list = new ArrayList<Product>();
			String sql = "SELECT * FROM Product WHERE name LIKE ? AND status = 'TRUE' ORDER BY product_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" +search+ "%");
			st.setInt(2, start);
			st.setInt(3, size);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getNString(2),
						rs.getNString(3), 
						rs.getNString(4), 
						rs.getInt(5), 
						rs.getInt(6), 
						rs.getBoolean(7), 
						rs.getInt(8), 
						rs.getNString(9), 
						rs.getInt(10), 
						rs.getNString(11),
						rs.getInt(12),
						rs.getDate(13), 
						rs.getDate(14), 
						rs.getInt(15), 
						rs.getBoolean(16)));
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
			ArrayList<Product> list = new ArrayList<Product>();
			String sql = "SELECT COUNT(*) FROM Product WHERE name LIKE ? AND status = 'true'";
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
