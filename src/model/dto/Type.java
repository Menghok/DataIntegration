package model.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Type {

	private int typeId;
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z]")
	private String typeName;
	
	public Type() {}
	
	public Type(int typeId, String typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	

}
