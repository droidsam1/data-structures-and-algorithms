package trie;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class AutoCorrectTest {


    @Test
    void shouldNotReturnAnySuggestionIfAutocorrectHasNotLoadedWithCorrectWords() {
        var input = "wor";

        var suggestions = new AutoCorrect().autocorrect(input);

        assertNotNull(suggestions);
        assertTrue(suggestions.isEmpty());
    }


    @Test
    void shouldReturnTheWordItselfWhenWordIsFoundInTheTrie() {
        var correctWords = List.of("word");
        var input = "word";

        var suggestions = new AutoCorrect(correctWords).autocorrect(input);

        assertNotNull(suggestions);
        assertTrue(suggestions.contains(input));
    }

    @Test
    void shouldReturnTheCorrectWord() {
        var correctWords = List.of("cat");
        var input = "cax";

        var suggestions = new AutoCorrect(correctWords).autocorrect(input);

        assertNotNull(suggestions);
        assertTrue(suggestions.contains("cat"));
    }


    @Test
    void shouldReturnTheCorrectWordForTheProposedExample() {
        var correctWords = List.of("cat", "catnap", "catnip");
        var input = "catnar";

        var suggestions = new AutoCorrect(correctWords).autocorrect(input);

        assertNotNull(suggestions);
        assertTrue(suggestions.contains("catnap"));
    }

    @Test
    void shouldReturnTheCorrectWordForTheSecondProposedExample() {
        var correctWords = List.of("cat", "catnap", "catnip");
        var input = "caxasfdij";

        var suggestions = new AutoCorrect(correctWords).autocorrect(input);

        assertNotNull(suggestions);
        assertTrue(suggestions.contains("cat"));
        assertTrue(suggestions.contains("catnap"));
        assertTrue(suggestions.contains("catnip"));

    }

}
