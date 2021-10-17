package musin.aidar.DriverCity.connetDB;

import musin.aidar.DriverCity.myObject.Car;
import musin.aidar.DriverCity.myObject.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            String surnamePerson = rs.getString("surname");
            String namePerson = rs.getString("name_pers");
            String patrPerson = rs.getString("patronymic");
            String cityPerson = rs.getString("city_name");
            String carPerson = rs.getString("car_name");

            boolean check = personMap.entrySet().stream().anyMatch(x -> x.getKey().getId() == idPerson);

            if (!check || personMap.isEmpty()) {

                personMap.put(new Person(idPerson, surnamePerson, namePerson, patrPerson, cityPerson), Stream.of(new Car(carPerson)).collect(Collectors.toList()));

            } else {
                for (Map.Entry<Person, List<Car>> maps : personMap.entrySet()) {
                    Person pers = maps.getKey();
                    int personId = pers.getId();
                    List<Car> carsNew = maps.getValue();

                    if (personId == idPerson) {

                        carsNew.add(new Car(carPerson));
                        maps.setValue(carsNew);
                        break;
                    }
                }

            }

        }
        return personMap;
    }
}
