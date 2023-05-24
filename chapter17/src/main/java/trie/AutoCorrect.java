package trie;

import java.util.List;

public class AutoCorrect {

    private final BasicTrie correctWords;

    public AutoCorrect() {
        this.correctWords = new BasicTrie();
    }

    public AutoCorrect(List<String> correctWords) {
        this.correctWords = new BasicTrie(correctWords);
    }

    public List<String> autocorrect(String input) {
        return correctWords.getClosestWordsTo(input);
    }
}
