package sql.pojo;

public class HzConfigureCommon {
	/** 配置item的id */
	private String GaContext;
	/** 产品配置器的item，需要传入的puid */
	private String GrpRev;
	/** 配置族 */
	private String FamRev;
	/** 配置族下的配置值 */
	private String ValRev;
	/** 车型模型族 */
	private String SearchModelFamily__0;
	/** 车型模型，第二层 */
	private String Model__2;
	/** 车型的配置的puid */
	private String VariantRule_4;
	/** 车型配置名称 */
	private String pobject_name;
	/** 配置器的item_id，用于搜索配置的模型 */
	private String item_id;

	public String getGrpRev() {
		return GrpRev;
	}

	public void setGrpRev(String grpRev) {
		GrpRev = grpRev;
	}

	public String getGaContext() {
		return GaContext;
	}

	public void setGaContext(String gaContext) {
		GaContext = gaContext;
	}

	public String getFamRev() {
		return FamRev;
	}

	public void setFamRev(String famRev) {
		FamRev = famRev;
	}

	public String getValRev() {
		return ValRev;
	}

	public void setValRev(String valRev) {
		ValRev = valRev;
	}

	public String getSearchModelFamily__0() {
		return SearchModelFamily__0;
	}

	public void setSearchModelFamily__0(String searchModelFamily__0) {
		SearchModelFamily__0 = searchModelFamily__0;
	}

	public String getModel__2() {
		return Model__2;
	}

	public void setModel__2(String model__2) {
		Model__2 = model__2;
	}

	public String getVariantRule_4() {
		return VariantRule_4;
	}

	public void setVariantRule_4(String variantRule_4) {
		VariantRule_4 = variantRule_4;
	}

	public String getPobject_name() {
		return pobject_name;
	}

	public void setPobject_name(String pobject_name) {
		this.pobject_name = pobject_name;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

}
