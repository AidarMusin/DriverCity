package musin.aidar.DriverCity.connetDB;

public class SetingsDB {
    protected static String userName = "FTlIGzTWEp";
    protected static String passw = "qmhs6Ylyb5";
    protected static String connectionUrl = "jdbc:mysql://remotemysql.com:3306/FTlIGzTWEp";
    protected final static String query = "SELECT * FROM user_project WHERE login = ? AND password = ? ;";
    protected final static String queryAll = "SELECT surname, name_pers, patronymic, city_name, car_name" +
            " FROM ((persons p INNER JOIN personcar pc ON p.id = pc.pers_id)" +
            " INNER JOIN car c ON pc.cars_id = c.car_id)" +
            " INNER JOIN city ON p.id_city = city.city_id" +
            " WHERE surname LIKE ? AND" +
            " name_pers LIKE ? AND" +
            " patronymic LIKE ? AND" +
            " city_name LIKE ? AND" +
            " car_name LIKE ? ; ";

}
