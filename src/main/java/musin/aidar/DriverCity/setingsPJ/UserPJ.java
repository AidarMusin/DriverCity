package musin.aidar.DriverCity.setingsPJ;

public class UserPJ {
    private String userName;
    private String userPass;
    private String userId;

    public UserPJ(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;

    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = "" + userId;
    }
}


