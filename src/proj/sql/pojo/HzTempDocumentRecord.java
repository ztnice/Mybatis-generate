package sql.pojo;

public class HzTempDocumentRecord {
    private Long id;

    private Object belProcessNum;

    private String itemId;

    private String itemName;

    private String itemrevision;

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
}