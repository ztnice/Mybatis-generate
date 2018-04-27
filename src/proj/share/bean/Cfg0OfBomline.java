package share.bean;

/***
 * bom行和产品配置器选项值对应关系的bean
 * 
 * @author Administrator
 *
 */
public class Cfg0OfBomline {
	/** 选项族 */
	private String cfg0FamilyName;
	/** 传到DB的bom行id */
	private String bomlinePuid;
	/** 传到DB的选项值得id，与2Y层一一对应 */
	private String cfg0Puid;
	/** 选项值得名称 */
	private String cfg0Name;
	/** 对应的bom行名 */
	private String bomlineName;
	/*** 数模层的数据库puid */
	private String bomDigifaxId;
	/**对应的配置值的puid*/
	private String toCfg0Puid;
	public String getBomlinePuid() {
		return bomlinePuid;
	}

	public void setBomlinePuid(String bomlinePuid) {
		this.bomlinePuid = bomlinePuid;
	}

	public String getCfg0Puid() {
		return cfg0Puid;
	}

	public void setCfg0Puid(String cfg0Puid) {
		this.cfg0Puid = cfg0Puid;
	}

	public String getCfg0Name() {
		return cfg0Name;
	}

	public void setCfg0Name(String cfg0Name) {
		this.cfg0Name = cfg0Name;
	}

	public String getBomlineName() {
		return bomlineName;
	}

	public void setBomlineName(String bomlineName) {
		this.bomlineName = bomlineName;
	}

	public String getCfg0FamilyName() {
		return cfg0FamilyName;
	}

	public void setCfg0FamilyName(String cfg0FamilyName) {
		this.cfg0FamilyName = cfg0FamilyName;
	}

	public String getBomDigifaxId() {
		return bomDigifaxId;
	}

	public void setBomDigifaxId(String bomDigifaxId) {
		this.bomDigifaxId = bomDigifaxId;
	}

	public String getToCfg0Puid() {
		return toCfg0Puid;
	}

	public void setToCfg0Puid(String toCfg0Puid) {
		this.toCfg0Puid = toCfg0Puid;
	}

}
