package model.dto;

import java.sql.Date;

public class Comment {

	private int commentId;
	private String commentDescription;
	private String username;
	private Date createDate;
	private int likeAmount;
	private int dislikeAmount;
	private int replyAmount;
	private int replyTo;
	private int articleId;
	
	public Comment() {}

	public Comment(int commentId, String commentDescription, 
			String username, Date createDate, int likeAmount, 
			int dislikeAmount, int replyAmount, int replyTo, 
			int articleId){
		this.commentId = commentId;
		this.commentDescription = commentDescription;
		this.username = username;
		this.createDate = createDate;
		this.likeAmount = likeAmount;
		this.dislikeAmount = dislikeAmount;
		this.replyAmount = replyAmount;
		this.replyTo = replyTo;
		this.articleId = articleId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getLikeAmount() {
		return likeAmount;
	}

	public void setLikeAmount(int likeAmount) {
		this.likeAmount = likeAmount;
	}

	public int getDislikeAmount() {
		return dislikeAmount;
	}

	public void setDislikeAmount(int dislikeAmount) {
		this.dislikeAmount = dislikeAmount;
	}

	public int getReplyAmount() {
		return replyAmount;
	}

	public void setReplyAmount(int replyAmount) {
		this.replyAmount = replyAmount;
	}

	public int getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(int replyTo) {
		this.replyTo = replyTo;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
}
