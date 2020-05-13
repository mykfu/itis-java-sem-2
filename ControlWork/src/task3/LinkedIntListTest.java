package task3;

public class LinkedIntListTest {
    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        System.out.println(list);
        System.out.println(list.removeAlternating());
        System.out.println(list);
    }
}
