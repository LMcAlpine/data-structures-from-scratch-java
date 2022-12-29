public class MyArrayList<Type> {

    private Type[] list;
    private int capacity;
    private int size;

    public MyArrayList() {

        this.capacity = 16;
        this.size = 0;
        this.list = (Type[]) new Object[capacity];
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

    public boolean contains(Type item) {
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Type item) {
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
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
        StringBuilder s = new StringBuilder();
        if (size == 0) {
            return "[]";
        }
        s.append("[");
        for (int i = 0; i < size; i++) {
            s.append(list[i]).append(", ");
        }
        s.deleteCharAt(s.length() - 1);
        s.deleteCharAt(s.length() - 1);
        s.append("]");

        return s.toString();
    }

    private void resize() {
        Type[] newList =  (Type[]) new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
        capacity *= 2;
        list = newList;
    }
}

