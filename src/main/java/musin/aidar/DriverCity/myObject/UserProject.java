package musin.aidar.DriverCity.myObject;

public class UserProject {
    private String userProjectName;
    private String userProjectPass;
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


