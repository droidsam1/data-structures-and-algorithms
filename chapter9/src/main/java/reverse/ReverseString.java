package reverse;

public class ReverseString {

    private ReverseString() {
    }

    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
