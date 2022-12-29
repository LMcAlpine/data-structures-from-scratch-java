import java.util.Scanner;
import java.io.*;

public class BookReader {
    String book;
    MyLinkedList<String> words;

    MyLinkedList<String> wordsAndSeparators;


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

    public BookReader(String filename) {
        try {
            book = "";
            words = new MyLinkedList<>();
            wordsAndSeparators = new MyLinkedList<>();
            System.out.print("Reading: " + filename + "...");
            startTimer();
            readBook(filename);
            endTimer();
            System.out.println("found " + book.length() + " characters in " + getDuration() + " ms.");

            System.out.print("Parsing words...");
            startTimer();
            parseWords();
            endTimer();
            System.out.println("found " + words.size() + " words in " + getDuration() + " ms.\n");
            //System.out.println(words);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //"D:\\WarAndPeace.txt"
    public void readBook(String filename) throws IOException {
        File f = new File(filename);     //Creation of File Descriptor for input file
        FileReader fr = new FileReader(f);   //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr);  //Creation of BufferedReader object
        int c = 0;
        StringBuilder builder = new StringBuilder();
        while ((c = br.read()) != -1)         //Read char by Char
        {
            // char character = (char) c;          //converting integer to char
            //System.out.println(character);        //Display the Character
            // only append the valid character

            builder.append((char) c);


        }
        book = builder.toString();
    }

    public void parseWords() {
//        Scanner scan = new Scanner(book);
//        while (scan.hasNext()) {
//            words.addBefore(scan.next());
//        }

        StringBuilder theWord = new StringBuilder();

        for (int i = 0; i < book.length(); i++) {
            Character character = book.charAt(i);


            if ((character.compareTo('A') >= 0 && character.compareTo('Z') <= 0)
                    || (character.compareTo('a') >= 0 && character.compareTo('z') <= 0)
                    || (character.compareTo('0') >= 0 && character.compareTo('9') <= 0) || character.equals('\'')) {
                theWord.append(character);
            } else {
                if (!theWord.isEmpty()) {
                    words.addBefore(theWord.toString());
                    //  theWord.append(character);
                    wordsAndSeparators.addBefore(theWord.toString());
                    theWord.delete(0, theWord.length());
                    theWord.append(character);
                    wordsAndSeparators.addBefore(theWord.toString());
                    theWord.delete(0, theWord.length());
                } else {
                    theWord.append(character);
                    wordsAndSeparators.addBefore(theWord.toString());
                    theWord.delete(0, theWord.length());
                }

            }
        }
        if (theWord.length() != 0) {
            words.addBefore(theWord.toString());
            wordsAndSeparators.addBefore(theWord.toString());

        }
    }
}
