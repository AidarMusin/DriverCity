package musin.aidar.DriverCity.setingsPJ;

import java.util.ArrayList;

public class People {
    private String surname;
    private String name;
    private String patronymic;
    private String city;
    private ArrayList<String> cars;

    public People (String surname, String name, String patronymic, String city, ArrayList<String> cars) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.city = city;
        this.cars = cars;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getCity() {
        return city;
    }

    public ArrayList<String> getCars() {
        return cars;
    }

    public void addCar (String car) {
        this.cars.add(car);
    }

    public String getValueCars() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.size(); i++ ) {
            sb.append(cars.get(i));
            if (i != cars.size()-1)
                sb.append(", ");
        }
        return sb.toString().trim();
    }


}
