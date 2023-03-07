package reverse;

public class ReverseString {

    private ReverseString() {

    }

    public static String reverse(String input) {
        if (input.length() == 1) {
            return input;
        }

        return String.valueOf(input.charAt(1)) + input.charAt(0);
    }
}
