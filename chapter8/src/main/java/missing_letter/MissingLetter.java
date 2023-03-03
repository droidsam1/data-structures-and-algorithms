package missing_letter;

import java.util.HashMap;

public class MissingLetter {

    private MissingLetter() {
    }

    public static char findMissingLetterIn(String input) {
        var letterMap = new HashMap<Character, Boolean>();
        var inputLetters = input.toCharArray();
        for (char inputLetter : inputLetters) {
            letterMap.put(inputLetter, true);
        }

        for (int i = 'a'; i <= 'z'; i++) {
            var letter = letterMap.get(((char) i));
            if (letter == null || !letter) {
                return (char) i;
            }
        }

        throw new MissingLetterException();
    }
}
