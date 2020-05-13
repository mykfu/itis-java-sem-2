package task2;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class FoodsTest {

    private Map<String, Map<String, Double>> stub;

    @Before
    public void setUp() throws Exception {
        stub = new TreeMap<>();
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

        stub.put("Porter", porter);
        stub.put("Erik", erik);
        stub.put("Yael", yael);
        stub.put("Ken", ken);
    }

    @Test
    public void favoriteFoodsRateMoreThanZero() {
        Map<String, Set<String>> expected = new TreeMap<>();
        Set<String> porter = new TreeSet<>();
        porter.add("pie");
        porter.add("ice cream");
        Set<String> erik = new TreeSet<>();
        erik.add("chicken strips");
        Set<String> yael = new TreeSet<>();
        Set<String> ken = new TreeSet<>();
        expected.put("Porter", porter);
        expected.put("Erik", erik);
        expected.put("Yael", yael);
        expected.put("Ken", ken);
        System.out.println("FoodsTest.favoriteFoods");
        System.out.println("stub = " + stub);
        final double rating = 4.3;
        System.out.println("expected = " + expected + " for rating over " + rating);
        final Map<String, Set<String>> actual = Foods.favoriteFoods(stub, rating);
        System.out.println("  actual = " + actual);
        assertEquals(expected, actual);
    }
    @Test
    public void favoriteFoodsRateZero() {
        Map<String, Set<String>> expected = new TreeMap<>();
        Set<String> porter = new TreeSet<>();
        porter.add("pie");
        porter.add("ice cream");
        porter.add("mushrooms");
        Set<String> erik = new TreeSet<>();
        erik.add("chicken strips");
        erik.add("cranberry sauce");
        Set<String> yael = new TreeSet<>();
        yael.add("lettuce");
        Set<String> ken = new TreeSet<>();
        expected.put("Porter", porter);
        expected.put("Erik", erik);
        expected.put("Yael", yael);
        expected.put("Ken", ken);
        System.out.println("FoodsTest.favoriteFoods");
        System.out.println("stub = " + stub);
        final double rating = 0;
        System.out.println("expected = " + expected + " for rating over " + rating);
        final Map<String, Set<String>> actual = Foods.favoriteFoods(stub, rating);
        System.out.println("  actual = " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void favoriteFoodsLessZero() {
        Map<String, Set<String>> expected = new TreeMap<>();
        Set<String> porter = new TreeSet<>();
        porter.add("pie");
        porter.add("ice cream");
        porter.add("mushrooms");
        Set<String> erik = new TreeSet<>();
        erik.add("chicken strips");
        erik.add("cranberry sauce");
        Set<String> yael = new TreeSet<>();
        yael.add("lettuce");
        Set<String> ken = new TreeSet<>();
        expected.put("Porter", porter);
        expected.put("Erik", erik);
        expected.put("Yael", yael);
        expected.put("Ken", ken);


        System.out.println("FoodsTest.favoriteFoods");
        System.out.println("stub = " + stub);
        final double rating = -4.3;
        System.out.println("expected = " + expected + " for rating over " + rating);
        final Map<String, Set<String>> actual = Foods.favoriteFoods(stub, rating);
        System.out.println("  actual = " + actual);
        assertEquals(expected, actual);
    }
}