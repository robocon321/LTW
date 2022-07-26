package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.CartDAO;
import jdbc.ConnectDB;
import model.Admin;
import model.Cart;

public class CartImplDAO implements CartDAO {

	@Override
	public boolean insert(Cart cart) {
		try {
			String sql = "INSERT INTO Cart(user_id, product_id, quantity) VALUES(?, ?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, cart.getUserId());
			st.setInt(2, cart.getProductId());
			st.setInt(3, cart.getQuantity());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(Cart cart) {
		try {
			String sql = "UPDATE Cart SET quantity = ?  WHERE user_id = ? AND product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, cart.getQuantity());
			st.setInt(2, cart.getUserId());
			st.setInt(3, cart.getProductId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean delete(int userId, int productId) {
		try {
			String sql = "DELETE FROM Cart WHERE user_id = ? AND product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, userId);
			st.setInt(2, productId);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}
		catch(Exception e) {

			ConnectDB.closeConnection();	
			return false;
		}
	}

	@Override
	public List<Cart> get(int userId) {
		try {
			List<Cart> list = new ArrayList<Cart>();
			String sql = "SELECT * FROM Cart WHERE user_id = " + userId;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}


	@Override
	public List<Cart> getAll() {
		try {
			List<Cart> list = new ArrayList<Cart>();
			String sql = "SELECT * FROM Cart";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public Cart get(int userId, int productId) {
		try {
			String sql = "SELECT * FROM Cart WHERE user_id = " + userId+" AND product_id = "+productId;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			Cart cart = new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			ConnectDB.closeConnection();
			return cart;
		} catch (Exception e) {
			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public boolean delete(int userId) {
		try {
			String sql = "DELETE FROM Cart WHERE user_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, userId);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}
		catch(Exception e) {
			ConnectDB.closeConnection();	
			return false;
		}	}
	
}
