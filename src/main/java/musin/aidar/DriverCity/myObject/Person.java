package musin.aidar.DriverCity.myObject;

public class Person {
    private final int id;
    private final String surname;
    private final String name;
    private final String patronymic;
    private final String city;

    public Person(int id, String surname, String name, String patronymic, String city) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

}
