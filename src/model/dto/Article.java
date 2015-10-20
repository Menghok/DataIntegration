package model.dto;

import java.sql.Date;

public class Article {

	private int articleId;
	private String articleTitle;
	private String articleThumbnail;
	private String articleDescription;
	private Date createDate;
	private Date modifierDate;
	private int likeAmount;
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
