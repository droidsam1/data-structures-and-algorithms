package Trie;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AutoCorrectTest {


    @Test
    void shouldNotReturnAnySuggestionIfAutocorrectHasNotLoadedWithCorrectWords() {

        var input = "wor";

        var suggestions = AutoCorrect.autocorrect(input);

        assertNotNull(suggestions);
        assertTrue(suggestions.isEmpty());
    }

}
