package sem2.L13;

import sem2.Consumer;

import java.io.BufferedReader;
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

