package trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class BasicTrieTest {


    @Test
    void shouldCreateATrieWithWords() {

        var trie = new BasicTrie(List.of("cat", "cap", "captain", "cut", "cop"));

        assertNotNull(trie);

    }

    @Test
    void shouldContainWords() {

        var inputWords = List.of("cat", "cap", "captain", "cop");

        var trie = new BasicTrie(inputWords);

        assertTrue(inputWords.stream().allMatch(trie::contains));
        assertFalse(trie.contains("capo"));
    }
}
