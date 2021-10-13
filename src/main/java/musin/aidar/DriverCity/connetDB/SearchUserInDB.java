package musin.aidar.DriverCity.connetDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static musin.aidar.DriverCity.connetDB.SetingsDB.getConn;
import static musin.aidar.DriverCity.connetDB.SetingsDB.query;


public class SearchUserInDB {

    public int findUserId(String loginUser, String passUser) throws ClassNotFoundException, SQLException {
        int resultsId = 0;

        PreparedStatement preparedStatement = getConn().prepareStatement(query);
        preparedStatement.setString(1, loginUser);
        preparedStatement.setString(2, passUser);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            resultsId = resultSet.getInt("id");
        }

        preparedStatement.close();

        return resultsId;
    }


    public boolean findUser(String loginUser, String passUser) throws ClassNotFoundException, SQLException {

        PreparedStatement preparedStatement = getConn().prepareStatement(query);
        preparedStatement.setString(1, loginUser);
        preparedStatement.setString(2, passUser);

        ResultSet resultSet = preparedStatement.executeQuery();


        return resultSet.next();
    }
}
