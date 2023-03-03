package missing_letter;

public class MissingLetterException extends RuntimeException {

    public MissingLetterException() {
        super("The input is missing more than one letter, or the letter is not in the alphabet");
    }
}
