public class TransposeList<Type extends Comparable<Type>> {
    private MyLinkedList<Type> list;

    public TransposeList() {
        list = new MyLinkedList<>();
    }

    public void add(Type item) {
        if (list.size() == 0) {
            list.addBefore(item);
        } else {
            list.addToEnd(item);
        }


    }

    public Type remove(Type item) {
        Type temp = null;
        list.first();
        while (list.current() != null) {
            if (list.current().compareTo(item) == 0) {
                return list.remove();
            }
            list.next();
        }

        return null;
    }

    public Type find(Type item) {
        list.first();
        while (list.current() != null) {
            if (list.current().compareTo(item) == 0) {
                // move to front
                //list.moveToFront();

                //swap with neighbor
                list.swapWithPrevious();
                return item;
            }
            list.next();
        }

        return null;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return list.toString();
    }


}
