import org.w3c.dom.Node;

public class MyTrie {

    // stores the root node of the trie
    private Node root;
    // stores the number of strings added to the trie
    private int size;
    // stores the number of comparisons made in the insert and find methods
    public long comparisons;


    public MyTrie() {
        root = new Node('\0');
        size = 0;
        comparisons = 0;
    }

    /**
     * inserts the item into the trie
     *
     * @param item
     */
    public void insert(String item) {


        // when we insert we create new nodes

        // traverse down processing in one character at a time from the string that was passed in until I get to an empty set of children
        // if I get to an empty set of children, call addChildren then traverse. Call addChildren again, then traverse until all characters have been processed.
        // when you get to the final node where that word has ended you set the terminal value to true.
        // the default should be false.

        Node currentNode = root;

        Node newNode;
        MyOrderedList<Node> tempChildren = currentNode.children;

        for (int i = 0; i < item.length(); i++) {
            newNode = new Node(item.charAt(i));
            comparisons++;

            if (currentNode.children.isEmpty()) {
                currentNode.addChildren();
            }
            currentNode = tempChildren.binarySearch(newNode);
            tempChildren = currentNode.children;
        }
        size++;
        currentNode.terminal = true;


    }

    /**
     * remove the item from the trie
     *
     * @param item
     */
    public void remove(String item) {


        Node currentNode = root;
        Node newNode;

        for (int i = 0; i < item.length(); i++) {
            char character = item.charAt(i);
            newNode = new Node(character);

            currentNode = currentNode.children.binarySearch(newNode);

        }

//        if (currentNode != null && currentNode.children.isEmpty()) {
//            return;
//        }

        if (!find(item)){
            return;
        }

        if (currentNode != null) {
            size--;
            currentNode.terminal = false;
        }


    }

    /**
     * returns true if the item is in the trie and false otherwise
     *
     * @param item
     * @return
     */

    public boolean find(String item) {

        Node currentNode = root;
        //   MyOrderedList<Node> tempChildren = currentNode.children;

        Node newNode;

        for (int i = 0; i < item.length(); i++) {
            comparisons++;

            char character = item.charAt(i);
            newNode = new Node(character);
//
//            if (currentNode.children.isEmpty()) {
//                return false;
//            }
//            currentNode = tempChildren.binarySearch(newNode);
//            tempChildren = currentNode.children;

            if (currentNode.children.binarySearch(newNode) == null) {
                return false;
            }
            currentNode = currentNode.children.binarySearch(newNode);


        }

        return currentNode.terminal;
    }

    /**
     * returns the number of elements in the trie
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * returns true if the trie is empty and false otherwise
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * returns the contents of the trie, in alphabetical order, as a string
     * uses the helper function addWords
     *
     * @return
     */
    public String toString() {
        if (size == 0) {
            return "[]";

        }
        StringBuilder temp = new StringBuilder();
        addWords(root, "", temp);
        String s = temp.toString();
        int end = Math.max(0, s.length() - 2);
        return "[" + s.substring(0, end) + "]";
        // return temp.toString();
    }

    /**
     * recursive function that traverses the trie as a pre-order depth-first traversal.
     * the string str stores the path to the current node
     * words in the trie, when found, will be added to output
     *
     * @param node
     * @param str
     * @param output
     */
    private void addWords(Node node, String str, StringBuilder output) {
        // call on node. The first time it is called will be on the root.

        Node newNode;

        str += node.character;

        if (node.terminal) {

            output.append(str + ", ");


        }
        for (int i = 0; i < node.children.size(); i++) {

            addWords(node.children.get(i), str, output);
        }


    }


    private class Node implements Comparable<Node> {

        // true if this node represents the end of a word stored in the trie, and false if the node is only part of a prefix of a word stored in the trie
        public boolean terminal;
        // the character you must follow to arrive at this node from its parent
        public char character;
        // the list of children nodes, one for each
        public MyOrderedList<Node> children;


        private String item;

        private Node(Character ch) {
            terminal = false;
            children = new MyOrderedList<Node>();
            character = ch;
        }


        /**
         * compares the nodes based on character
         *
         * @param other
         * @return
         */
        public int compareTo(Node other) {
            return Character.compare(character, other.character);

//            if (character == other.character) {
//                return 0;
//            }
//            if (character < other.character) {
//                return -1;
//            }
//            return 1;

            //  return character.compareTo(other.character);
        }

        /**
         * adds one new node to children for each character in this set
         * (the same set used by BookReader
         */
        public void addChildren() {
            String alphabet = "0123456789'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            for (int i = 0; i < alphabet.length(); i++) {
                Node newNode = new Node(alphabet.charAt(i));
                children.add(newNode);
            }


        }

    }

}
