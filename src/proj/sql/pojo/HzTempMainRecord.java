package sql.pojo;

public class HzTempMainRecord {
    private String processNum;

    private String appDept;

    private String vehCode;

    private String applicant;

    private String applicantEmail;

    private String applicantPhone;

    private String provideType;

    private String inAccepter;

    private String inDept;

    private String outCpnyName;

    private String outCpnyCode;

    private String outCpnyAccepter;

    private String outCpnyEmail;

    private String proManagerSugge;

    private String proInspectorSugge;

    public String getProcessNum() {
        return processNum;
    }

    public void setProcessNum(String processNum) {
        this.processNum = processNum;
    }

    public String getAppDept() {
        return appDept;
    }

    public void setAppDept(String appDept) {
        this.appDept = appDept;
    }

    public String getVehCode() {
        return vehCode;
    }

    public void setVehCode(String vehCode) {
        this.vehCode = vehCode;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail == null ? null : applicantEmail.trim();
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone == null ? null : applicantPhone.trim();
    }

    public String getProvideType() {
        return provideType;
    }

    public void setProvideType(String provideType) {
        this.provideType = provideType;
    }

    public String getInAccepter() {
        return inAccepter;
    }

    public void setInAccepter(String inAccepter) {
        this.inAccepter = inAccepter;
    }

    public String getInDept() {
        return inDept;
    }

    public void setInDept(String inDept) {
        this.inDept = inDept;
    }

    public String getOutCpnyName() {
        return outCpnyName;
    }

    public void setOutCpnyName(String outCpnyName) {
        this.outCpnyName = outCpnyName;
    }

    public String getOutCpnyCode() {
        return outCpnyCode;
    }

    public void setOutCpnyCode(String outCpnyCode) {
        this.outCpnyCode = outCpnyCode == null ? null : outCpnyCode.trim();
    }

    public String getOutCpnyAccepter() {
        return outCpnyAccepter;
    }

    public void setOutCpnyAccepter(String outCpnyAccepter) {
        this.outCpnyAccepter = outCpnyAccepter;
    }

    public String getOutCpnyEmail() {
        return outCpnyEmail;
    }

    public void setOutCpnyEmail(String outCpnyEmail) {
        this.outCpnyEmail = outCpnyEmail == null ? null : outCpnyEmail.trim();
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