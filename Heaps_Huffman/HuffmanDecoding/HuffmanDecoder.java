import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HuffmanDecoder {
    private String compressedFileName;
    private String codesFileName;
    private String outputFileName;

    // the string of codes read in from the codes file
    private String codesString;
    // the encoded binary string read in from the compressed file
    private byte[] encodedText;
    // a list that stores the codes assigned to each character by the Huffman algorithm
    private MyOrderedList<CodeNode> codes;
    // the uncompressed text of the book
    private String book;


    /**
     * constructor that calls the helper methods in the correct order to perform the Huffman's algorithm
     *
     * @throws IOException
     */
    public HuffmanDecoder() throws IOException {
        compressedFileName = "./WarAndPeace-compressed.bin";
        codesFileName = "./WarAndPeace-codes.txt";
        outputFileName = "./WarAndPeace-decompressed.txt";

//        compressedFileName = "./TestString-compressed.bin";
//        codesFileName = "./TestString-codes.txt";
//        outputFileName = ".TestString-decompressed.txt";

        codes = new MyOrderedList<CodeNode>();

        readFiles();
        buildCodes();
        rebuildText();
        writeFile();


    }

    /**
     * reads in the file containing the compressed message and the codes
     * @throws IOException
     */
    private void readFiles() throws IOException {

        long start = System.currentTimeMillis();

        // reads in the files containing the compressed message and the codes
        FileInputStream input_stream = new FileInputStream(compressedFileName);
        encodedText = input_stream.readAllBytes();


        FileInputStream code_stream = new FileInputStream(codesFileName);
        byte[] byte_codes = code_stream.readAllBytes();
        codesString = new String(byte_codes);
        // System.out.println(codesString);

        long end = System.currentTimeMillis();
        System.out.println("Reading compressed file and codes file... in " + (end - start) + " milliseconds");

    }


    /**
     * build the list of codes by parsing the String read in from the codes file
     */
    private void buildCodes() {
        long start = System.currentTimeMillis();
        // builds the list of codes by parsing the String read in from the codes file

        // may call split on the string to separate the codes

        // extract the character and the code from the string and create a CodeNode from them and insert it into the list


        // System.out.println(codesString);


        // the string read in from the codes file
        StringBuilder stringBuilder = new StringBuilder(codesString);


        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        codesString = stringBuilder.toString();

        // an array of strings that is splitting on each comma
        String[] strings = codesString.split(", ");

        // iterate through the strings array and create a CodeNode at
        for (int i = 0; i < strings.length; i++) {
            CodeNode codeNode = new CodeNode(strings[i].charAt(0), strings[i].substring(2));
            codes.add(codeNode);
        }


        long end = System.currentTimeMillis();
        System.out.println("Rebuilding codes list... " + codes.size() + " codes found in " + (end - start) + " milliseconds");

    }

    private String getBit(int pos) {
        // extracts the bit in position pos from the byte array
        // Integer valInt = valByte>>(8-(pos+1)) & 0x0001;


        int posOfByte = pos / 8;
        int posBit = pos % 8;
        byte valueOfByte = encodedText[posOfByte];
        Integer valInt = valueOfByte >> (8 - (posBit + 1)) & 0x0001;
        return valInt.toString();


    }

    private void rebuildText() {
        // uses bytes and codes to create book

        // searches for the first prefix of the uncoded message that has a code in codes
        // when found it adds the appropriate character to book


        long start = System.currentTimeMillis();
        StringBuilder tempCodeString = new StringBuilder();
        for (int i = 0; i < encodedText.length; i++) {
            tempCodeString.append(rebuildCodeString(i));
        }
        //      System.out.println(tempCodeString);


        //  System.out.println(tempString);


        StringBuilder bookTemp = new StringBuilder();

        StringBuilder str = new StringBuilder();

        StringBuilder currCode = new StringBuilder();

        for (int i = 0; i < tempCodeString.length(); i++) {
            currCode.append(getBit(i));
            CodeNode node = codes.binarySearch(new CodeNode(currCode.toString()));
            if (node != null) {
                bookTemp.append(node.character);
                currCode = new StringBuilder();

            }


        }


        book = bookTemp.toString();
        long end = System.currentTimeMillis();
        System.out.println("Decoding text... " + encodedText.length + " characters decoded in " + (end - start) + " milliseconds");
    }

    private String rebuildCodeString(int pos) {
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            Integer valInt = encodedText[pos] >> (8 - (i + 1)) & 0x0001;
            tempString.append(valInt);
        }
        //    System.out.println(tempString);
        return tempString.toString();
    }

    private void writeFile() throws FileNotFoundException {
        long start = System.currentTimeMillis();

        // write the contents of book to the outputFileName
        PrintWriter writer = new PrintWriter(outputFileName);
        // System.out.println(book.length());
        writer.println(book);
        writer.close();
        long end = System.currentTimeMillis();
        System.out.println("Writing decompressed file... " + book.length() + " bytes written in " + (end - start) + " milliseconds");
    }


    private class CodeNode implements Comparable<CodeNode> {
        public Character character;
        public String code;

        private String bit;

        public CodeNode(Character character, String code) {
            this.character = character;
            this.code = code;
        }

        public CodeNode() {

        }

        public CodeNode(String code) {
            this.code = code;
        }

        public int compareTo(CodeNode other) {
            return code.compareTo(other.code);
        }

        public String toString() {
            return character + ":" + code;
        }

    }

}
