package musin.aidar.DriverCity.connectDB;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import static musin.aidar.DriverCity.connectDB.SetingsDB.connection;
import static musin.aidar.DriverCity.connectDB.SetingsDB.query;


public class SearchUserInDB {

    public int findUserId(String loginUser, String passUser) throws ClassNotFoundException, SQLException {
        int resultsId = 0;

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, loginUser);
        preparedStatement.setString(2, passUser);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            resultsId = resultSet.getInt("id");
        }

        preparedStatement.close();

        return resultsId;
    }


    public boolean findUser(String loginUser, String passUser)  throws ClassNotFoundException, SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, loginUser);
        preparedStatement.setString(2, passUser);

        ResultSet resultSet = preparedStatement.executeQuery();
        boolean checkPerson = resultSet.next();

        preparedStatement.close();

        return checkPerson;
    }
}
