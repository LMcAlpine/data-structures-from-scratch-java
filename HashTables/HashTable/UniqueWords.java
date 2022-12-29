public class UniqueWords {
    BookReader book;

    public UniqueWords() {
        book = new BookReader("./WarAndPeace.txt");
        //    book = new BookReader("./Test.txt");
        //addUniqueWordsToLinkedList();
//        addUniqueWordsToArrayList();
//        addUniqueWordsToOrderedList();
        //  addUniqueWordsToBST();

        //   addUniqueWordsToAVL();
        //   addUniqueWordsToRedBlack();
        addUniqueWordsToHashTable();
    }

    private static long startTime;
    private static long endTime;

    private static void startTimer() {
        startTime = System.currentTimeMillis();
    }

    private static void endTimer() {
        endTime = System.currentTimeMillis();
    }

    private static long getDuration() {
        return endTime - startTime;
    }

    public void addUniqueWordsToHashTable() {
        //        //contains

        startTimer();
        MyHashTable temp = new MyHashTable(32768);
        //MyHashTable temp = new MyHashTable(7);

        book.words.first();
        int i = 0;
        while (book.words.current() != null) {
            //if temp doesn't contain the word, add in
            if (temp.get(book.words.current()) == null) {
                temp.put(book.words.current(), 1);
            }
            book.words.next();
        }
        endTimer();

        System.out.println("\nAdding unique words to a hash table... in " + getDuration() + " milliseconds");
        System.out.println(temp.size() + " unique words");
        System.out.println(temp.comparisons + " comparisons");
        System.out.println(temp.maxProbe + " max probe");
        startTimer();
        temp.toString();

        endTimer();
        System.out.println("Extracting the key-value pairs... in " + getDuration() + " milliseconds.");

        //System.out.println(temp.toString());
        startTimer();
        //  temp.sort();
        // System.out.println(temp);
        endTimer();
        // System.out.println("Merge sorting array list... in " + getDuration() / 1000 + " seconds");
    }

//    public void addUniqueWordsToRedBlack() {
//        startTimer();
//        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();
//        book.words.first();
//        while (book.words.current() != null) {
//            if (myBinarySearchTree.find(book.words.current()) == null) {
//                myBinarySearchTree.add(book.words.current());
//            }
//            book.words.next();
//        }
//
//        endTimer();
//        System.out.println("Adding unique words to a red black tree... in " + (getDuration()) + " milliseconds");
//        System.out.println(myBinarySearchTree.size() + " unique words");
//        System.out.println(myBinarySearchTree.height() + " height");
//        System.out.println(myBinarySearchTree.comparisons + " comparisons");
//        System.out.println(myBinarySearchTree.rotations + " rotations");
//        startTimer();
//        myBinarySearchTree.toString();
//        endTimer();
//        System.out.println("Traversing the red black tree...  in " + getDuration() + " milliseconds");
//    }
//
//    public void addUniqueWordsToAVL() {
//        startTimer();
//        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree(true);
//        book.words.first();
//        while (book.words.current() != null) {
//            if (myBinarySearchTree.find(book.words.current()) == null) {
//                myBinarySearchTree.add(book.words.current());
//            }
//            book.words.next();
//        }
//
//        endTimer();
//        System.out.println("Adding unique words to a binary search tree... in " + (getDuration()) + " milliseconds");
//        System.out.println(myBinarySearchTree.size() + " unique words");
//        System.out.println(myBinarySearchTree.height() + " height");
//        System.out.println(myBinarySearchTree.comparisons + " comparisons");
//        System.out.println(myBinarySearchTree.rotations + " rotations");
//        startTimer();
//        myBinarySearchTree.toString();
//        endTimer();
//        System.out.println("Traversing the AVL...  in " + getDuration() + " milliseconds");
//    }
//
//    public void addUniqueWordsToBST() {
//        startTimer();
//        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();
//        book.words.first();
//        while (book.words.current() != null) {
//            if (myBinarySearchTree.find(book.words.current()) == null) {
//                myBinarySearchTree.add(book.words.current());
//            }
//            book.words.next();
//        }
//
//        endTimer();
//        System.out.println("Adding unique words to a binary search tree... in " + (getDuration()) + " milliseconds");
//        System.out.println(myBinarySearchTree.size() + " unique words");
//        System.out.println(myBinarySearchTree.height() + " height");
//        System.out.println(myBinarySearchTree.comparisons + " comparisons");
//        startTimer();
//        myBinarySearchTree.toString();
//        endTimer();
//        System.out.println("Traversing the binary search tree in... " + getDuration() + " milliseconds");
//
//
//    }

    public void addUniqueWordsToLinkedList() {
        startTimer();
        MyLinkedList temp = new MyLinkedList();

        book.words.first();
        while (book.words.current() != null) {
            //if temp doesn't contain the word, add in
            if (!temp.contains(book.words.current())) {
                temp.addBefore(book.words.current());
            }
            book.words.next();
        }
        endTimer();
        System.out.println("Adding unique words to a linked list... in " + getDuration() / 1000 + " seconds");
        System.out.println(temp.size() + " unique words");
        System.out.println(temp.comparisons + " comparisons");

        startTimer();
        temp.sort();
        //System.out.println(temp);
        endTimer();
        System.out.println("Bubble sorting linked list... in " + getDuration() / 1000 + " seconds");


    }

//    public void addUniqueWordsToArrayList() {
//        //contains
//
//        startTimer();
//        MyArrayList temp = new MyArrayList();
//
//        book.words.first();
//        int i = 0;
//        while (book.words.current() != null) {
//            //if temp doesn't contain the word, add in
//            if (!temp.contains(book.words.current())) {
//                temp.insert(book.words.current(), i++);
//            }
//            book.words.next();
//        }
//        endTimer();
//
//        System.out.println("\nAdding unique words to an array list... in " + getDuration() / 1000 + " seconds");
//        System.out.println(temp.size() + " unique words");
//        System.out.println(temp.comparisons + " comparisons");
//
//        startTimer();
//        temp.sort();
//       // System.out.println(temp);
//        endTimer();
//        System.out.println("Merge sorting array list... in " + getDuration() / 1000 + " seconds");
//
//    }

//    public void addUniqueWordsToOrderedList() {
//        //binary search
//        startTimer();
//        MyOrderedList temp = new MyOrderedList();
//
//        book.words.first();
//
//        while (book.words.current() != null) {
//            //if temp doesn't contain the word, add in
//            if (!temp.binarySearch(book.words.current())) {
//                temp.add(book.words.current());
//            }
//            book.words.next();
//        }
//        endTimer();
//     //   System.out.println(temp);
//
//        System.out.println("\nAdding unique words to ordered list... in " + getDuration() / 1000 + " seconds");
//        System.out.println(temp.size() + " unique words");
//        System.out.println(temp.comparisons + " comparisons");
//
//
//    }

}
