package model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Company {
	
	private int companyId;
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]")
	private String companyName;
	private String logo;
	@NotNull
	private int typeId;

	public Company() {}
	
	public Company(int companyId, String companyName, String logo, int typeId) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.logo = logo;
		this.typeId = typeId;
	}
	
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

}
