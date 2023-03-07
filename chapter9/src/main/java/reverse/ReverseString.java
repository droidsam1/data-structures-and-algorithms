package reverse;

import java.util.ArrayDeque;

public class ReverseString {

    private ReverseString() {
    }

    public static String reverse(String input) {
        var stack = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        var stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();

    }
}
