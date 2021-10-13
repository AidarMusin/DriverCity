package musin.aidar.DriverCity.connetDB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SetingsDB {

    protected final static String query = "SELECT * FROM user_project WHERE login = ? AND password = ? ;";
    protected final static String queryAll = "SELECT surname, name_pers, patronymic, city_name, car_name" +
            " FROM ((persons p INNER JOIN personcar pc ON p.id = pc.pers_id) " +
            " INNER JOIN car c ON pc.cars_id = c.car_id)" +
            " INNER JOIN city ON p.id_city = city.city_id" +
            " WHERE surname LIKE ? AND" +
            " name_pers LIKE ? AND" +
            " patronymic LIKE ? AND" +
            " city_name LIKE ? AND" +
            " car_name LIKE ? ; ";

    private static Connection connection;

    static {
        Properties pr = new Properties();
        File file = new File(".//resources//setingsDB.properties");

        try (FileInputStream fis = new FileInputStream(file)) {
            pr.load(fis);
            Class.forName(pr.getProperty("driverJdbs"));

            connection = DriverManager.getConnection(pr.getProperty("connectionUrl"), pr.getProperty("username"), pr.getProperty("password"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return connection;
    }

}
