package musin.aidar.DriverCity.connectDB;

import musin.aidar.DriverCity.myObject.Car;
import musin.aidar.DriverCity.myObject.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static musin.aidar.DriverCity.connectDB.SettingsDB.connection;
import static musin.aidar.DriverCity.connectDB.SettingsDB.queryAll;

public class FindPerson {
    private static final Logger logger = LoggerFactory.getLogger(FindPerson.class);


    public Map<Person, List<Car>> findPersonInDB(List<String> personRequest) throws ClassNotFoundException, SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(queryAll);
        Map<Person, List<Car>> personMap = new HashMap<>();

        String plug = "%";
        int count = 0;
        while (count < 5) {
            preparedStatement.setString(count + 1, personRequest.get(count) + plug);
            count ++;


        }


        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            int idPerson = resultSet.getInt("id");
            String surnamePerson = resultSet.getString("surname");
            String namePerson = resultSet.getString("name_pers");
            String patrPerson = resultSet.getString("patronymic");
            String cityPerson = resultSet.getString("city_name");
            String carPerson = resultSet.getString("car_name");

            logger.info("query: - {}{}", surnamePerson, namePerson);
            addPersonInMap(personMap, new Person(idPerson, surnamePerson, namePerson, patrPerson, cityPerson), new Car(carPerson));
        }

        preparedStatement.close();
        return personMap;
    }


    private Map<Person,List<Car>> addPersonInMap (Map<Person,List<Car>> personMap, Person person, Car car) {
        boolean checkingPersonInMap = personMap.entrySet().stream().anyMatch(x -> x.getKey().getId() == person.getId());

        if (!checkingPersonInMap || personMap.isEmpty()) {
            personMap.put(person, Stream.of(car).collect(Collectors.toList()));

        } else {
            for (Map.Entry<Person, List<Car>> maps : personMap.entrySet()) {
                Person pers = maps.getKey();
                int personId = pers.getId();
                List<Car> carsNew = maps.getValue();

                if (personId == person.getId()) {
                    carsNew.add(car);
                    maps.setValue(carsNew);
                    break;
                }
            }
        }
        return personMap;
    }
}
