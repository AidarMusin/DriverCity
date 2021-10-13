package musin.aidar.DriverCity.connetDB;

import musin.aidar.DriverCity.setingsPJ.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static musin.aidar.DriverCity.connetDB.SetingsDB.getConn;
import static musin.aidar.DriverCity.connetDB.SetingsDB.queryAll;

public class FindPerson {

    public ArrayList<Person> findPersonInDB(String surname, String name, String patronymic, String city, String car) throws ClassNotFoundException {
        ArrayList<Person> personList = new ArrayList<Person>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {

            PreparedStatement preparedStatement = getConn().prepareStatement(queryAll);
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, patronymic);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, car);


            ResultSet rs = preparedStatement.executeQuery();

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
