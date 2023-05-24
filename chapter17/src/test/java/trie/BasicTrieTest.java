package trie;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class BasicTrieTest {


    @Test
    void shouldCreateATrie() {

        var trie = new BasicTrie();

        assertNotNull(trie);

    }
}
