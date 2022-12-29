public class MyPriorityQueue<Type extends Comparable<Type>> {
    private MyArrayList<Type> heap = new MyArrayList<Type>();


    public void insert(Type item) {
        heap.insert(item, size());
        bubbleUp();
    }

    public Type removeMin() {
        //  Type current = heap.get(0);

        swap(0, heap.size() - 1);


        Type elementRemoved = heap.remove(heap.size() - 1);
        sinkDown();
        return elementRemoved;

    }

    public Type min() {
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public String toString() {
        return heap.toString();
    }

    private void bubbleUp() {
        int currentIndex = size() - 1;

        while (heap.get(currentIndex).compareTo(heap.get(parent(currentIndex))) < 0) {
            swap(currentIndex, parent(currentIndex));
            currentIndex = parent(currentIndex);


        }


        // while current < parent : swap(current,parent)


    }

    private void swap(int currentIndex, int value) {
        Type temp = heap.get(currentIndex);
        // set current to be the parent
        heap.set(currentIndex, heap.get(value));
        // set parent to be current
        heap.set(value, temp);

    }

    private void sinkDown() {

        // while current > child : swap(current, least-child)


        int currentIndex = 0;
        // if left exists then the smallest is left
        while (left(currentIndex) < size()) {

            int smallest = left(currentIndex);


            if (right(currentIndex) < size()) {
                if (heap.get(smallest).compareTo(heap.get(right(currentIndex))) > 0) {
                    smallest = right(currentIndex);
                    //  swap(currentIndex, smallest);
                    // currentIndex = smallest;
                }
            }


            if (heap.get(smallest).compareTo(heap.get(currentIndex)) < 0) {
                //    smallest = right(currentIndex);
                swap(currentIndex, smallest);
                currentIndex = smallest;
            } else {
                break;
            }


        }


    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int right(int index) {
        return (index * 2) + 2;
    }

    private int left(int index) {
        return (index * 2) + 1;
    }
}
