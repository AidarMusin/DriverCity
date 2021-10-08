package musin.aidar.DriverCity.connetDB;

import musin.aidar.DriverCity.setingsPJ.Person;

import java.sql.*;
import java.util.ArrayList;

import static musin.aidar.DriverCity.connetDB.SetingsDB.*;

public class FindPerson {

    public ArrayList<Person> findPersonInDB(String surname, String name, String patronymic, String city, String car) throws ClassNotFoundException {
        ArrayList<Person> personList = new ArrayList<Person>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, passw)) {
            Statement statement = connection.createStatement();

            String query = "SELECT surname, name_pers, patronymic, city_name, car_name" +
                    " FROM ((persons p INNER JOIN personcar pc ON p.id = pc.pers_id)" +
                    " INNER JOIN car c ON pc.cars_id = c.car_id)" +
                    " INNER JOIN city ON p.id_city = city.city_id" +
                    " WHERE surname LIKE '" + surname + "' AND" +
                    " name_pers LIKE '" + name + "' AND" +
                    " patronymic LIKE '" + patronymic + "' AND" +
                    " city_name LIKE '" + city + "' AND" +
                    " car_name LIKE '" + car + "';  ";


            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String surnamePeople = rs.getString("surname");
                String namePeople = rs.getString("name_pers");
                String patrPeople = rs.getString("patronymic");
                String cityPeople = rs.getString("city_name");
                String carPeople = rs.getString("car_name");

                boolean flag = true;
                ArrayList<String> cars = new ArrayList<>();

                for (Person pl : personList) {
                    if (pl.getSurname().equals(surnamePeople) && pl.getName().equals(namePeople) && pl.getPatronymic().equals(patrPeople)) {
                        pl.addCar(carPeople);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cars.add(carPeople);
                    personList.add(new Person(surnamePeople, namePeople, patrPeople, cityPeople, cars));
                }
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return personList;
    }
}
