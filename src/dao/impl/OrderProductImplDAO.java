package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.OrderProductDAO;
import jdbc.ConnectDB;
import model.Account;
import model.NewReview;
import model.OrderProduct;

public class OrderProductImplDAO implements OrderProductDAO {

	@Override
	public boolean insert(OrderProduct orderProduct) {
		try {
			String sql = "INSERT INTO OrderProduct(order_id, product_id, quantity, ship_date, status) VALUES(?,?,?,?,?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, orderProduct.getOrderId());
			st.setInt(2, orderProduct.getProductId());
			st.setInt(3, orderProduct.getQuantity());
			st.setDate(4, orderProduct.getShipDate());
			st.setBoolean(5, orderProduct.isStatus());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(OrderProduct oldItem, OrderProduct newItem) {
		try {
			String sql = "UPDATE OrderProduct SET order_id = ?, product_id = ?, quantity = ?, ship_date = ?, status = ?  WHERE order_id = ? AND product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, newItem.getOrderId());
			st.setInt(2, newItem.getProductId());
			st.setInt(3, newItem.getQuantity());
			st.setDate(4, newItem.getShipDate());
			st.setBoolean(5, newItem.isStatus());
			st.setInt(6, oldItem.getOrderId());
			st.setInt(7, oldItem.getProductId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}

	}

	@Override
	public boolean enable(int orderId, int productId) {
		try {
			String sql = "UPDATE OrderProduct SET status = 1 WHERE order_id = ? AND product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, orderId);
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
	public boolean disable(int orderId, int productId) {
		try {
			String sql = "UPDATE OrderProduct SET status = 0 WHERE order_id = ? AND product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, orderId);
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
	public boolean delete(int orderId, int productId) {
		try {
			String sql = "DELETE FROM OrderProduct WHERE order_id = ? AND product_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, orderId);
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
	public OrderProduct get(int orderId, int productId) {
		try {
			String sql = "SELECT * FROM OrderProduct WHERE order_id = "+orderId+" AND product_id = "+productId +" AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			OrderProduct orderProduct = new OrderProduct(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getBoolean(5));
			ConnectDB.closeConnection();
			return orderProduct;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}		
	}

	@Override
	public List<OrderProduct> getProducts(int orderId) {
		try {
			List<OrderProduct> list = new ArrayList<OrderProduct>();
			String sql = "SELECT * FROM OrderProduct WHERE order_id = "+orderId+"  AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new OrderProduct(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getBoolean(5)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}		
	}

	@Override
	public List<OrderProduct> getAll() {
		try {
			List<OrderProduct> list = new ArrayList<OrderProduct>();
			String sql = "SELECT * FROM OrderProduct WHERE status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new OrderProduct(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getBoolean(5)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}


	@Override
	public List<OrderProduct> findBetween(String search, int start, int size) {
		try {
			ArrayList<OrderProduct> list = new ArrayList<OrderProduct>();
			String sql = "SELECT * FROM OrderProduct WHERE order_id LIKE ? AND status = 'TRUE' ORDER BY order_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" +search+ "%");
			st.setInt(2, start);
			st.setInt(3, size);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new OrderProduct(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getBoolean(5)));
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
			ArrayList<OrderProduct> list = new ArrayList<OrderProduct>();
			String sql = "SELECT COUNT(*) FROM OrderProduct WHERE order_id LIKE ? AND status = 'true'";
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
