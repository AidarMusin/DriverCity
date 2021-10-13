package musin.aidar.DriverCity.authorization;

public class UserProject {
    private final String userProjectName;
    private final String userProjectPass;
    private int userProjectId;

    public UserProject(String userName, String userProjectPass) {
        this.userProjectName = userName;
        this.userProjectPass = userProjectPass;

    }

    public String getUserName() {
        return userProjectName;
    }

    public int getUserProjectId() {
        return userProjectId;
    }

    public void setUserProjectId(int userProjectId) {
        this.userProjectId = userProjectId;
    }
}


