package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoCorrect {

    private final List<String> correctWords;

    public AutoCorrect() {
        this.correctWords = new ArrayList<>();
    }

    public AutoCorrect(List<String> correctWords) {
        this.correctWords = correctWords;
    }

    public List<String> autocorrect(String input) {
        if (correctWords.contains(input)) {
            return List.of(input);
        }
        return Collections.emptyList();
    }
}
