package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductValueDAO;
import jdbc.ConnectDB;
import model.ProductImage;
import model.ProductValue;

public class ProductValueImplDAO implements ProductValueDAO {

	@Override
	public boolean insert(ProductValue productValue) {
		try {
			String sql = "INSERT INTO ProductValue(value_content, title_id) VALUES(?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, productValue.getValueContent());
			st.setInt(2, productValue.getTitleId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(ProductValue productValue) {
		try {
			String sql = "UPDATE ProductValue SET value_content = ?, title_id = ? WHERE value_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, productValue.getValueContent());
			st.setInt(2, productValue.getTitleId());
			st.setInt(3, productValue.getValueId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			String sql = "DELETE FROM ProductValue WHERE value_id = " + id;
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public ProductValue get(int id) {
		try {
			String sql = "SELECT * FROM ProductValue WHERE value_id = "+id;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			ProductValue productValue = new ProductValue(rs.getInt(1), rs.getNString(2), rs.getInt(3));
			ConnectDB.closeConnection();
			return productValue;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return null;
		}	
	}

	@Override
	public List<ProductValue> getValues(int idTitle) {
		try {
			List<ProductValue> list = new ArrayList<ProductValue>();
			String sql = "SELECT * FROM ProductValue WHERE title_id = "+idTitle;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				list.add(new ProductValue(rs.getInt(1), rs.getNString(2), rs.getInt(3)));
			}
			ConnectDB.closeConnection();
			return list;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return null;
		}	
	}

	@Override
	public List<ProductValue> getAll() {
		try {
			List<ProductValue> list = new ArrayList<ProductValue>();
			String sql = "SELECT * FROM ProductValue";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				list.add(new ProductValue(rs.getInt(1), rs.getNString(2), rs.getInt(3)));
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
			String sql = "SELECT MAX(value_id) FROM ProductValue";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			return 0;
		}
	}
	
}
