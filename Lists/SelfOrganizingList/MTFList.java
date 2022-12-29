public class MTFList<Type extends Comparable<Type>> {
    private MyLinkedList<Type> list;


    public MTFList() {
        list = new MyLinkedList<>();
    }

    public void add(Type item) {

        //list.first();
        list.addToFront(item);


    }

    public Type remove(Type item) {


        Type temp = null;
        list.first();
        while (list.current() != null) {
            if (list.current().compareTo(item) == 0) {
                temp = list.remove();
                return temp;
            }
            list.next();

        }
        return temp;


        //return null;

    }

    public Type find(Type item) {

        Type temp = null;
        list.first();
        while (list.current() != null) {
            if (list.current().compareTo(item) == 0) {
                // move to front


                list.moveToFront();
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
