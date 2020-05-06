package sem2.cw1answers;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class LinkedIntList {
    private ListNode front; // первый элемент списка

    public LinkedIntList() {
    }

    public void add(int element) {
        if (front == null) {
            front = new ListNode(element);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(element);
        }
    }

    public void addAll(Integer... nodes) {
        for (Integer node : nodes) {
            add(node);
        }
    }

    public void addAll(List nodes) throws Exception {
        throw new Exception("Not supported yet.");
    }

    public void addAll(int[] nodes) throws Exception {
        throw new Exception("Not supported yet.");
    }


    public LinkedIntList removeAlternating() {
        LinkedIntList result = new LinkedIntList();

        if (front != null && front.next != null) {
            result.front = front;
            front = front.next;

            ListNode current = front;
            ListNode current2 = result.front;

            int count = 1;

            while (current.next != null && current.next.next != null) {
                if (count % 2 == 0) {
                    current2.next = current.next;
                    current.next = current.next.next;
                } else {
                    current2.next = current.next.next;
                    current.next.next = current.next.next.next;
                }
                current = current.next;
                current2 = current2.next;
                current2.next = null;
                count++;
            }

        }
        return result;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder("List: [");
        ListNode current = front;
        while (current != null) {
            stringBuilder.append(current.data);
            if (current.next != null) stringBuilder.append(", ");
            current = current.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();
        list.addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        System.out.println("Before " + list);
        System.out.println("RemoveAlternating " + list.removeAlternating());
        System.out.println("After " + list);
    }

}

class ListNode {
    public int data; // здесь хранятся данные
    public ListNode next; // ссылка на следующий элемент

    public ListNode(int data) {
//        this.data = data;
        this(data, null);
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
