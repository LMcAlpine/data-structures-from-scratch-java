public class UniqueWords {
    BookReader book;

    public UniqueWords() {
        book = new BookReader("./WarAndPeace.txt");
        addUniqueWordsToLinkedList();
        addUniqueWordsToArrayList();
        addUniqueWordsToOrderedList();
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

    public void addUniqueWordsToArrayList() {
        //contains

        startTimer();
        MyArrayList temp = new MyArrayList();

        book.words.first();
        int i = 0;
        while (book.words.current() != null) {
            //if temp doesn't contain the word, add in
            if (!temp.contains(book.words.current())) {
                temp.insert(book.words.current(), i++);
            }
            book.words.next();
        }
        endTimer();

        System.out.println("\nAdding unique words to an array list... in " + getDuration() / 1000 + " seconds");
        System.out.println(temp.size() + " unique words");
        System.out.println(temp.comparisons + " comparisons");

        startTimer();
        temp.sort();
       // System.out.println(temp);
        endTimer();
        System.out.println("Merge sorting array list... in " + getDuration() / 1000 + " seconds");

    }

    public void addUniqueWordsToOrderedList() {
        //binary search
        startTimer();
        MyOrderedList temp = new MyOrderedList();

        book.words.first();

        while (book.words.current() != null) {
            //if temp doesn't contain the word, add in
            if (!temp.binarySearch(book.words.current())) {
                temp.add(book.words.current());
            }
            book.words.next();
        }
        endTimer();
     //   System.out.println(temp);

        System.out.println("\nAdding unique words to ordered list... in " + getDuration() / 1000 + " seconds");
        System.out.println(temp.size() + " unique words");
        System.out.println(temp.comparisons + " comparisons");


    }

}
