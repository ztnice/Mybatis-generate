package sql.pojo;

import java.util.Date;

public class HzReleaseRecord {
    private String recordCode;

    private String releaseType;

    private String oaProcessNum;

    private Date dataReleaseDate;

    private String releaseApplicant;

    private Long suppliersId;

    private String suppliersName;

    private String suppliersCode;

    private String outCnpyAccepter;

    private String outCpnyEmail;

    private String inPostUserName;

    private String inPostUserPhone;

    private String inPostUserEmail;

    private String inPostUserDept;

    private String releaseApplPhone;

    private String releaseApplEmail;

    private String releasApplDept;

    private String proManagerSugge;

    private String proInspectorSugge;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode == null ? null : recordCode.trim();
    }

    public String getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(String releaseType) {
        this.releaseType = releaseType;
    }

    public String getOaProcessNum() {
        return oaProcessNum;
    }

    public void setOaProcessNum(String oaProcessNum) {
        this.oaProcessNum = oaProcessNum == null ? null : oaProcessNum.trim();
    }

    public Date getDataReleaseDate() {
        return dataReleaseDate;
    }

    public void setDataReleaseDate(Date dataReleaseDate) {
        this.dataReleaseDate = dataReleaseDate;
    }

    public String getReleaseApplicant() {
        return releaseApplicant;
    }

    public void setReleaseApplicant(String releaseApplicant) {
        this.releaseApplicant = releaseApplicant;
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
        this.suppliersName = suppliersName;
    }

    public String getSuppliersCode() {
        return suppliersCode;
    }

    public void setSuppliersCode(String suppliersCode) {
        this.suppliersCode = suppliersCode == null ? null : suppliersCode.trim();
    }

    public String getOutCnpyAccepter() {
        return outCnpyAccepter;
    }

    public void setOutCnpyAccepter(String outCnpyAccepter) {
        this.outCnpyAccepter = outCnpyAccepter;
    }

    public String getOutCpnyEmail() {
        return outCpnyEmail;
    }

    public void setOutCpnyEmail(String outCpnyEmail) {
        this.outCpnyEmail = outCpnyEmail == null ? null : outCpnyEmail.trim();
    }

    public String getInPostUserName() {
        return inPostUserName;
    }

    public void setInPostUserName(String inPostUserName) {
        this.inPostUserName = inPostUserName;
    }

    public String getInPostUserPhone() {
        return inPostUserPhone;
    }

    public void setInPostUserPhone(String inPostUserPhone) {
        this.inPostUserPhone = inPostUserPhone == null ? null : inPostUserPhone.trim();
    }

    public String getInPostUserEmail() {
        return inPostUserEmail;
    }

    public void setInPostUserEmail(String inPostUserEmail) {
        this.inPostUserEmail = inPostUserEmail == null ? null : inPostUserEmail.trim();
    }

    public String getInPostUserDept() {
        return inPostUserDept;
    }

    public void setInPostUserDept(String inPostUserDept) {
        this.inPostUserDept = inPostUserDept;
    }

    public String getReleaseApplPhone() {
        return releaseApplPhone;
    }

    public void setReleaseApplPhone(String releaseApplPhone) {
        this.releaseApplPhone = releaseApplPhone;
    }

    public String getReleaseApplEmail() {
        return releaseApplEmail;
    }

    public void setReleaseApplEmail(String releaseApplEmail) {
        this.releaseApplEmail = releaseApplEmail;
    }

    public String getReleasApplDept() {
        return releasApplDept;
    }

    public void setReleasApplDept(String releasApplDept) {
        this.releasApplDept = releasApplDept;
    }

    public String getProManagerSugge() {
        return proManagerSugge;
    }

    public void setProManagerSugge(String proManagerSugge) {
        this.proManagerSugge = proManagerSugge;
    }

    public String getProInspectorSugge() {
        return proInspectorSugge;
    }

    public void setProInspectorSugge(String proInspectorSugge) {
        this.proInspectorSugge = proInspectorSugge;
    }
}