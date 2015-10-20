package model.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Comment {

	private int commentId;
	private String commentDescription;
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]")
	private String username;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	@NotNull
	@NumberFormat(style = org.springframework.format.annotation.NumberFormat.Style.NUMBER)
	private int likeAmount;
	@NotNull
	@NumberFormat(style = org.springframework.format.annotation.NumberFormat.Style.NUMBER)
	private int dislikeAmount;
	@NotNull
	@NumberFormat(style = org.springframework.format.annotation.NumberFormat.Style.NUMBER)
	private int replyAmount;
	@NotNull
	@NumberFormat(style = org.springframework.format.annotation.NumberFormat.Style.NUMBER)
	private int replyTo;
	@NotNull
	@NumberFormat(style = org.springframework.format.annotation.NumberFormat.Style.NUMBER)
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
