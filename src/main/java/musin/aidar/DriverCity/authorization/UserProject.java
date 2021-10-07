package musin.aidar.DriverCity.authorization;

public class UserProject {
    private final String userProjectName;
    private final String userProjectPass;
    private String userProjectId;

    public UserProject(String userName, String userProjectPass) {
        this.userProjectName = userName;
        this.userProjectPass = userProjectPass;

    }

    public String getUserName() {
        return userProjectName;
    }

    public String getUserProjectPass() {
        return userProjectPass;
    }

    public String getUserProjectId() {
        return userProjectId;
    }

    public void setUserProjectId(int userProjectId) {
        this.userProjectId = "" + userProjectId;
    }
}


