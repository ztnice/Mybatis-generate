package sql.pojo;

public class HzBom2YEntity {
	private String puid;

	private String pBomDigifaxId;

	private String pLineIndex;

	private Short pBomLineIsHas;

	private String pBomLinePuid;

	private String pBomLineName;

	private byte[] pBomLineBlock;

	public String getPuid() {
		return puid;
	}

	public void setPuid(String puid) {
		this.puid = puid == null ? null : puid.trim();
	}

	public String getpBomDigifaxId() {
		return pBomDigifaxId;
	}

	public void setpBomDigifaxId(String pBomDigifaxId) {
		this.pBomDigifaxId = pBomDigifaxId == null ? null : pBomDigifaxId.trim();
	}

	public String getpLineIndex() {
		return pLineIndex;
	}

	public void setpLineIndex(String pLineIndex) {
		this.pLineIndex = pLineIndex == null ? null : pLineIndex.trim();
	}

	public Short getpBomLineIsHas() {
		return pBomLineIsHas;
	}

	public void setpBomLineIsHas(Short pBomLineIsHas) {
		this.pBomLineIsHas = pBomLineIsHas;
	}

	public String getpBomLinePuid() {
		return pBomLinePuid;
	}

	public void setpBomLinePuid(String pBomLinePuid) {
		this.pBomLinePuid = pBomLinePuid == null ? null : pBomLinePuid.trim();
	}

	public String getpBomLineName() {
		return pBomLineName;
	}

	public void setpBomLineName(String pBomLineName) {
		this.pBomLineName = pBomLineName;
	}

	public byte[] getpBomLineBlock() {
		return pBomLineBlock;
	}

	public void setpBomLineBlock(byte[] pBomLineBlock) {
		this.pBomLineBlock = pBomLineBlock;
	}

	public void setHasChilren(boolean isHas) {
		pBomLineIsHas = (short) (isHas ? 1 : 0);
	}
}