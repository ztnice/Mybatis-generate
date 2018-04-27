package sql.pojo;

public class UserAuthorization {
    private Short authorizationId;

    private Short authorization;

    private String authorizationName;

    public Short getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(Short authorizationId) {
        this.authorizationId = authorizationId;
    }

    public Short getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Short authorization) {
        this.authorization = authorization;
    }

    public String getAuthorizationName() {
        return authorizationName;
    }

    public void setAuthorizationName(String authorizationName) {
        this.authorizationName = authorizationName == null ? null : authorizationName.trim();
    }
}