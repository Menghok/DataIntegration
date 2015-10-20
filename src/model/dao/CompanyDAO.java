package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.Company;

public class CompanyDAO {

	private Connection cnn = null;
	
	public CompanyDAO() {
		
	}
	
	public ArrayList<Company> getAllCompanies() throws SQLException{
		ArrayList<Company> companies = new ArrayList<Company>();
		Company company = null;
		final String SQL = "SELECT *FROM companies;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				company = new Company();
				company.setCompanyId(rs.getInt("companyid"));
				company.setCompanyName(rs.getString("companyname"));
				company.setLogo(rs.getString("logo"));
				company.setTypeId(rs.getInt("typeid"));
				companies.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return companies;
	}
	
	public Company getCompany(int id) throws SQLException{
		Company company = new Company();
		final String SQL = "SELECT *FROM companies WHERE companyid = ?;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				company.setCompanyId(rs.getInt("companyid"));
				company.setCompanyName(rs.getString("companyname"));
				company.setLogo(rs.getString("logo"));
				company.setTypeId(rs.getInt("typeid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return company;
	}
	
	public boolean deleteCompany(int id) throws SQLException{
		final String SQL = "DELETE FROM companies WHERE companyid = ?;";
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
	
	public boolean updateCompany(Company company) throws SQLException{
		final String SQL ="UPDATE companies SET companyname = ?, logo = ?, typeid = ? WHERE companyid = ?;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setString(1, company.getCompanyName());
			pstmt.setString(2, company.getLogo());
			pstmt.setInt(3, company.getTypeId());
			pstmt.setInt(4, company.getCompanyId());
			if(pstmt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return false;
	}
	
	public boolean addCompany(Company Company) throws SQLException{
		final String SQL = "INSERT INTO types(companyname, logo, typeid) VALUES(?,?,?)";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setString(1, Company.getCompanyName());
			pstmt.setString(2, Company.getLogo());
			pstmt.setInt(3, Company.getTypeId());
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
