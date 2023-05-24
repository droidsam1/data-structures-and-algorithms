package trie;

import java.util.ArrayList;
import java.util.Collection;

public class BasicTrie {

    private final Node root;


    public BasicTrie() {
        this.root = new Node(null, new ArrayList<>());
    }

    public BasicTrie(Collection<String> words) {
        this();
        for (String word : words) {
            var currentNode = this.root;
            for (Character c : word.strip().toLowerCase().toCharArray()) {
                if (currentNode.equals(root)) {
                    if (currentNode.childrenNotContains(c)) {
                        var newNode = new Node(c, new ArrayList<>());
                        currentNode.children.add(newNode);
                        currentNode = newNode;
                        continue;
                    }
                }
                var childWithCharacter = currentNode.getChildWith(c);
                if (childWithCharacter != null) {
                    currentNode = childWithCharacter;
                } else {
                    var newNode = new Node(c, new ArrayList<>());
                    currentNode.children.add(newNode);
                    currentNode = newNode;
                }
            }
            if (currentNode != null) {
                currentNode.setFinalWord();
            }
        }
    }

    public boolean contains(String word) {
        var currentNode = this.root;
        for (Character c : word.strip().toLowerCase().toCharArray()) {
            var childWithCharacter = currentNode.getChildWith(c);
            if (childWithCharacter != null) {
                currentNode = childWithCharacter;
            } else {
                return false;
            }
        }

        if (currentNode != null) {
            return currentNode.isFinalWord;
        }
        return false;
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

        public void setFinalWord() {
            this.isFinalWord = true;
        }

        Node getChildWith(Character c) {
            for (Node node : children) {
                if (c.equals(node.character)) {
                    return node;
                }
            }
            return null;
        }

        boolean childrenNotContains(Character c) {
            return getChildWith(c) == null;
        }
    }


}
