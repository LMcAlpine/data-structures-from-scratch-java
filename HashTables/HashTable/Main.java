public class Main {

    public static void main(String[] args) {
        // write your code here
        UniqueWords uniqueWords = new UniqueWords();
        MyHashTable<Integer, Integer> myHashTable = new MyHashTable<Integer, Integer>(32768);

//        for (int i = 0; i < 255; i++) {
//            myHashTable.put(i, 1);
//        }

//        int[] array = {3, 27, 51, 30, 77, 147, 11, 196, 221, 176, 40, 18, 66, 251};
//        for (int i = 0; i < array.length; i++) {
//            myHashTable.put(array[i], 1);
//        }
//        myHashTable.put(148, 1);
//        myHashTable.put(8,1);
//        myHashTable.put(80,1);
//        myHashTable.put(100,1);
//        myHashTable.put(22,1);
//        myHashTable.put(45,1);
//        System.out.println(myHashTable);
//        System.out.println(myHashTable.maxProbe);

        System.out.println(myHashTable);

        myHashTable.put(0, 10);
        myHashTable.put(32769, 11);
        myHashTable.put(2, 12);
        System.out.println(myHashTable);
        System.out.println("Size " + myHashTable.size());
        System.out.println("Comparisons " + myHashTable.comparisons);
        System.out.println("Max probe " + myHashTable.maxProbe);

        System.out.println(0 % 3);
        System.out.println(32769 % 3);
        //   System.out.println(uniqueWords.toString());


    }
}
