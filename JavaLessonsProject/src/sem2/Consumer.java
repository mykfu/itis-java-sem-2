package sem2;

import java.util.Objects;

public class Consumer {
    private long id;
    private String first_name;
    private String last_name;
    private String gender;
    private int age;
    private String city;
    private String email;
    private double salary;

    public Consumer() {
    }

    public Consumer(long id, String first_name, String last_name, String gender, int age, String city, String email, double salary) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.email = email;
        this.salary = salary;
    }

    public Consumer(String... strings) {
        if (strings.length != 8) {
            throw new IllegalArgumentException();
        }
        this.id = Long.parseLong(strings[0]);
        this.first_name = strings[1];
        this.last_name = strings[2];
        this.gender = strings[3];
        this.age = Integer.parseInt(strings[4]);
        this.city = strings[5];
        this.email = strings[6];
        assert strings[7] != null;
        this.salary = strings[7].isEmpty() ? 0.0 : Double.parseDouble(strings[7]);
    }


    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumer consumer = (Consumer) o;
        return id == consumer.id &&
                email.equals(consumer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}
