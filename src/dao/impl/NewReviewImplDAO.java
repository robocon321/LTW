package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.NewReviewDAO;
import jdbc.ConnectDB;
import model.Cart;
import model.New;
import model.NewReview;

public class NewReviewImplDAO implements NewReviewDAO {

	@Override
	public boolean insert(NewReview newReview) {
		try {
			String sql = "INSERT INTO NewReview(review_id, new_id, star, status) VALUES(?, ?, ?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, newReview.getReviewId());
			st.setInt(2, newReview.getNewId());
			st.setInt(3, newReview.getStar());
			st.setBoolean(4, newReview.isStatus());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(NewReview oldItem, NewReview newItem) {
		try {
			String sql = "UPDATE NewReview SET review_id = ?, new_id = ?, star = ?, status = ?  WHERE review_id = ? AND new_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, newItem.getReviewId());
			st.setInt(2, newItem.getNewId());
			st.setInt(3, newItem.getStar());
			st.setBoolean(4, newItem.isStatus());
			st.setInt(5, oldItem.getReviewId());
			st.setInt(6, oldItem.getNewId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}

	}

	@Override
	public boolean disable(int reviewId, int newId) {
		try {
			String sql = "UPDATE NewReview SET status = 0 WHERE review_id = ? AND new_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, reviewId);
			st.setInt(2, newId);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean enable(int reviewId, int newId) {
		try {
			String sql = "UPDATE NewReview SET status = 1 WHERE review_id = ? AND new_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, reviewId);
			st.setInt(2, newId);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}

	}

	@Override
	public NewReview get(int reviewId, int newId) {
		try {
			String sql = "SELECT * FROM NewReview WHERE review_id = " + reviewId + "AND new_id = " + newId+" AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			NewReview newReview = new NewReview(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4));
			ConnectDB.closeConnection();
			return newReview;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<NewReview> getReviews(int newId) {
		try {
			List<NewReview> list = new ArrayList<NewReview>();
			String sql = "SELECT * FROM NewReview WHERE new_id = " + newId+" AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new NewReview(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<NewReview> getAll() {
		try {
			List<NewReview> list = new ArrayList<NewReview>();
			String sql = "SELECT * FROM NewReview WHERE status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new NewReview(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}
}
