package task3;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class TestLinkedIntList {
    LinkedIntList list1;
//    boolean reverse = true;
    boolean reverse = false;

    static LinkedIntList addAll(int[] array) {
        LinkedIntList list = new LinkedIntList();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    static int[] toArray(LinkedIntList list) throws NoSuchFieldException, IllegalAccessException {
        final Field front = LinkedIntList.class.getDeclaredField("front");
        front.setAccessible(true);
        ListNode current;
        try {
            current = (ListNode) front
                    .get(list);
        } catch (NullPointerException ex) {
            return new int[]{};
        }
        LinkedList<Integer> res = new LinkedList<>();

        while (current != null) {
            res.add((Integer) current.data);
            current = current.next;
        }
        return res.stream().mapToInt(value -> (int) value).toArray();
    }

    static LinkedIntList addAll(int[] array, boolean reverse) {
        if (!reverse) return addAll(array);
        LinkedIntList list = new LinkedIntList();
        for (int i = array.length - 1; i >= 0; i--) {
            list.add(array[i]);
        }
        return list;
    }

    @Before
    public void setUp() throws Exception {
        list1 = new LinkedIntList();
        for (int i = 1; i < 12; i++) {
            list1.add(i);
        }
    }

    @Test
    public void removeAlternatingEmpty() throws NoSuchFieldException, IllegalAccessException {
        LinkedIntList list = new LinkedIntList();
        System.out.println("TestLinkedIntList.removeAlternatingEmpty");
        System.out.println("list = " + list);
        final int[] expected1 = {};
        final int[] expected2 = {};
        System.out.println("list.removeAlternating() expected = " + Arrays.toString(expected1));
        final LinkedIntList actual = list.removeAlternating();
        System.out.println("list.removeAlternating() actual = " + Arrays.toString(toArray(actual)));
        System.out.println("list after remove expected = " + Arrays.toString(expected2));
        System.out.println("list after remove actual = " + Arrays.toString(toArray(list)));
        assertArrayEquals(expected1, toArray(actual));
        assertArrayEquals(expected2, toArray(list));
    }

    @Test
    public void removeAlternatingOne() throws NoSuchFieldException, IllegalAccessException {
        LinkedIntList list = new LinkedIntList();
        list.add(10);
        System.out.println("TestLinkedIntList.removeAlternatingOne");
        System.out.println("list = " + Arrays.toString(toArray(list)));
        final int[] expected1 = {};
        final int[] expected2 = {10};
        System.out.println("list.removeAlternating() expected = " + Arrays.toString(expected1));
        final LinkedIntList actual = list.removeAlternating();
        System.out.println("list.removeAlternating() actual = " + Arrays.toString(toArray(actual)));
        System.out.println("list after remove expected = " + Arrays.toString(expected2));
        System.out.println("list after remove actual = " + Arrays.toString(toArray(list)));
        assertArrayEquals(expected1, toArray(actual));
        assertArrayEquals(expected2, toArray(list));
    }

    @Test
    public void removeAlternatingTwo() throws NoSuchFieldException, IllegalAccessException {
        LinkedIntList list = new LinkedIntList();
        if (!reverse)
            list.add(10);
        list.add(20);
        if (reverse)
            list.add(10);
        final int[] expected1 = new int[]{10};
        final int[] expected2 = new int[]{20};
        System.out.println("TestLinkedIntList.removeAlternatingTwo");
        System.out.println("list = " + list);
        System.out.println("list.removeAlternating() expected = " + Arrays.toString(expected1));
        final LinkedIntList actual = list.removeAlternating();
        System.out.println("list.removeAlternating() actual = " + Arrays.toString(toArray(actual)));
        System.out.println("list after remove expected = " + Arrays.toString(expected2));
        System.out.println("list after remove actual = " + Arrays.toString(toArray(list)));
        assertArrayEquals(expected1, toArray(actual));
        assertArrayEquals(expected2, toArray(list));
    }

    @Test
    public void removeAlternatingOdd() throws NoSuchFieldException, IllegalAccessException {
        LinkedIntList list = addAll(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, reverse);
        final int[] expected1 = {1, 4, 5, 8, 9};
        final int[] expected2 = {2, 3, 6, 7, 10, 11};
        System.out.println("TestLinkedIntList.removeAlternatingOdd");
        System.out.println("list = " + Arrays.toString(toArray(list)));
        System.out.println("list.removeAlternating() expected = " + Arrays.toString(expected1));
        System.out.println("list after remove expected = " + Arrays.toString(expected2));
        final LinkedIntList actual = list.removeAlternating();
        System.out.println("list.removeAlternating() actual = " + Arrays.toString(toArray(actual)));
        System.out.println("list after remove actual = " + Arrays.toString(toArray(list)));
        assertArrayEquals(expected1, toArray(actual));
        assertArrayEquals(expected2, toArray(list));
    }

    @Test
    public void removeAlternatingEven() {
        LinkedIntList list = addAll(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, reverse);
        LinkedIntList expected1 = addAll(new int[]{1, 4, 5, 8, 9}, reverse);
        LinkedIntList expected2 = addAll(new int[]{2, 3, 6, 7, 10}, reverse);
        System.out.println("list = " + list);
        System.out.println("expected1 = " + expected1);
        System.out.println("expected2 = " + expected2);
        final LinkedIntList actual = list.removeAlternating();
        System.out.println("actual = " + actual);
        assertEquals(expected1.toString(), actual.toString());
        System.out.println("actual list = " + list);
        assertEquals(expected2.toString(), list.toString());
    }
}