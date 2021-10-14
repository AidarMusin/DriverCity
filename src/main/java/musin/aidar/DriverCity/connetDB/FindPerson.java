package musin.aidar.DriverCity.connetDB;

import musin.aidar.DriverCity.myObject.Car;
import musin.aidar.DriverCity.myObject.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static musin.aidar.DriverCity.connetDB.SetingsDB.connection;
import static musin.aidar.DriverCity.connetDB.SetingsDB.queryAll;

public class FindPerson {

    public Map<Person, List<Car>> findPersonInDB(String surname, String name, String patronymic, String city, String carName) throws ClassNotFoundException, SQLException {

        Map<Person, List<Car>> personMap = new HashMap<Person, List<Car>>();

        PreparedStatement preparedStatement = connection.prepareStatement(queryAll);
        preparedStatement.setString(1, surname);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, patronymic);
        preparedStatement.setString(4, city);
        preparedStatement.setString(5, carName);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int idPerson = rs.getInt("id");
            Person person;

            personMap.containsKey(person.getId());


            String surnamePerson = rs.getString("surname");
            String namePerson = rs.getString("name_pers");
            String patrPerson = rs.getString("patronymic");
            String cityPerson = rs.getString("city_name");

            Car carPerson = new Car(rs.getString("car_name"));

            person = new Person(idPerson, surnamePerson, namePerson, patrPerson, cityPerson
                    List < Car > cars = new ArrayList<>();
            cars.add(carPerson);

            personMap.put(person, cars);


        }
        return personMap;
    }
}
