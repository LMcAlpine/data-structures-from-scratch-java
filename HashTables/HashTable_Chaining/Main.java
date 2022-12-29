import java.security.Key;

public class Main {

    public static void main(String[] args) {
        // write your code here
        MyHashTable<Integer, Integer> myHashTable = new MyHashTable<Integer, Integer>(23, true);
//        myHashTable.put(4,8);
//        System.out.println(myHashTable);
//        myHashTable.put(5,6);
//        myHashTable.put(3,7);
//        myHashTable.put(1,1);
//        myHashTable.put(5,3);
//        System.out.println(myHashTable.maxChain);
//        System.out.println(myHashTable);


        System.out.println(myHashTable);


        int[] a = {3, 27, 51, 30, 77, 147, 148, 11, 196, 221, 176, 40, 18, 66, 251};
        for (int i = 0; i < a.length; i++) {
            myHashTable.put(a[i], 1);
        }
        System.out.println(myHashTable);
        myHashTable.put(8, 1);
        System.out.println(myHashTable);
        System.out.println(myHashTable.get(8));
        myHashTable.put(100, 1);
        System.out.println(myHashTable);
        myHashTable.put(80, 1);
        System.out.println(myHashTable);
        myHashTable.put(-10000, 5);
        System.out.println(myHashTable);


        System.out.println(myHashTable.get(0));


        UniqueWords uniqueWords = new UniqueWords();

    }
}
