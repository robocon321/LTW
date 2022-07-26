package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductImageDAO;
import jdbc.ConnectDB;
import model.New;
import model.ProductImage;

public class ProductImageImplDAO implements ProductImageDAO{

	@Override
	public boolean insert(ProductImage productImage) {
		try {
			String sql = "INSERT INTO ProductImage(product_id, image_url) VALUES(?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, productImage.getProductId());
			st.setNString(2, productImage.getImageUrlContent());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(ProductImage oldImage, ProductImage newImage) {
		try {
			String sql = "UPDATE ProductImage SET product_id = ?, image_url = ? WHERE product_id = ?, image_url=?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, oldImage.getProductId());
			st.setNString(2, oldImage.getImageUrlContent());
			st.setInt(3, oldImage.getProductId());
			st.setNString(4, oldImage.getImageUrlContent());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return false;
		}

	}

	@Override
	public List<ProductImage> getAll() {
		try {
			List<ProductImage> list = new ArrayList<ProductImage>();
			String sql = "SELECT * FROM ProductImage";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				list.add(new ProductImage(rs.getInt(1), rs.getNString(2)));
			}
			ConnectDB.closeConnection();
			return list;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<ProductImage> getImages(int productId) {
		try {
			List<ProductImage> list = new ArrayList<ProductImage>();
			String sql = "SELECT * FROM ProductImage WHERE product_id = "+productId;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				list.add(new ProductImage(rs.getInt(1), rs.getNString(2)));
			}
			ConnectDB.closeConnection();
			return list;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public boolean delete(ProductImage productImage) {
		try {
			String sql = "DELETE FROM ProductImage WHERE product_id = ? AND image_url = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, productImage.getProductId());
			st.setNString(2, productImage.getImageUrlContent());
			return st.execute();
		} catch (SQLException e) {
			return false;
		}
	}

}
