public class MyHashTable<Key extends Comparable<Key>, Value> {
    private Integer capacity;
    private Key[] keyBuckets;
    private Value[] valueBuckets;
    private Integer size;
    public MyArrayList<Key> keys;
    public Integer comparisons;
    public Integer maxProbe;

    public MyHashTable(Integer capacity) {
        this.capacity = capacity;
        keyBuckets = (Key[]) new Comparable[capacity];
        valueBuckets = (Value[]) new Comparable[capacity];
        this.size = 0;
        this.keys = new MyArrayList<>();
        this.comparisons = 0;
        this.maxProbe = 0;
    }

    private Integer hash(Key key) {
        int temp = key.hashCode();
        return Math.abs(temp % capacity);


    }

    public Value get(Key key) {


        int i = hash(key);
        while (keyBuckets[i] != null) {
            if (keyBuckets[i].equals(key)) {
                return valueBuckets[i];
            }
            i = (i == keyBuckets.length - 1) ? 0 : i + 1;

//            if (i == keyBuckets.length - 1) {
//                i = 0;
//                System.out.println("AM I HERE");
//                comparisons++;
//            }
//            i += 1;


            //   System.out.println(i);
        }
        //System.out.println("here2");


        return null;

    }

    public void put(Key key, Value value) {
        //put the key into key bucket
        // put the value into value bucket

        int tmp = 0;

        int i = hash(key);
        while (keyBuckets[i] != null) {
            if (keyBuckets[i].equals(key)) {
                valueBuckets[i] = value;
                return;
            }
//            flag = false;
            i = (i == keyBuckets.length - 1) ? 0 : i + 1;
            comparisons++;
            tmp++;

//            if (i == keyBuckets.length - 1) {
//                i = 0;
//            } else {
//                comparisons++;
//                tmp++;
//                i += 1;
//            }

        }

        if (keyBuckets[i] == null) {
            keyBuckets[i] = key;
            valueBuckets[i] = value;
            size++;
            keys.insert(key, size - 1);

            comparisons++;
            tmp++;
        }

        if (tmp > maxProbe) {
            maxProbe = tmp;
        }


    }


    public Integer size() {
        return size;
    }

    public String toString() {

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < capacity; i++) {


            if (keyBuckets[i] != null) {
                //s.append(keys.get(i)).append(":").append(valueBuckets[i]).append(", ");
                s.append(keyBuckets[i]).append(":").append(valueBuckets[i]).append(", ");
            }

        }
        String string = s.toString();
        int end = Math.max(0, s.length() - 2);
        return "[" + string.substring(0, end) + "]";
    }


}
