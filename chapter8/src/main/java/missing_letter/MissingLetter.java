package missing_letter;

public class MissingLetter {

    private MissingLetter() {
    }

    public static char findMissingLetterIn(String input) {
        for (int i = 'a'; i <= 'z'; i++) {
            if (!input.contains(Character.toString(i))) {
                return (char) i;
            }
        }
        throw new MissingLetterException();
    }
}
