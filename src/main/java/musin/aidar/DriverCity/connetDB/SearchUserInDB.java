package musin.aidar.DriverCity.connetDB;

import musin.aidar.DriverCity.authorization.UserProject;
import java.sql.*;
import static musin.aidar.DriverCity.connetDB.SetingsDB.*;

public class SearchUserInDB {

    public int findUserId(String loginUser, String passUser) throws ClassNotFoundException {
        int resultsId = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, passw)) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT id FROM  user_project " +
                    "WHERE login ='" + loginUser +
                    "' AND password ='" + passUser + "';");

            while (resultSet.next()) {
                resultsId = resultSet.getInt("id");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return resultsId;
    }


    public boolean findUser(String loginUser, String passUser)  throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        boolean checkUserProject = false;

        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, passw)) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT id FROM  user_project " +
                    "WHERE login ='" + loginUser +
                    "' AND password ='" + passUser + "';");
            checkUserProject = resultSet.next();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return checkUserProject;
    }
}
