package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dto.Comment;

public class CommentDAO {

	private Connection cnn = null;
	
	public CommentDAO() {}
	
	public ArrayList<Comment> getAllComment() throws SQLException{
		ArrayList<Comment> comments = new ArrayList<Comment>();
		Comment comment = null;
		final String SQL = "SELECT *FROM comments;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				comment = new Comment();
				comment.setCommentId(rs.getInt("commentid"));
				comment.setCommentDescription(rs.getString("description"));
				comment.setUsername(rs.getString("username"));
				comment.setCreateDate(rs.getDate("createddate"));
				comment.setLikeAmount(rs.getInt("likeamount"));
				comment.setDislikeAmount(rs.getInt("dislikeamount"));
				comment.setReplyAmount(rs.getInt("replyamount"));
				comment.setReplyTo(rs.getInt("replyto"));
				comment.setArticleId(rs.getInt("articleid"));
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return comments;
	}
	
	public Comment getComment(int id) throws SQLException{
		Comment comment = new Comment();
		final String SQL = "SELECT *FROM comments WHERE commentid = ?;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				comment.setCommentId(rs.getInt("commentid"));
				comment.setCommentDescription(rs.getString("description"));
				comment.setUsername(rs.getString("username"));
				comment.setCreateDate(rs.getDate("createddate"));
				comment.setLikeAmount(rs.getInt("likeamount"));
				comment.setDislikeAmount(rs.getInt("dislikeamount"));
				comment.setReplyAmount(rs.getInt("replyamount"));
				comment.setReplyTo(rs.getInt("replyto"));
				comment.setArticleId(rs.getInt("articleid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return comment;
	}
	
	public boolean deleteComment(int id) throws SQLException{
		final String SQL = "DELETE FROM comments WHERE commentid = ?;";
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
	
	public boolean updateComment(Comment comment) throws SQLException{
		final String SQL ="UPDATE comments SET description = ?, username = ?, createddate = ?, "
				+ "likeamount = ?, dislikeamount = ?, replyamount = ?, replyto = ?, articleid = ? "
				+ "WHERE commentid = ?;";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setString(1, comment.getCommentDescription());
			pstmt.setString(2, comment.getUsername());
			pstmt.setDate(3, comment.getCreateDate());
			pstmt.setInt(4, comment.getLikeAmount());
			pstmt.setInt(5, comment.getDislikeAmount());
			pstmt.setInt(6, comment.getReplyAmount());
			pstmt.setInt(7, comment.getReplyTo());
			pstmt.setInt(8, comment.getArticleId());
			pstmt.setInt(9, comment.getCommentId());
			if(pstmt.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			cnn.close();
		}
		return false;
	}
	
	public boolean addComment(Comment comment) throws SQLException{
		final String SQL = "INSERT INTO types(description, username, createddate, likeamount, dislikeamount,replyamount,replyto,articleid) VALUES(?,?,?,?,?,?,?,?);";
		try {
			PreparedStatement pstmt = cnn.prepareStatement(SQL);
			pstmt.setString(1, comment.getCommentDescription());
			pstmt.setString(2, comment.getUsername());
			pstmt.setDate(3, comment.getCreateDate());
			pstmt.setInt(4, comment.getLikeAmount());
			pstmt.setInt(5, comment.getDislikeAmount());
			pstmt.setInt(6, comment.getReplyAmount());
			pstmt.setInt(7, comment.getReplyTo());
			pstmt.setInt(8, comment.getArticleId());
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
