package sql.pojo;

public class HzTempItemRecord {
    private Long id;

    private Object belProcessNum;

    private String itemId;

    private String itemName;

    private String itemrevision;

    private Short catiaDigifax;

    private Short jtDigifax;

    private Short cgrDigifax;

    private Short catiaBlueprint;

    private Short cadBlueprint;

    private Short others;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getBelProcessNum() {
        return belProcessNum;
    }

    public void setBelProcessNum(Object belProcessNum) {
        this.belProcessNum = belProcessNum;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemrevision() {
        return itemrevision;
    }

    public void setItemrevision(String itemrevision) {
        this.itemrevision = itemrevision == null ? null : itemrevision.trim();
    }

    public Short getCatiaDigifax() {
        return catiaDigifax;
    }

    public void setCatiaDigifax(Short catiaDigifax) {
        this.catiaDigifax = catiaDigifax;
    }

    public Short getJtDigifax() {
        return jtDigifax;
    }

    public void setJtDigifax(Short jtDigifax) {
        this.jtDigifax = jtDigifax;
    }

    public Short getCgrDigifax() {
        return cgrDigifax;
    }

    public void setCgrDigifax(Short cgrDigifax) {
        this.cgrDigifax = cgrDigifax;
    }

    public Short getCatiaBlueprint() {
        return catiaBlueprint;
    }

    public void setCatiaBlueprint(Short catiaBlueprint) {
        this.catiaBlueprint = catiaBlueprint;
    }

    public Short getCadBlueprint() {
        return cadBlueprint;
    }

    public void setCadBlueprint(Short cadBlueprint) {
        this.cadBlueprint = cadBlueprint;
    }

    public Short getOthers() {
        return others;
    }

    public void setOthers(Short others) {
        this.others = others;
    }
}