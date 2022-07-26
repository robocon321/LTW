package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.OrderInfoDAO;
import jdbc.ConnectDB;
import model.Account;
import model.New;
import model.OrderInfo;
import model.ProductAttribute;

public class OrderInfoImplDAO implements OrderInfoDAO {

	@Override
	public boolean insert(OrderInfo orderInfo) {
		try {
			String sql = "INSERT INTO OrderInfo(first_name, last_name, address, email, phone, created_date, created_by, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, orderInfo.getFirstName());
			st.setNString(2, orderInfo.getLastName());
			st.setNString(3, orderInfo.getAddress());
			st.setString(4, orderInfo.getEmail());
			st.setString(5, orderInfo.getPhone());
			st.setDate(6, orderInfo.getCreatedDate());
			st.setInt(7, orderInfo.getCreatedBy());
			st.setBoolean(8, orderInfo.isStatus());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(OrderInfo orderInfo) {
		try {
			String sql = "UPDATE OrderInfo SET first_name = ?, last_name = ?, address = ?, phone = ?, email = ?, created_date = ?, created_by = ?, status = ? WHERE order_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, orderInfo.getFirstName());
			st.setNString(2, orderInfo.getLastName());
			st.setNString(3, orderInfo.getAddress());
			st.setString(4, orderInfo.getPhone());
			st.setString(5, orderInfo.getEmail());
			st.setDate(6, orderInfo.getCreatedDate());
			st.setInt(7, orderInfo.getCreatedBy());
			st.setBoolean(8, orderInfo.isStatus());
			st.setInt(9, orderInfo.getOrderId());
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
			String sql = "UPDATE OrderInfo SET status = 1 WHERE order_id = ?";
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
			String sql = "UPDATE OrderInfo SET status = 0 WHERE order_id = ?";
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
	public OrderInfo get(int id) {
		try {
			String sql = "SELECT * FROM OrderInfo WHERE order_id = " + id+" AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			OrderInfo orderInfo = new OrderInfo(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getNString(4),
					rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getBoolean(9));
			ConnectDB.closeConnection();
			return orderInfo;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<OrderInfo> getAll() {
		try {
			List<OrderInfo> list = new ArrayList<OrderInfo>();
			String sql = "SELECT * FROM OrderInfo WHERE status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new OrderInfo(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getNString(4),
						rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getBoolean(9)));
			}
			ConnectDB.closeConnection();
			return list;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}


	@Override
	public List<OrderInfo> findBetween(String search, int start, int size) {
		try {
			ArrayList<OrderInfo> list = new ArrayList<OrderInfo>();
			String sql = "SELECT * FROM OrderInfo WHERE first_name LIKE ? AND status = 'TRUE' ORDER BY order_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" +search+ "%");
			st.setInt(2, start);
			st.setInt(3, size);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new OrderInfo(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getNString(4),
						rs.getString(5), rs.getString(6), rs.getDate(7), rs.getInt(8), rs.getBoolean(9)));
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
			ArrayList<OrderInfo> list = new ArrayList<OrderInfo>();
			String sql = "SELECT COUNT(*) FROM OrderInfo WHERE first_name LIKE ? AND status = 'true'";
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

	@Override
	public int getCurrentId() {
		try {
			String sql = "SELECT MAX(order_id) FROM OrderInfo";
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
