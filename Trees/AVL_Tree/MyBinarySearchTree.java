public class MyBinarySearchTree<Type extends Comparable<Type>> {
    private Node root;
    private int size;
    public long comparisons;
    private boolean balancing;

    public long rotations;

    public MyBinarySearchTree(boolean balancing) {
        root = null;
        size = 0;
        comparisons = 0;
        rotations = 0;
        this.balancing = balancing;

    }

//    public MyBinarySearchTree() {
//        root = null;
//        size = 0;
//        comparisons = 0;
//        this.balancing = false;
//
//    }

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
            // check for imbalance
            if (balancing) {
                subtree = rebalance(subtree);
            }

        } else if (item.compareTo(subtree.item) > 0) {
            subtree.right = add(item, subtree.right);
            updateHeight(subtree);
            // check for imbalance
            if (balancing) {
                subtree = rebalance(subtree);
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
            if (balancing) {
                subtree = rebalance(subtree);
            }

            return subtree;
        } else if (item.compareTo(subtree.item) > 0) {
            subtree.right = remove(item, subtree.right);
            updateHeight(subtree);
            // check for imbalance
            if (balancing) {
                subtree = rebalance(subtree);
            }
            return subtree;
        } else if (item.equals(subtree.item)) {
            if (subtree.left == null) {
                return subtree.right;
            } else if (subtree.right == null) {
                return subtree.left;
            } else {
                subtree.item = min(subtree.right).item;
                subtree.right = remove(subtree.item,subtree.right);
                //updateHeight(subtree.right);
                updateHeight(subtree);
                //updateHeight(subtree.right);
                // check for imbalance
                if (balancing) {
                    subtree = rebalance(subtree);
                }
                return subtree;
            }

        }
        return subtree;
    }


    private Node min(Node node) {
//        if (node.left != null) {
//            node.left = min(node.left);
//            return node;
//        } else {
//            nodeToRemove.item = node.item;
//            return node.right;
//        }
        if (node.left == null){
            return node;
        }
        return min(node.left);

    }

    public Type find(Type item) {

        // comparisons = 0;
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
//        if (node == null){
//            return;
//        }


        node.height = Math.max(node.left != null ? node.left.height : -1, node.right != null ? node.right.height : -1) + 1;
        // node.balanceFactor = node.left.height - node.right.height;
        //  node.balanceFactor = ((node.left!= null && node.right != null) ? node.left.height-node.right.height : -1);

        if (node.left != null && node.right != null) {
            node.balanceFactor = node.left.height - node.right.height;
        } else if (node.left == null && node.right != null) {
            node.balanceFactor = (-1) - node.right.height;
        } else if (node.left != null && node.right == null) {
            node.balanceFactor = node.left.height - (-1);
        } else {
            node.balanceFactor = 0;
        }


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

    private Node rebalance(Node node) {


//        if (node == null) {
//            return null;
//        }


        //if right is heavy
        if (node.balanceFactor < -1) {
            //  if right left case
            if (node.right.balanceFactor > 0) {
                node.right = rotateRight(node.right);
                // updateHeight(node.right);
                // updateHeight(node);

            }
            node = rotateLeft(node);

            updateHeight(node.left);

            updateHeight(node);


        }
        // if left is heavy
        if (node.balanceFactor > 1) {
            //      if left right case
            if (node.left.balanceFactor < 0) {

                node.left = rotateLeft(node.left);


            }
            node = rotateRight(node);

            updateHeight(node.right);
            updateHeight(node);


        }


        return node;

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

        public int balanceFactor;

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
            return item + ":H" + height + ":B" + balanceFactor;
        }
    }


}
