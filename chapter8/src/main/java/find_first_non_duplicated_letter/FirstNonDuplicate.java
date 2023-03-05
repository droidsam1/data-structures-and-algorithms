package find_first_non_duplicated_letter;

public class FirstNonDuplicate {

    private FirstNonDuplicate() {
    }

    public static Character find(String input) {

        var chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            var duplicated = false;
            for (int j = 0; j < chars.length; j++) {
                if (j != i && chars[i] == chars[j]) {
                    duplicated = true;
                    break;
                }
            }
            if (!duplicated) {
                return chars[i];
            }
        }
        return chars[0];
    }
}
