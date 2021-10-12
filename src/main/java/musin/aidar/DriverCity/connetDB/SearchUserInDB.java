package musin.aidar.DriverCity.connetDB;

import java.sql.*;

import static musin.aidar.DriverCity.connetDB.SetingsDB.*;


public class SearchUserInDB {

    public int findUserId(String loginUser, String passUser) throws ClassNotFoundException {
        int resultsId = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, passw)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, loginUser);
            preparedStatement.setString(2, passUser);

            ResultSet resultSet = preparedStatement.executeQuery();

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
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, loginUser);
            preparedStatement.setString(2, passUser);

            ResultSet resultSet = preparedStatement.executeQuery();
            checkUserProject = resultSet.next();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return checkUserProject;
    }
}
