package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ProductTitleDAO;
import jdbc.ConnectDB;
import model.New;
import model.ProductImage;
import model.ProductTitle;

public class ProductTitleImpleDAO implements ProductTitleDAO {

	@Override
	public boolean insert(ProductTitle productTitle) {
		try {
			String sql = "INSERT INTO ProductTitle(title_content) VALUES(?)";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, productTitle.getTitleContent());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean edit(ProductTitle productTitle) {
		try {
			String sql = "UPDATE ProductTitle SET title_content = ? WHERE title_id = ?";
			Connection conn = ConnectDB.openConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setNString(1, productTitle.getTitleContent());
			st.setInt(2, productTitle.getTitleId());
			st.executeUpdate();
			ConnectDB.closeConnection();
			return true;
		} catch (Exception e) {

			ConnectDB.closeConnection();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			String sql = "DELETE FROM ProductTitle WHERE title_id = ?";
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
	public ProductTitle get(int id) {
		try {
			String sql = "SELECT * FROM ProductTitle WHERE title_id = " + id;
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			ProductTitle productTitle = new ProductTitle(rs.getInt(1), rs.getNString(2));
			ConnectDB.closeConnection();
			return productTitle;
		} catch (Exception e) {
			e.printStackTrace();
			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public List<ProductTitle> getAll() {
		try {
			List<ProductTitle> list = new ArrayList<ProductTitle>();
			String sql = "SELECT * FROM ProductTitle";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				list.add(new ProductTitle(rs.getInt(1), rs.getNString(2)));
			}
			ConnectDB.closeConnection();
			return list;
		}catch(Exception e) {

			ConnectDB.closeConnection();
			return null;
		}
	}

	@Override
	public int find(String title) {
		try {
			String sql = "SELECT * FROM ProductTitle WHERE title_content = N'"+title+"'";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			return rs.next() ? rs.getInt(1) : -1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int getCurrentId() {
		try {
			String sql = "SELECT MAX(title_id) FROM ProductTitle";
			Connection conn = ConnectDB.openConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new ProductAttributeImplDAO().getAttributes(1));
	}
}
