package find_first_duplicate;

import static java.lang.Boolean.TRUE;

import java.util.HashMap;

public class FirstDuplicate {

    private FirstDuplicate() {
    }

    public static String[] find(String[] input) {
        var duplicatesTable = new HashMap<String, Boolean>();
        for (var element : input) {
            var isDuplicate = duplicatesTable.getOrDefault(element, false);
            if (TRUE.equals(isDuplicate)) {
                return new String[]{element};
            }
            duplicatesTable.put(element, true);
        }
        return new String[]{};
    }
}
