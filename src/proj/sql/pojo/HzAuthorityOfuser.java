package sql.pojo;

public class HzAuthorityOfuser {
    private Long puid;

    private Short authority;

    private Long userId;

    public Long getPuid() {
        return puid;
    }

    public void setPuid(Long puid) {
        this.puid = puid;
    }

    public Short getAuthority() {
        return authority;
    }

    public void setAuthority(Short authority) {
        this.authority = authority;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}