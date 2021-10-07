package musin.aidar.DriverCity.connetDB;

import musin.aidar.DriverCity.authorization.UserProject;

import java.sql.*;

import static musin.aidar.DriverCity.connetDB.SetingsDB.*;

public class SearchUserInDB {


    public int findUserId(UserProject userProject) throws ClassNotFoundException {
        int resultsId = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, passw)) {
            Statement statement = connection.createStatement();

            String qwery = "SELECT id,login, password  FROM  user WHERE login LIKE '" + userProject.getUserName() + "'" +
                    " AND user.password LIKE '" + userProject.getUserProjectPass() + "';";
            ResultSet rs = statement.executeQuery(qwery);

            while (rs.next()) {
                resultsId = rs.getInt("id");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultsId;
    }

}
