package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductReviewDAO;
import jdbc.ConnectDB;
import model.NewReview;
import model.ProductReview;

public class ProductReviewImplDAO implements ProductReviewDAO {

	@Override
	public boolean insert(ProductReview productImage) {
		try {
			String sql = "INSERT INTO ProductReview(review_id, product_id, star, status) VALUES(?, ?, ?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, productImage.getReviewId());
			st.setInt(2, productImage.getProductId());
			st.setInt(3, productImage.getStar());
			st.setBoolean(4, productImage.isStatus());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(ProductReview oldItem, ProductReview newItem) {
		try {
			String sql = "UPDATE ProductReview SET review_id = ?, product_id = ?, star = ?, status = ?  WHERE review_id = ? AND product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, newItem.getReviewId());
			st.setInt(2, newItem.getProductId());
			st.setInt(3, newItem.getStar());
			st.setBoolean(4, newItem.isStatus());
			st.setInt(5, oldItem.getReviewId());
			st.setInt(6, oldItem.getProductId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean enable(int reviewId, int productId) {
		try {
			String sql = "UPDATE ProductReview SET status = 1 WHERE review_id = ? AND product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, reviewId);
			st.setInt(2, productId);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean disable(int reviewId, int productId) {
		try {
			String sql = "UPDATE ProductReview SET status = 0 WHERE review_id = ? AND product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, reviewId);
			st.setInt(2, productId);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public ProductReview get(int reviewId, int productId) {
		try {
			String sql = "SELECT * FROM ProductReview WHERE review_id = "+reviewId+"AND product_id = "+productId+" AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			ProductReview productReview = new ProductReview(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4));
			ConnectDB.closeConnection();
			return productReview;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return null;
		}	}

	@Override
	public List<ProductReview> getReviews(int productId) {
		try {
			List<ProductReview> list = new ArrayList<ProductReview>();
			String sql = "SELECT * FROM ProductReview WHERE product_id = " + productId+" AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new ProductReview(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<ProductReview> getAll() {
		try {
			List<ProductReview> list = new ArrayList<ProductReview>();
			String sql = "SELECT * FROM ProductReview WHERE status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new ProductReview(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}
}
