package musin.aidar.DriverCity.connectDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SettingsDB {
    protected static String userName;
    protected static String passw;
    protected static String connectionUrl;
    protected static String driverJdbc;

    protected final static String query = "SELECT * FROM user_project WHERE login = ? AND password = ? ;";
    protected final static String queryAll = "SELECT id, surname, name_pers, patronymic, city_name, car_name" +
            " FROM ((persons p INNER JOIN personcar pc ON p.id = pc.pers_id)" +
            " INNER JOIN car c ON pc.cars_id = c.car_id)" +
            " INNER JOIN city ON p.id_city = city.city_id" +
            " WHERE surname LIKE ? AND" +
            " name_pers LIKE ? AND" +
            " patronymic LIKE ? AND" +
            " city_name LIKE ? AND" +
            " car_name LIKE ? ; ";

    protected static Connection connection;
    private static final Logger logger = LoggerFactory.getLogger(SettingsDB.class);


    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream("settingsDB.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);

            userName = properties.getProperty("username");
            passw = properties.getProperty("password");
            connectionUrl = properties.getProperty("connectionUrl");
            driverJdbc = properties.getProperty("driverJdbs");

            Class.forName(driverJdbc);
            connection = DriverManager.getConnection(connectionUrl, userName, passw);

        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (SQLException sqlException) {
            logger.error(sqlException.getMessage(), sqlException);
        } catch (IOException ioException) {
            logger.error(ioException.getMessage(), ioException);
        }
    }
}
