public class MyBinarySearchTree<Type extends Comparable<Type>> {
    private Node root;
    private int size;
    public long comparisons;

    public MyBinarySearchTree() {
        root = null;
        size = 0;
        comparisons = 0;
    }

    public void add(Type item) {
        root = add(item, root);
    }

    private Node add(Type item, Node subtree) {
        // updateHeight(subtree);
        if (subtree == null) {
            size++;
            return new Node(item);
        }
        // begin at the root
        // is the item we are looking for is less than the root
        if (item.compareTo(subtree.item) < 0) {
            subtree.left = add(item, subtree.left);
            updateHeight(subtree);
        } else if (item.compareTo(subtree.item) > 0) {
            subtree.right = add(item, subtree.right);
            updateHeight(subtree);
        }

        // updateHeight(subtree);

        return subtree;
    }

    public void remove(Type item) {
        root = remove(item, root);

    }

    private Node remove(Type item, Node subtree) {


        if (subtree == null) {
            return null;
        } else if (item.compareTo(subtree.item) < 0) {
            subtree.left = remove(item, subtree.left);
            updateHeight(subtree);
            return subtree;
        } else if (item.compareTo(subtree.item) > 0) {
            subtree.right = remove(item, subtree.right);
            updateHeight(subtree);
            return subtree;
        } else if (item.equals(subtree.item)) {
            if (subtree.left == null) {
                return subtree.right;
            } else if (subtree.right == null) {
                return subtree.left;
            } else {
                subtree.right = min(subtree.right, subtree);
                updateHeight(subtree);
                return subtree;
            }

        }
        return subtree;
    }


    private Node min(Node node, Node nodeToRemove) {
        if (node.left != null) {
            node.left = min(node.left, nodeToRemove);
            return node;
        } else {
            nodeToRemove.item = node.item;
            return node.right;
        }

    }

    public Type find(Type item) {

        return find(item, root);
    }

    private Type find(Type item, Node subtree) {
        comparisons++;

        if (subtree == null) {

            return null;
        }
        // comparisons++;


        if (item.compareTo(subtree.item) == 0) {
            return item;
        } else if (item.compareTo(subtree.item) < 0) {

            return find(item, subtree.left);

        } else {
            return find(item, subtree.right);

        }


    }

    public int height() {
        if (size == 0) {
            return -1;
        }
        return root.height;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void updateHeight(Node node) {


        node.height = Math.max(node.left != null ? node.left.height : -1, node.right != null ? node.right.height : -1) + 1;


    }


    private int max(int height, int height1) {
        if (height < height1) {
            return height1;
        } else {
            return height;
        }

    }

    public String toString() {

        if (size == 0) {
            return "[]";
        }
        //String temp = "";
        StringBuilder temp = new StringBuilder();

        inorderTraversal(root, temp);
        String s = temp.toString();
        // System.out.println(s);
        int end = Math.max(0, s.length() - 2);
        return "[" + s.substring(0, end) + "]";

//        return treeWalk(root, temp);


    }

    private void inorderTraversal(Node node, StringBuilder temp) {


        if (node != null) {

            inorderTraversal(node.left, temp);

            temp.append(node.toString() + ", ");
            inorderTraversal(node.right, temp);


        }


    }

    private class Node {
        public Type item;
        public Node left;
        public Node right;
        public int height;

        public Node(Type item, Node left, Node right, int height) {
            this.item = item;
            this.left = left;
            this.right = right;
            this.height = height;
        }

        public Node(Type item) {
            this.item = item;
        }

        public String toString() {
            return item + ":H" + height;
        }
    }


}
