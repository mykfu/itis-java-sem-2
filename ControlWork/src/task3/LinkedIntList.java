package task3;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LinkedIntList {
    private ListNode front; // первый элемент списка

    public LinkedIntList() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;


        LinkedIntList thisList = this;
        LinkedIntList that = (LinkedIntList) o;


        ListNode current = thisList.front;
        ListNode currentThat = that.front;
        while (current != null && currentThat != null) {
            if (current.data != currentThat.data)
                return false;
            current = current.next;
            currentThat = currentThat.next;
        }

        if (current == null && currentThat == null) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        ListNode current = front;
        while (current != null) {
            result += 31 * Integer.hashCode(front.data);
            current = current.next;
        }
        return result;
    }

    public LinkedIntList(ListNode front) {
        this.front = front;
    }

    public LinkedIntList(Integer... nodes) {
        for (Integer value : nodes) {
            this.add(value);
        }
    }

    public void add(int element) {
        if (front == null) {
            front = new ListNode(element, null);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(element);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkedIntList{");
        ListNode current = front;
        while (current != null) {
            stringBuilder.append(current.data);
            if (current.next != null) stringBuilder.append(", ");
            current = current.next;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public LinkedIntList removeAlternating() {
        LinkedIntList list = new LinkedIntList();

        if (front != null && front.next != null) {
            list.front = front;
            front = front.next;

            ListNode curr = front;
            ListNode curr2 = list.front;
            curr2.next = null;
            int count = 1;

            while (curr.next != null && curr.next.next != null) {
                if (count % 2 == 0) {
                    curr2.next = curr.next;
                    curr.next = curr.next.next;
                } else {
                    curr2.next = curr.next.next;
                    curr.next.next = curr.next.next.next;
                }
                count++;
                curr = curr.next;
                curr2 = curr2.next;
                curr2.next = null;
            }
        }
        return list;
    }

}

class ListNode {
    public int data; // здесь хранятся данные
    public ListNode next; // ссылка на следующий элемент

    public ListNode(int data) {
        this.data = data;
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
