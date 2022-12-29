public class MyOrderedList<Type extends Comparable<Type>> {
    private MyArrayList<Type> list = new MyArrayList<Type>();
    public long comparisons;

    public void add(Type item) {
        if (!isEmpty()) {

            for (int i = 0; i < list.size() + 1; i++) {
                if (i == list.size()) {
                    comparisons++;
                    list.insert(item, i);
                    break;
                }
                comparisons++;
                if (list.get(i).compareTo(item) > 0) {
                    comparisons++;
                    list.insert(item, i);
                    break;
                }
            }
        } else {
            comparisons++;
            list.insert(item, 0);
        }
        //comparisons++;


    }

    public Type remove(Type item) {
        return (Type) list.remove(item);
    }

    public Type binarySearch(Type item) {


        return binarySearch(item, 0, list.size() - 1);
    }


    private Type binarySearch(Type item, int start, int finish) {
        if (start > finish) {

            comparisons++;
            return null;
        }
        int mid = (start + finish) / 2;
        comparisons++;
        if (list.get(mid).compareTo(item) == 0) {

            comparisons++;
            return list.get(mid);
        }
        if (list.get(mid).compareTo(item) > 0) {

            comparisons++;
            return binarySearch(item, start, mid - 1);
        } else {

            comparisons++;
            return binarySearch(item, mid + 1, finish);
        }


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


    public Type get(int index) {
        if (index > list.size()) {
            return null;
        }

        return list.get(index);

    }

}
