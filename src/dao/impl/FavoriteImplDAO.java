package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.FavoriteDAO;
import jdbc.ConnectDB;
import model.Cart;
import model.Favorite;

public class FavoriteImplDAO implements FavoriteDAO {

	@Override
	public boolean insert(Favorite favorite) {
		try {
			String sql = "INSERT INTO Favorite(user_id, product_id) VALUES(?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, favorite.getUserId());
			st.setInt(2, favorite.getProductId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public List<Favorite> get(int userId) {
		try {
			ArrayList<Favorite> list = new ArrayList<Favorite>();
			String sql = "SELECT * FROM Favorite WHERE user_id = " + userId;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Favorite(rs.getInt(1), rs.getInt(2)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<Favorite> getAll() {
		try {
			ArrayList<Favorite> list = new ArrayList<Favorite>();
			String sql = "SELECT * FROM Favorite";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Favorite(rs.getInt(1), rs.getInt(2)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public boolean delete(int userId, int productId) {
		try {
			String sql = "DELETE FROM Favorite WHERE user_id = ? AND product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, userId);
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
	public boolean delete(int userId) {
		try {
			String sql = "DELETE FROM Favorite WHERE user_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, userId);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {
			ConnectDB.closeConnection();
			return false;
		}		
	}
	
	public static void main(String[] args) {
		System.out.println(new FavoriteImplDAO().get(4).size());
	}
}
