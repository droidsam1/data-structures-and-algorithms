package trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BasicTrie {

    private final Node root;

    public BasicTrie() {
        this(Collections.emptyList());
    }

    public BasicTrie(Collection<String> words) {
        this.root = Node.createRootNode();
        for (String word : words) {
            addWordToTrie(word.strip().toLowerCase());
        }
    }

    private void addWordToTrie(String word) {
        var currentNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            var childWithCharacter = currentNode.getChildWith(word.charAt(i));
            if (childWithCharacter.isPresent()) {
                currentNode = childWithCharacter.get();
            } else {
                var isEndOfCompleteWord = (i == word.length() - 1);
                var newNode = new Node(word.charAt(i), new ArrayList<>(), isEndOfCompleteWord);
                currentNode.children.add(newNode);
                currentNode = newNode;
            }
        }
    }

    public boolean contains(String word) {
        var currentNode = this.root;
        for (char c : word.strip().toLowerCase().toCharArray()) {
            var childWithCharacter = currentNode.getChildWith(c);
            if (childWithCharacter.isPresent()) {
                currentNode = childWithCharacter.get();
            } else {
                return false;
            }
        }
        return currentNode.isEndOfCompleteWord;
    }


    public List<String> getClosestWordsTo(String word) {
        var matchedPrefix = new StringBuilder();
        var currentNode = this.root;
        for (char c : word.strip().toLowerCase().toCharArray()) {
            var childWithCharacter = currentNode.getChildWith(c);
            if (childWithCharacter.isPresent()) {
                currentNode = childWithCharacter.get();
                matchedPrefix.append(currentNode.character);
            } else {
                return allWordsFrom(currentNode, matchedPrefix);
            }
        }
        if (currentNode.isEndOfCompleteWord) {
            return List.of(matchedPrefix.toString());
        }
        return allWordsFrom(currentNode, matchedPrefix);
    }

    private List<String> allWordsFrom(Node currentNode, StringBuilder matchedPrefix) {
        var words = new ArrayList<String>();
        for (Node child : currentNode.children) {
            var prefix = new StringBuilder(matchedPrefix.toString()).append(child.character);
            if (child.isEndOfCompleteWord) {
                words.add(prefix.toString());
            }
            words.addAll(allWordsFrom(child, prefix));
        }
        return words;
    }


    private record Node(Character character, Collection<Node> children, boolean isEndOfCompleteWord) {

        static Node createRootNode() {
            return new Node(null, new ArrayList<>(), false);
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
