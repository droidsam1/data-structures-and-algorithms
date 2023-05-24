package trie;

import java.util.ArrayList;
import java.util.Collection;

public class BasicTrie {

    private final Node root;


    public BasicTrie() {
        this.root = new Node(null, new ArrayList<>());
    }


    private record Node(Character character, Collection<Node> children) {


        Node getChildWith(Character c) {
            for (Node node : children) {
                if (c.equals(node.character)) {
                    return node;
                }
            }
            return null;
        }

        boolean childrenContains(Character c) {
            return getChildWith(c) != null;
        }
    }


}
