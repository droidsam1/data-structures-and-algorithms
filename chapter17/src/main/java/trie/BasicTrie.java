package trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class BasicTrie {

    private final Node root;


    public BasicTrie() {
        this(Collections.emptyList());
    }

    public BasicTrie(Collection<String> words) {
        this.root = new Node(null, new ArrayList<>());
        for (String word : words) {
            addWordToTrie(word.strip().toLowerCase());
        }
    }

    private void addWordToTrie(String word) {
        var currentNode = this.root;
        for (Character c : word.toCharArray()) {
            var childWithCharacter = currentNode.getChildWith(c);
            if (childWithCharacter.isPresent()) {
                currentNode = childWithCharacter.get();
            } else {
                var newNode = new Node(c, new ArrayList<>());
                currentNode.children.add(newNode);
                currentNode = newNode;
            }
        }
        currentNode.setFinalWord();
    }


    public boolean contains(String word) {
        var currentNode = this.root;
        for (Character c : word.strip().toLowerCase().toCharArray()) {
            var childWithCharacter = currentNode.getChildWith(c);
            if (childWithCharacter.isPresent()) {
                currentNode = childWithCharacter.get();
            } else {
                return false;
            }
        }
        return currentNode.isFinalWord;
    }


    private static class Node {

        private final Character character;
        private final Collection<Node> children;
        private boolean isFinalWord;

        Node(Character character, Collection<Node> children) {
            this.character = character;
            this.children = children;
            this.isFinalWord = false;
        }

        void setFinalWord() {
            this.isFinalWord = true;
        }

        Optional<Node> getChildWith(Character c) {
            for (Node node : children) {
                if (c.equals(node.character)) {
                    return Optional.of(node);
                }
            }
            return Optional.empty();
        }
    }


}
