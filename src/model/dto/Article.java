package model.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.NumberFormat;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Article {
	
	@NumberFormat(style = org.springframework.format.annotation.NumberFormat.Style.NUMBER)
	private int articleId;
	@NotEmpty
	private String articleTitle;
	private String articleThumbnail;
	private String articleDescription;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modifierDate;
	@NotNull
	@NumberFormat(style = org.springframework.format.annotation.NumberFormat.Style.NUMBER)
	private int likeAmount;
	@NotNull
	@NumberFormat(style = org.springframework.format.annotation.NumberFormat.Style.NUMBER)
	private int companyId;
	
	public Article() {}
	
	public Article(int articleId, String articleTitle, 
			String articleThumbnail, String articleDescription, 
			Date createDate, Date modifierDate, int likeAmount, 
			int companyId){
		this.articleId = articleId;
		this.articleTitle = articleTitle;
		this.articleThumbnail = articleThumbnail;
		this.articleDescription = articleDescription;
		this.createDate = createDate;
		this.modifierDate = modifierDate;
		this.likeAmount = likeAmount;
		this.companyId = companyId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleThumbnail() {
		return articleThumbnail;
	}

	public void setArticleThumbnail(String articleThumbnail) {
		this.articleThumbnail = articleThumbnail;
	}

	public String getArticleDescription() {
		return articleDescription;
	}

	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifierDate() {
		return modifierDate;
	}

	public void setModifierDate(Date modifierDate) {
		this.modifierDate = modifierDate;
	}

	public int getLikeAmount() {
		return likeAmount;
	}

	public void setLikeAmount(int likeAmount) {
		this.likeAmount = likeAmount;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

}
