package sem2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class L9 {

}


class Person {
    enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String email;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!obj.getClass().equals(this.getClass())) return false;
        Person p = (Person) obj;
        return p.email.equals(this.email);
    }
    // person1.equals(person1) == true
    // person1.equals(person2) <==> person2.equals(person1)
    // person1.equals(person2) /\  person2.equals(person3) <==> person1.equals(person3)

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
    // person.hashCode() == person.hashCode()
    // person1.equals(person2) => person1.hashCode() == person2.hashCode()

    public Person(String name, LocalDate birthday, Sex gender, String email) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return birthday.until(LocalDate.now()).getYears();
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + getAge() +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }

    public void print() {
        System.out.println(toString());
    }

    public static List<Person> createRoster() {

        List<Person> roster = new ArrayList<>();
        roster.add(
                new Person(
                        "Fred",
                        LocalDate.of(1980, 6, 20),
                        Person.Sex.MALE,
                        "fred@example.com"));
        roster.add(
                new Person(
                        "Jane",
                        LocalDate.of(1990, 7, 15),
                        Person.Sex.FEMALE, "jane@example.com"));
        roster.add(
                new Person(
                        "George",
                        LocalDate.of(1991, 8, 13),
                        Person.Sex.MALE, "george@example.com"));
        roster.add(
                new Person(
                        "Bob",
                        LocalDate.of(2000, 9, 12),
                        Person.Sex.MALE, "bob@example.com"));

        return roster;
    }

}


class Calc {
    public double sqrt(double x) {
        if (x < 0) throw new IllegalArgumentException();
        return Math.sqrt(x);
    }


    public int sum(int a, int b) {
        return a + b;
    }


}


class Lists {
    public static void addStars(List<String> list) {
        for (int i = 1; i <= list.size(); i += 2) {
            list.add(i, "*");
        }
    }

    public static void removeStars(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).equals("*")) throw new IllegalArgumentException("Не верный список.");
            list.remove(i);
        }
    }

    public static <T> List<T> intersect(List<T> list1, List<T> list2) {
        List<T> newlist = new ArrayList<>();
        for (T t1 : list1) {
            for (T t2 : list2) {
                if (t1.equals(t2)) {
                    newlist.add(t1);
                }
            }
        }
        return newlist;
    }

}
