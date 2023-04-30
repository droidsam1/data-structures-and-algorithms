package exercise;

import java.util.LinkedList;

public class PrintLinkedList {

    private PrintLinkedList() {
    }

    public static void print(LinkedList<Integer> input) {

        while (input.peek() != null) {
            System.out.println(input.pop());
        }
    }
}
