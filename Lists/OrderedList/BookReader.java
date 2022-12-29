import java.util.Scanner;
import java.io.*;

public class BookReader {
    String book;
    MyLinkedList<String> words;


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
            char character = (char) c;          //converting integer to char
            //System.out.println(character);        //Display the Character
            // only append the valid character

            if (character == '\'' || (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z') ||
                    (character >= '0' && character <= '9') || character == ' ') {
                builder.append(character);
            } else {
                builder.append(" ");
            }
        }
        book = builder.toString();
    }

    public void parseWords() {
        Scanner scan = new Scanner(book);
        while (scan.hasNext()) {
            words.addBefore(scan.next());
        }
    }
}
