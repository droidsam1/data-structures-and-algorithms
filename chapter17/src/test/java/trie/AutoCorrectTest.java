package trie;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Disabled;
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
    @Disabled("while developing a trie")
    void shouldReturnTheCorrectWord() {
        var correctWords = List.of("cat");
        var input = "cax";

        var suggestions = new AutoCorrect(correctWords).autocorrect(input);

        assertNotNull(suggestions);
        assertTrue(suggestions.contains("cat"));
    }

}
