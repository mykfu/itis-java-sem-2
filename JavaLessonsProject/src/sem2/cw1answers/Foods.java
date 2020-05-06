package sem2.cw1answers;

import java.util.*;

public class Foods {
    public static Map<String, Set<String>> favoriteFoods(Map<String, Map<String, Double>> map, double rating) {
//        HashMap hashMap;  // shuffled
//        TreeMap treeMap;  // sorted
//        LinkedHashMap linkedHashMap; // по порядку включения

        // значения
//        for (Map<String, Double> value : map.values()) {
//
//        }
        // пара ключ => значение
//        for (Map.Entry<String, Map<String, Double>> stringMapEntry : map.entrySet()) {
//
//        }
        Map<String, Set<String>> result = new TreeMap<>();

        // ключи
        for (String person : map.keySet()) {
            result.put(person, new TreeSet<>());

            Map<String, Double> ratingsFor = map.get(person);
            for (String food : ratingsFor.keySet()) {
                if (ratingsFor.get(food) >= rating) {
                    result.get(person).add(food);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, Map<String, Double>> ratings = new TreeMap<>();
        Map<String, Double> porter = new TreeMap<>();
        porter.put("pie", 5.0);
        porter.put("ice cream", 5.0);
        porter.put("mushrooms", 0.0);
        ratings.put("Porter", porter);

        Map<String, Double> erik = new TreeMap<>();
        erik.put("chicken strips", 4.3);
        erik.put("cranberry sauce", 4.2);
        ratings.put("Erik", erik);

        Map<String, Double> yael = new TreeMap<>();
        yael.put("lettuce", 2.4);
        ratings.put("Yael", yael);

        Map<String, Double> ken = new TreeMap<>();
        ratings.put("Ken", ken);

        System.out.println(ratings);

        System.out.println(favoriteFoods(ratings, 4.3));
    }
}
