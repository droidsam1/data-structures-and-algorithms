package find_first_non_duplicated_letter;

import java.util.HashMap;

public class FirstNonDuplicate {

    private FirstNonDuplicate() {
    }

    public static Character find(String input) {
        var hashTable = new HashMap<Character, Integer>();

        var chars = input.toCharArray();
        for (char aChar : chars) {
            var counter = hashTable.getOrDefault(aChar, 0) + 1;
            hashTable.put(aChar, counter);
        }

        for (char aChar : chars) {
            if (hashTable.get(aChar) == 1) {
                return aChar;
            }
        }

        return chars[0];
    }
}
