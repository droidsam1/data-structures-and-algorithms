package count_all_chars;

public class CountAllChars {

    private CountAllChars() {
    }

    public static int count(Object input) {
        if (input instanceof String) {
            return ((String) input).length();
        } else {
            if (input.getClass().isArray()) {
                int sum = 0;
                for (Object each : (Object[]) input) {
                    sum += count(each);
                }
                return sum;
            }
        }
        return 0;
    }
}
