package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.NewDAO;
import jdbc.ConnectDB;
import model.Account;
import model.New;
import model.NewCategory;

public class NewImplDAO implements NewDAO {

	@Override
	public boolean insert(New vnew) {
		try {
			String sql = "INSERT INTO New(title, description, new_image, detail, view_count, created_date, created_by, status) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, vnew.getTitle());
			st.setNString(2, vnew.getDescription());
			st.setNString(3, vnew.getNewImage());
			st.setNString(4, vnew.getDetail());
			st.setInt(5, vnew.getViewCount());
			st.setDate(6, vnew.getCreatedDate());
			st.setInt(7, vnew.getCreatedBy());
			st.setBoolean(8, vnew.isStatus());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}

	}

	@Override
	public boolean edit(New vnew) {
		try {
			String sql = "UPDATE New SET title = ?, description = ?, new_image = ?, detail = ?, view_count = ?, created_date = ?, created_by = ?, status = ? WHERE new_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, vnew.getTitle());
			st.setNString(2, vnew.getDescription());
			st.setNString(3, vnew.getNewImage());
			st.setNString(4, vnew.getDetail());
			st.setInt(5, vnew.getViewCount());
			st.setDate(6, vnew.getCreatedDate());
			st.setInt(7, vnew.getCreatedBy());
			st.setBoolean(8, vnew.isStatus());
			st.setInt(9, vnew.getNewId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean disable(int id) {
		try {
			String sql = "UPDATE New SET status = 0 WHERE new_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean enable(int id) {
		try {
			String sql = "UPDATE New SET status = 1 WHERE new_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public New get(int id) {
		try {
			String sql = "SELECT * FROM New WHERE new_id = "+id+" AND status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			New vnew = new New(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getNString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getBoolean(9));
			ConnectDB.closeConnection();
			return vnew;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<New> getAll() {
		try {
			List<New> list = new ArrayList<New>();
			String sql = "SELECT * FROM New WHERE status = 'TRUE'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				list.add(new New(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getNString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getBoolean(9)));
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
			String sql = "SELECT MAX(new_id) FROM New";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			return 0;
		}
	}


	@Override
	public List<New> findBetween(String search, int start, int size) {
		try {
			ArrayList<New> list = new ArrayList<New>();
			String sql = "SELECT * FROM New WHERE title LIKE ? AND status = 'TRUE' ORDER BY new_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, "%" +search+ "%");
			st.setInt(2, start);
			st.setInt(3, size);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				list.add(new New(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getNString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getBoolean(9)));
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
			ArrayList<New> list = new ArrayList<New>();
			String sql = "SELECT COUNT(*) FROM New WHERE title LIKE ? AND status = 'true'";
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
