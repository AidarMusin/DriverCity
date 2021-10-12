package musin.aidar.DriverCity.connetDB;

public class SetingsDB {
    protected static String userName = "FTlIGzTWEp";
    protected static String passw = "qmhs6Ylyb5";
    protected static String connectionUrl = "jdbc:mysql://remotemysql.com:3306/FTlIGzTWEp";
    protected final static String query = "SELECT * FROM user_project WHERE login = ? AND password = ? ;";
}
