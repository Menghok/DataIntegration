package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.Article;

public class ArticleDAO {
	
	private Connection cnn = null;

	public ArticleDAO() {
		
	}
	
	public ArrayList<Article> getAllTypes() throws SQLException{
		ArrayList<Article> articles = new ArrayList<Article>();
		Article article = null;
		final String SQL = "SELECT *FROM articles;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				article = new Article();
				article.setArticleId(rs.getInt("articleid"));
				article.setArticleTitle(rs.getString("title"));
				article.setArticleDescription(rs.getString("thumnnail"));
				article.setArticleThumbnail(rs.getString("description"));
				article.setCreateDate(rs.getDate("createddate"));
				article.setModifierDate(rs.getDate("modifieddate"));
				article.setLikeAmount(rs.getInt("likeamount"));
				article.setCompanyId(rs.getInt("companyid"));
				articles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return articles;
	}
	
	public Article getArticle(int id) throws SQLException{
		Article article = new Article();
		final String SQL = "SELECT *FROM articles WHERE articleid = ?;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				article.getArticleId();
				article.getArticleDescription();
				article.getArticleThumbnail();
				article.getArticleTitle();
				article.getCreateDate();
				article.getModifierDate();
				article.getCompanyId();
				article.getLikeAmount();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return article;
	}
	
	public boolean deleteArticle(int id) throws SQLException{
		final String SQL = "DELETE FROM articles WHERE articleid = ?;";
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
	
	public boolean updateArticle(Article article) throws SQLException{
		final String SQL ="UPDATE article SET title = ?, thumbnail = ?, description = ?,,createddate = ?, modifieddate = ?, "
				+ "likeamount = ?, companyid = ? WHERE articleid = ?;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setString(1, article.getArticleTitle());
			pstmt.setString(2, article.getArticleThumbnail());
			pstmt.setString(3, article.getArticleDescription());
			pstmt.setDate(4, article.getCreateDate());
			pstmt.setDate(5, article.getModifierDate());
			pstmt.setInt(6, article.getLikeAmount());
			pstmt.setInt(7, article.getCompanyId());
			pstmt.setInt(8, article.getArticleId());
			if(pstmt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return false;
	}
	
	public boolean addArticle(Article article) throws SQLException{
		final String SQL = "INSERT INTO articles(title, thumbnail, description,createddate, modifieddate, likeamount, companyid ) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setString(1, article.getArticleTitle());
			pstmt.setString(2, article.getArticleThumbnail());
			pstmt.setString(3, article.getArticleDescription());
			pstmt.setDate(4, article.getCreateDate());
			pstmt.setDate(5, article.getModifierDate());
			pstmt.setInt(6, article.getLikeAmount());
			pstmt.setInt(7, article.getCompanyId());
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
