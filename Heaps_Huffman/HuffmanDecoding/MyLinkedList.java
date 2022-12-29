

public class MyLinkedList<Type extends Comparable<Type>> {
    private Node first = null;
    private Node last = null;
    private Node current = null;
    private Node previous = null;
    private int size = 0;


    public long comparisons = 0;

    private class Node {

        public Type item;
        public Node next;


        public Node(Type data) {
            this.item = data;
            next = null;
        }

        public String toString() {
            return item.toString();
        }
    }

    // 1, 2, 4, 5
    // 4
    public void sort() {

        for (int i = 0; i < size; i++) {
            Node currentNode = first;
            Node nextNode = currentNode.next;
            for (int j = 0; j < size - 1 - i; j++) {
                if (currentNode.item.compareTo(nextNode.item) > 0) {

                    Type temp = currentNode.item;
                    currentNode.item = nextNode.item;
                    nextNode.item = temp;
                }
                currentNode = currentNode.next;
                nextNode = nextNode.next;
            }
        }


    }


    // used to initially populate the linked list


    public void addBefore(Type item) {
        Node node = new Node(item);
        // empty LinkedList
        if (size == 0) {
            first = node;
            last = node;
        } else if (current == null) {
            last.next = node;
            last = node;
        } else if (current == first) {
            previous = node;
            first = node;
            previous.next = current;
        } else {
            previous.next = node;
            node.next = current;
            previous = node;
        }
        size++;
    }

    // 1 ,         2 ,              3
    // curr        curr.next        curr.next.next
    // 1,          4,               2,               3
    // curr        curr.next

    // newNode = curr.next
    // curr.next = newNode

    public void addAfter(Type item) {
        if (current == null) {
            return;
        }
        Node node = new Node(item);
        node.next = current.next;
        current.next = node;
        size++;


    }

    public Type current() {
        if (current == null) return null;
        return current.item;
    }


    public Type first() {
        if (first == null) {
            return null;
        }
        current = first;
        return first.item;
    }


    public Type next() {
        if (current == null) return null;
        previous = current;
        current = current.next;
        if (current == null) return null;
        return current.item;
    }


    public Type remove() {
        if (current == null) return null;
        Type value = current.item;
        // current is the first value;
        if (current == first) {
            current = current.next;
            first = first.next;
        } else {
            previous.next = previous.next.next;
            current = previous.next;
        }
        size--;
        return value;
    }


    public boolean contains(Type item) {
        Node current = this.first;

        comparisons++;
        while (current != null) {
            comparisons++;

            if (current.item.compareTo(item) == 0) {

                return true;
            }

            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    /*
    addToFront
    Node n = new Node(item);
    n.next = first;
    first = n;

    swapWithPrevious()
    type temp = previous.item;
    previous.item = current.item;
    current.item = temp

    addToEnd
    Node n = new Node(item)
    end.next = n
    end = n
     */
    public String toString() {


        StringBuilder s = new StringBuilder();
        s.append("[");
        Node current = this.first;
        if (current == null) {
            return "[]";
        }
        while (current != null) {
            s.append(current.item).append(", ");
            current = current.next;
        }
        s.deleteCharAt(s.length() - 1);
        s.deleteCharAt(s.length() - 1);
        s.append("]");
        return s.toString();
    }


}
