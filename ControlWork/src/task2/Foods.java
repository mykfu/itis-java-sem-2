package task2;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Foods {

    public static Map<String, Set<String>> favoriteFoods(Map<String, Map<String, Double>> map, double rating) {
        Map<String, Set<String>> result = new TreeMap<>();
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

        Map<String, Double> erik = new TreeMap<>();
        erik.put("chicken strips", 4.3);
        erik.put("cranberry sauce", 4.2);

        Map<String, Double> yael = new TreeMap<>();
        yael.put("lettuce", 2.4);

        Map<String, Double> ken = new TreeMap<>();

        ratings.put("Porter", porter);
        ratings.put("Erik", erik);
        ratings.put("Yael", yael);
        ratings.put("Ken", ken);

        System.out.println(ratings);

        System.out.println(favoriteFoods(ratings, 4.3));
    }
}
