
package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ReviewDAO;
import jdbc.ConnectDB;
import model.New;
import model.Review;

public class ReviewImplDAO implements ReviewDAO {

	@Override
	public boolean insert(Review review) {
		try {
			String sql = "INSERT INTO Review(title, content, created_date, created_by, status) VALUES(?, ?, ?, ?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, review.getTitle());
			st.setNString(2, review.getContent());
			st.setDate(3, review.getCreatedDate());
			st.setInt(4, review.getCreatedBy());
			st.setBoolean(5, review.isStatus());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(Review review) {
		try {
			String sql = "UPDATE Review SET title = ?, content = ?, created_date = ?, created_by = ?, status = ? WHERE review_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, review.getTitle());
			st.setNString(2, review.getContent());
			st.setDate(3, review.getCreatedDate());
			st.setInt(4, review.getCreatedBy());
			st.setBoolean(5, review.isStatus());
			st.setInt(6, review.getReviewId());
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
			String sql = "UPDATE Review SET status = 1 WHERE review_id = ?";
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
	public boolean disable(int id) {
		try {
			String sql = "UPDATE Review SET status = 0 WHERE review_id = ?";
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
	public Review get(int id) {
		try {
			String sql = "SELECT * FROM Review WHERE review_id = " + id+" AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			Review review = new Review(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getDate(4), rs.getInt(5),
					rs.getBoolean(6));
			ConnectDB.closeConnection();
			return review;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<Review> getAll() {
		try {
			List<Review> list = new ArrayList<Review>();
			String sql = "SELECT * FROM Review WHERE status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Review(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getDate(4), rs.getInt(5),
						rs.getBoolean(6)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

}
