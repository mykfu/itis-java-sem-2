package sem2.L13;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsSecond {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("src/sem2/L13/MOCK_DATA.csv");
        BufferedReader reader = Files.newBufferedReader(path);
        List<String> list = reader.lines().collect(Collectors.toList());

        list.stream().skip(1).map(s -> s.split(",", -2)).limit(200)
//                .map(strings -> new Consumer(strings));
                .map(Consumer::new)
//                .filter(consumer -> consumer.getAge() < 60 && consumer.getAge() >= 23)
//                .sorted((o1, o2) -> {
//                    if (o1.getAge() == o2.getAge()) {
//                        return (int) (o2.getSalary() - o1.getSalary());
//                    }
//                    return o2.getAge() - o1.getAge();
//                })
//                .sorted(Comparator.comparingInt(Consumer::getAge).thenComparingDouble(Consumer::getSalary).reversed())
//                .distinct()
                .filter(distinctByKey(Consumer::getCity))
                .forEach(System.out::println);


        Map<String, List<Consumer>> collect = list.stream().skip(1).map(s -> s.split(",", -2)).limit(10)
                .map(Consumer::new)
                .collect(Collectors.groupingBy(Consumer::getCity));
        for (String s : collect.keySet()) {
            System.out.printf("%s:%n%s%n%n", s, collect.get(s));
        }

        System.out.println(list.stream().skip(1).map(s -> s.split(",", -2)).limit(10)
                .map(Consumer::new)
                .mapToDouble(Consumer::getSalary)
                .summaryStatistics()
                .toString());

//        System.out.println();
//        list.stream().skip(1).map(s -> s.split(",", -2)).limit(10)
//                .map(Consumer::new)
//                .takeWhile(consumer -> consumer.getAge() < 60)
//                .forEach(System.out::println);
//
//        System.out.println();
//        System.out.println();
//
//        list.stream().skip(1).map(s -> s.split(",", -2)).limit(10)
//                .map(Consumer::new)
//                .dropWhile(consumer -> consumer.getAge() < 60)
//                .forEach(System.out::println);

    }

    static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new HashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

class Consumer {
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