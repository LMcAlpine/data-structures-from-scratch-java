import com.sun.jdi.Value;

import java.awt.*;
import java.security.Key;

public class MyHashTable<Key extends Comparable<Key>, Value> {
    private Integer capacity;
    private Key[] keyBuckets;
    private Value[] valueBuckets;
    private Integer size;
    public MyArrayList<Key> keys;
    public Integer comparisons;
    public Integer maxProbe;
    public Integer maxChain;


    private boolean chaining;
    private MyArrayList<KeyValuePair>[] chainBuckets;

    public MyHashTable(Integer capacity, boolean chaining) {
        this.capacity = capacity;
//        keyBuckets = (Key[]) new Comparable[capacity];
//        valueBuckets = (Value[]) new Comparable[capacity];
        chainBuckets = (MyArrayList<KeyValuePair>[]) new MyArrayList[capacity];


        this.size = 0;
        this.keys = new MyArrayList<>();
        this.comparisons = 0;
        //    this.maxProbe = 0;
        this.maxChain = 0;
        this.chaining = chaining;
    }

    public MyHashTable(Integer capacity) {
        this.capacity = capacity;
        keyBuckets = (Key[]) new Comparable[capacity];
        valueBuckets = (Value[]) new Comparable[capacity];
        this.size = 0;
        this.keys = new MyArrayList<>();
        this.comparisons = 0;
        this.maxProbe = 0;
        this.chaining = false;
    }

    private Integer hash(Key key) {
        int temp = key.hashCode();
        return Math.abs(temp % capacity);


    }

    public Value get(Key key) {


        int i = hash(key);

        if (chainBuckets[i] == null) {
            return null;
        } else {

            for (int j = 0; j < chainBuckets[i].size(); j++) {
                if (chainBuckets[i].get(j).key.compareTo(key) == 0) {
                    return chainBuckets[i].get(j).value;
                }
            }

        }


        return null;

    }

    public void put(Key key, Value value) {
        //put the key into key bucket
        // put the value into value bucket


        int i = hash(key);


        KeyValuePair keyValuePair = new KeyValuePair(key, value);

        if (chainBuckets[i] == null) {
            chainBuckets[i] = new MyArrayList<KeyValuePair>();
            chainBuckets[i].insert(keyValuePair, chainBuckets[i].size());
            comparisons++;
            size++;
        } else {

            for (int j = 0; j < chainBuckets[i].size(); j++) {

                if (chainBuckets[i].get(j).key.compareTo(key) == 0) {

                    //  System.out.println("Here");
                    chainBuckets[i].set(j, keyValuePair);
                    //comparisons++;
                    break;
                }

                // if key wasn't found
                else if (!chainBuckets[i].contains(keyValuePair)) {
                    chainBuckets[i].insert(keyValuePair, chainBuckets[i].size());
                    size++;
                    comparisons++;

                }
                comparisons++;


            }
            if (chainBuckets[i].size() > maxChain) {
                maxChain = chainBuckets[i].size();
            }


        }


    }


    public Integer size() {
        return size;
    }

    public String toString() {

        if (size == 0) {
            return "[]";
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < capacity; i++) {


            if (chainBuckets[i] != null) {
                //s.append(keys.get(i)).append(":").append(valueBuckets[i]).append(", ");

                s.append(chainBuckets[i]).append(", ");

            }

        }

        String string = s.toString();
        string = string.replace("[", "").replace("]", "");
        //string.replace('[', ' ');


        //  int end = Math.max(0, s.length() - 2);
        return "[" + string.substring(0, string.length() - 2) + "]";
    }


    private class KeyValuePair implements Comparable<KeyValuePair> {
        public Key key;
        public Value value;

        private KeyValuePair(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return key + ":" + value;
        }

        @Override
        public int compareTo(KeyValuePair other) {
            return key.compareTo(other.key);
        }
    }


}
