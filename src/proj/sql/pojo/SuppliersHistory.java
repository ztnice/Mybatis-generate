package sql.pojo;

import java.util.Date;

public class SuppliersHistory {
    private Long historyId;

	private Long suppliersId;

	private String suppliersName;

	private String suppliersCode;

	private Date createDate;

	private String createUser;

	private Date altDate;

	private String altType;

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public Long getSuppliersId() {
		return suppliersId;
	}

	public void setSuppliersId(Long suppliersId) {
		this.suppliersId = suppliersId;
	}

	public String getSuppliersName() {
		return suppliersName;
	}

	public void setSuppliersName(String suppliersName) {
		this.suppliersName = suppliersName == null ? null : suppliersName.trim();
	}

	public String getSuppliersCode() {
		return suppliersCode;
	}

	public void setSuppliersCode(String suppliersCode) {
		this.suppliersCode = suppliersCode == null ? null : suppliersCode.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	public Date getAltDate() {
		return altDate;
	}

	public void setAltDate(Date altDate) {
		this.altDate = altDate;
	}

	public String getAltType() {
		return altType;
	}

	public void setAltType(String altType) {
		this.altType = altType == null ? null : altType.trim();
	}

}