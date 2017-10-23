package coffee_project.dto;

public class Code {
	
	private String codeId;
	private String codeName;
	
	public Code() {}
	
	
	public Code(String codeId, String codeName) {
		this.codeId = codeId;
		this.codeName = codeName;
	}


	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	@Override
	public String toString() {
		return String.format("%s %s", codeId, codeName);
	}


	public Object[] toArray() {
		return new Object[]{codeId,codeName};
	}
	
}
