public class MyBinarySearchTree<Type extends Comparable<Type>> {
    private Node root;
    private int size;
    public long comparisons;
    private boolean balancing;

    private boolean redBlack = true;

    private Node newNode = null;


    public long rotations;

    public MyBinarySearchTree(boolean balancing) {
        root = null;
        size = 0;
        comparisons = 0;
        rotations = 0;
        this.balancing = balancing;

    }

    public MyBinarySearchTree() {
        root = null;
        size = 0;
        comparisons = 0;
        this.balancing = false;

    }

    public void add(Type item) {
        root = add(item, root);
//        if (root.color == null){
//            root.color = "Black";
//        }
        if (!root.color.equals("Black")) {
            root.color = "Black";
        }
    }

    private Node add(Type item, Node subtree) {
        // updateHeight(subtree);

        if (subtree == null) {
            size++;

            newNode = new Node(item, "Red");
            //return new Node(item, "Red");
            return newNode;
        }
        // begin at the root
        // is the item we are looking for is less than the root
        if (item.compareTo(subtree.item) < 0) {
            subtree.left = add(item, subtree.left);

            updateHeight(subtree);
            // check for imbalance
//            if (balancing) {
//                subtree = rebalance(subtree);
//            }


            if (redBlack) {
                if (subtree.left.left == newNode) {
                    // if there are two consecutive red nodes
                    if (subtree.left.color.equals("Red") && subtree.left.left.color.equals("Red")) {
                        // if the uncle is red
                        if (subtree.right != null && subtree.right.color.equals("Red")) {
                            subtree.right.color = "Black";
                            subtree.left.color = "Black";
                            subtree.color = "Red";
                            newNode = subtree;
                        } else if (subtree.right == null || subtree.right.color.equals("Black")) {
                            // leftleft child
                            // right rotate
                            subtree = rotateRight(subtree);
                            subtree.color = "Black";
                            subtree.right.color = "Red";
                        }
                    }


                }
                if (subtree.left.right == (newNode)) {

                    // two consecutive red nodes
                    if (subtree.left.color.equals("Red") && subtree.left.right.color.equals("Red")) {
                        // if the uncle is red
                        if (subtree.right != null && subtree.right.color.equals("Red")) {
                            subtree.right.color = "Black";
                            subtree.left.color = "Black";
                            subtree.color = "Red";
                            newNode = subtree;
                        } else if (subtree.right == null || subtree.right.color.equals("Black")) {
                            // left right child
                            // left rotation
                            subtree.left = rotateLeft(subtree.left);
                            //right rotation
                            subtree = rotateRight(subtree);
                            updateHeight(subtree);
                            subtree.color = "Black";
                            subtree.right.color = "Red";


                        }


                    }


                }
            }


        } else if (item.compareTo(subtree.item) > 0) {
            subtree.right = add(item, subtree.right);

            updateHeight(subtree);
            // check for imbalance
//            if (balancing) {
//                subtree = rebalance(subtree);
//            }

            if (redBlack) {
                if (subtree.right.right == newNode) {
                    // if there are two consecutive red nodes
                    if (subtree.right.color.equals("Red") && subtree.right.right.color.equals("Red")) {
                        // if the uncle is red
                        if (subtree.left != null && subtree.left.color.equals("Red")) {
                            subtree.right.color = "Black";
                            subtree.left.color = "Black";
                            subtree.color = "Red";
                            newNode = subtree;
                        }
                        //if subtree.left is null or the color is black
                        else if (subtree.left == null || subtree.left.color.equals("Black")) {
                            // black node so rotation
                            // we know we are a right right child
                            // so left rotation
                            subtree = rotateLeft(subtree);
                            // change color of subtree to be black
                            subtree.color = "Black";
                            subtree.left.color = "Red";
                        }
                    }


                }
                if (subtree.right.left == newNode) {
                    if (subtree.right.color.equals("Red") && subtree.right.left.color.equals("Red")) {
                        if (subtree.left != null && subtree.left.color.equals("Red")) {
                            subtree.right.color = "Black";
                            subtree.left.color = "Black";
                            subtree.color = "Red";
                            newNode = subtree;
                        } else if (subtree.left == null || subtree.left.color.equals("Black")) {
                            // right left
                            // right rotation
                            subtree.right = rotateRight(subtree.right);
                            //  left rotation
                            subtree = rotateLeft(subtree);
                            updateHeight(subtree);
                            subtree.color = "Black";
                            subtree.left.color = "Red";

                        }

                    }


                }
            }


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
            // check for imbalance
//            if (balancing) {
//                subtree = rebalance(subtree);
//            }

            return subtree;
        } else if (item.compareTo(subtree.item) > 0) {
            subtree.right = remove(item, subtree.right);
            updateHeight(subtree);
            // check for imbalance
//            if (balancing) {
//                subtree = rebalance(subtree);
//            }
            return subtree;
        } else if (item.equals(subtree.item)) {
            if (subtree.left == null) {
                return subtree.right;
            } else if (subtree.right == null) {
                return subtree.left;
            } else {
                subtree.right = min(subtree.right, subtree);
                updateHeight(subtree);
                // check for imbalance
//                if (balancing) {
//                    subtree = rebalance(subtree);
//                }
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


        if (item.compareTo(subtree.item) == 0) {
            return item;
        } else if (item.compareTo(subtree.item) < 0) {

            return find(item, subtree.left);

        } else {
            return find(item, subtree.right);

        }


    }

    public int height() {
        if (size == 0 || root == null) {
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
//        if (node == null){
//            return;
//        }


        node.height = Math.max(node.left != null ? node.left.height : -1, node.right != null ? node.right.height : -1) + 1;
        // node.balanceFactor = node.left.height - node.right.height;
        //  node.balanceFactor = ((node.left!= null && node.right != null) ? node.left.height-node.right.height : -1);
//        if (node.left != null && node.right != null) {
//            node.balanceFactor = node.left.height - node.right.height;
//        }
//        if (node.left == null && node.right != null) {
//            node.balanceFactor = -1 - node.right.height;
//        }
//        if (node.left != null && node.right == null) {
//            node.balanceFactor = node.left.height + 1;
//        }
//        if (node.left == null && node.right == null) {
//            node.balanceFactor = 0;
//        }

//        if (node.balanceFactor <= -3) {
//            System.out.println("here");
//        }


    }


//    private int max(int height, int height1) {
//        if (height < height1) {
//            return height1;
//        } else {
//            return height;
//        }
//
//    }

    private Node rotateRight(Node node) {

        Node nodeToPromote = node.left;

        node.left = nodeToPromote.right;
        nodeToPromote.right = node;

        rotations++;
        updateHeight(nodeToPromote.right);
        return nodeToPromote;
    }

    private Node rotateLeft(Node node) {

        Node nodeToPromote = node.right;


        node.right = nodeToPromote.left;
        nodeToPromote.left = node;

        updateHeight(nodeToPromote.left);
        rotations++;
        return nodeToPromote;
    }

//    private Node rebalance(Node node) {
//
//
////        if (node == null) {
////            return null;
////        }
//
//
//        //if right is heavy
//        if (node.balanceFactor < -1) {
//            //  if right left case
//            if (node.right.balanceFactor > 0) {
//                node.right = rotateRight(node.right);
//                // updateHeight(node.right);
//                // updateHeight(node);
//
//            }
//            node = rotateLeft(node);
//
//            updateHeight(node.left);
//
//            updateHeight(node);
//
//
//        }
//        // if left is heavy
//        if (node.balanceFactor > 1) {
//            //      if left right case
//            if (node.left.balanceFactor < 0) {
//
//                node.left = rotateLeft(node.left);
//
//
//            }
//            node = rotateRight(node);
//
//            updateHeight(node.right);
//            updateHeight(node);
//
//
//        }
//
//
//        return node;
//
//    }

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
    }

    private void inorderTraversal(Node node, StringBuilder temp) {


        if (node != null) {
            inorderTraversal(node.left, temp);
            temp.append(node.toString() + ", ");
            inorderTraversal(node.right, temp);
        }


    }

    private class Node {

        public int key;
        public Type item;

        public Node parent;
        public Node left;
        public Node right;
        public int height;


        public String color;

        public int balanceFactor;

        public Node(Type item, String color) {
            this.item = item;
            this.color = color;
//            left = null;
//            right = null;
//            parent = null;


        }

        public Node(Type item, Node left, Node right, int height, int balanceFactor) {
            this.item = item;
            this.left = left;
            this.right = right;
            this.height = height;
            this.balanceFactor = balanceFactor;
        }

        public Node(Type item) {
            this.item = item;
        }

        public String toString() {
            return item + ":H" + height + ":" + color;
        }
    }


}
