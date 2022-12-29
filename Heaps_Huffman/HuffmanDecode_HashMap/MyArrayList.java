public class MyArrayList<Type extends Comparable<Type>> {

    private Type[] list;
    private int capacity;
    private int size;
    public long comparisons;

    public MyArrayList() {

        this.capacity = 16;
        this.size = 0;
        this.list = (Type[]) new Comparable[capacity];
        comparisons = 0;
    }

    public void sort() {
        sort(0, size - 1);
    }

    private void sort(int low, int high) {
        if (high <= low) return;

        int mid = (high + low) / 2;

        sort(low, mid);

        sort(mid + 1, high);

        merge(low, (Type[]) new Comparable[high - low + 1], mid + 1, high);
    }


    private void merge(int low, Type[] temp, int mid, int high) {

        // Type[] temp = (Type[]) new Comparable[high - low + 1];

        int index = 0;
        int start = low;
        int low2 = mid;

        while (low < mid && low2 <= high) {

            if (list[low].compareTo(list[low2]) < 0) {
                temp[index++] = list[low++];
            } else {
                temp[index++] = list[low2++];
            }

        }

        while (low < mid) temp[index++] = list[low++];

        while (low2 <= high) temp[index++] = list[low2++];


        for (int i = 0; i < temp.length; i++) {
            list[start + i] = temp[i];
        }
    }


    public void insert(Type item, int index) {

        if (index > size || index < 0) {
            return;
        }


        if (size == capacity) {
            resize();
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public Type remove(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Type itemToRemove = list[index];
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;

        return itemToRemove;
    }

    public Type remove(Type item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                index = i;
            }
        }

        return remove(index);
    }

    public boolean contains(Type item) {


        comparisons++;
        for (int i = 0; i < size; i++) {
            comparisons++;
            if (list[i].compareTo(item) == 0) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Type item) {
        for (int i = 0; i < size; i++) {

            if (list[i].compareTo(item) == 0) {
                return i;
            }
        }
        return -1;
    }

    public Type get(int index) {
        if (index >= size || index < 0) return null;
        return list[index];
    }

    public void set(int index, Type item) {
        if (index >= list.length || index < 0) {
            return;
        }
        list[index] = item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public String toString() {
//        StringBuilder s = new StringBuilder();
//        if (size == 0) {
//            return "[]";
//        }
//        s.append("[");
//        for (int i = 0; i < size; i++) {
//            s.append(list[i]).append(", ");
//        }
//        s.deleteCharAt(s.length() - 1);
//        s.deleteCharAt(s.length() - 1);
//        s.append("]");
//
//        return s.toString();
        StringBuilder s = new StringBuilder();
        if (size == 0) {
            return "[]";
        }
        for (int i = 0; i < size; i++) {
            s.append(list[i]).append(", ");

        }
        String string = s.toString();
        int end = Math.max(0, s.length() - 2);
        return "[" + string.substring(0, end) + "]";

    }

    private void resize() {
        Type[] newList = (Type[]) new Comparable[capacity * 2];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        capacity *= 2;
        list = newList;
    }


}

