package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.Type;

public class TypeDAO {
	
	private Connection cnn = null;
	
	public TypeDAO() {
		
	}
	
	public ArrayList<Type> getAllTypes() throws SQLException{
		ArrayList<Type> types = new ArrayList<Type>();
		Type type = null;
		final String SQL = "SELECT *FROM types;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				type = new Type();
				type.setTypeId(rs.getInt("typeid"));
				type.setTypeName(rs.getString("typename"));
				types.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return types;
	}
	
	public Type getType(int id) throws SQLException{
		Type type = new Type();
		final String SQL = "SELECT *FROM types WHERE typeid = ?;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				type.setTypeId(rs.getInt("typeid"));
				type.setTypeName(rs.getString("typename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return type;
	}
	
	public boolean deleteType(int id) throws SQLException{
		final String SQL = "DELETE FROM types WHERE typeid = ?;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			if(pstmt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return false;
	}
	
	public boolean updateType(Type type) throws SQLException{
		final String SQL ="UPDATE types SET typename = ? WHERE typeid = ?;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setString(1, type.getTypeName());
			pstmt.setInt(2, type.getTypeId());
			if(pstmt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return false;
	}
	
	public boolean addType(Type type) throws SQLException{
		final String SQL = "INSERT INTO types(typename) VALUES(?)";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setString(1, type.getTypeName());
			if(pstmt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return false;
	}
	
}
