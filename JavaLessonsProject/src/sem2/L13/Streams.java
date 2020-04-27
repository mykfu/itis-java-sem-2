package sem2.L13;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    static Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

    static void print (Stream<?> stream) {
        System.out.println(stream.map(Object::toString).collect(Collectors.joining(", ", "[", "]\n")));
    }

    static int counter = 0;
    static void wasCalled() {
        counter++;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> stream = list.stream();

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamArray = Arrays.stream(arr);
        streamArray.forEach(System.out::println);
        Stream<String> streamArraySlice = Arrays.stream(arr, 1, arr.length);
        streamArraySlice.forEach(System.out::println);

        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").build();

        Stream<String> streamGenerated = Stream.generate(() -> "elem").limit(10);
        streamGenerated.forEach(System.out::println);

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 3).limit(10);
        print(streamIterated);

        IntStream intStream = IntStream.range(1, 3);
        intStream.forEach(System.out::println);

        Path path = Paths.get("src/sem2/dict_len4.txt");
        try {
            Stream<String> stream1 = Files.lines(path)
                    .filter(s -> s.substring(1, 2).equals("б"))
                    .skip(5)
                    .limit(50);
            print(stream1);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Stream<String> stream1 = Stream.of("el1", "el2", "el3");
        Stream<String> stream2 = Stream.of("el1", "el2", "el3");

        stream1.filter(s -> {
            wasCalled();
            return s.contains("2");
        });
        System.out.println("counter = " + counter);

        stream2.filter(s -> {
            wasCalled();
            return s.contains("2");
        })
        .map(String::toUpperCase)
        .forEach(System.out::println);
        System.out.println("counter2 = " + counter);

        Stream<String> stream3 = Stream.of("el1", "el2", "el3", "abc");
        stream3.flatMap(s -> Stream.of("New" + s, s))
                .forEach(System.out::println);

//        List<String> list1 = stream3.collect(Collectors.groupingBy(String::toString, Collectors.toList()));
//        System.out.println(list1);



    }
}
