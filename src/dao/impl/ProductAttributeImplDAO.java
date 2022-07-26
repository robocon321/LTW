package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductAttributeDAO;
import jdbc.ConnectDB;
import model.Cart;
import model.ProductAttribute;

public class ProductAttributeImplDAO implements ProductAttributeDAO {

	@Override
	public boolean insert(ProductAttribute productAttribute) {
		try {
			String sql = "INSERT INTO ProductAttribute(product_id, title_id, value_id) VALUES(?, ?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, productAttribute.getProductId());
			st.setInt(2, productAttribute.getTitleId());
			st.setInt(3, productAttribute.getValueId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}

	}

	@Override
	public boolean edit(ProductAttribute oldItem, ProductAttribute newItem) {
		try {
			String sql = "UPDATE ProductAttribute SET product_id = ?, title_id = ?, value_id = ?  WHERE product_id = ? AND title_id = ? AND value_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, newItem.getProductId());
			st.setInt(2, newItem.getTitleId());
			st.setInt(3, newItem.getValueId());
			st.setInt(4, oldItem.getProductId());
			st.setInt(5, oldItem.getTitleId());
			st.setInt(6, oldItem.getValueId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}

	}

	@Override
	public boolean delete(ProductAttribute productAttribute) {
		try {
			String sql = "DELETE FROM ProductAttribute WHERE product_id = ? AND title_id = ? AND value_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, productAttribute.getProductId());
			st.setInt(2, productAttribute.getTitleId());
			st.setInt(3, productAttribute.getValueId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public List<ProductAttribute> getAttributes(int productId) {
		try {
			List<ProductAttribute> list = new ArrayList<ProductAttribute>();
			String sql = "SELECT * FROM ProductAttribute WHERE product_id = " + productId;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new ProductAttribute(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<ProductAttribute> getAll() {
		try {
			List<ProductAttribute> list = new ArrayList<ProductAttribute>();
			String sql = "SELECT * FROM ProductAttribute";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new ProductAttribute(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}
}
