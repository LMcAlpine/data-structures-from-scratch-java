import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HuffmanEncoder {
    private String inputFileName;
    private String outputFileName;

    private String codesFileName;
    private BookReader book;
    private MyOrderedList<FrequencyNode> frequencies;

    private HuffmanNode huffmanTree;

    private MyOrderedList<CodeNode> codes;

    private byte[] encodedText;


    public HuffmanEncoder() throws IOException {
//        inputFileName = "./WarAndPeace.txt";
//        outputFileName = "./WarAndPeace-compressed.bin";
//        codesFileName = "./WarAndPeace-codes.txt";
        inputFileName = "TestString.txt";
        outputFileName = "./TestString-compressed.bin";
        codesFileName = "./TestString-codes.txt";
        book = new BookReader(inputFileName);
        frequencies = new MyOrderedList<FrequencyNode>();
        codes = new MyOrderedList<CodeNode>();
        //huffmanTree = new HuffmanNode();
        countFrequency();
        buildTree();
        encode();
        writeFiles();


    }

    private void countFrequency() {

        long start = System.currentTimeMillis();

        //   System.out.println("book.book length " + book.book.length());
        for (int i = 0; i < book.book.length(); i++) {
            FrequencyNode node = frequencies.binarySearch(new FrequencyNode(book.book.charAt(i), 0));
            if (node == null) {
                frequencies.add(new FrequencyNode(book.book.charAt(i), 1));
            } else {
                //  FrequencyNode newNode = new FrequencyNode(book.book.charAt(i));
                node.count++;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Counting frequencies of characters... " + frequencies.size() + " unique characters found in " + (end - start) + " milliseconds");


    }

    private void buildTree() {
        long start = System.currentTimeMillis();

        MyPriorityQueue<HuffmanNode> myPriorityQueue = new MyPriorityQueue<HuffmanNode>();
        for (int i = 0; i < frequencies.size(); i++) {
            FrequencyNode newNode = frequencies.get(i);
            HuffmanNode huffmanNode = new HuffmanNode(newNode.character, newNode.count);
            myPriorityQueue.insert(huffmanNode);

        }

        // loop through the priority queue to build the tree
        while (myPriorityQueue.size() > 1) {
            HuffmanNode left = myPriorityQueue.removeMin();
            HuffmanNode right = myPriorityQueue.removeMin();
            HuffmanNode root = new HuffmanNode(left, right);
            myPriorityQueue.insert(root);
            // merge huffman nodes until only a single tree (root) remains

            // left =
            // right =
            // weight

            //   1
            // 2   3

            // 1, 2, 3

            //

            //
            //
        }
        huffmanTree = myPriorityQueue.removeMin();
        extractCodes(huffmanTree, "");
        long end = System.currentTimeMillis();
        System.out.println("Building a Huffman tree and reading codes...  in " + (end - start) + " milliseconds");


    }

    private void extractCodes(HuffmanNode root, String code) {
        // when a leaf is reached
        if (root.left == null && root.right == null) {
            codes.add(new CodeNode(root.character, code));
        } else {
            extractCodes(root.left, code + "0");
            extractCodes(root.right, code + "1");
        }

    }

    private void encode() {

        long start = System.currentTimeMillis();
        StringBuilder s = new StringBuilder();


        CodeNode codeNode = new CodeNode();

        for (int i = 0; i < book.book.length(); i++) {
            codeNode.character = book.book.charAt(i);
            s.append(codes.binarySearch(codeNode).code);

        }
        encodedText = new byte[(int) (s.length() / 8) + 1];

        String h;


        int j = 0;
        // check how many bits are left over
        int remainder = s.length() % 8;
        if (remainder != 0) {
            for (; remainder <= 8; remainder++) {
                s.append(0);
            }
        }

        for (int i = 8; i <= s.length(); i += 8) {
            h = s.substring(i - 8, i);

            Byte b = (byte) Integer.parseInt(h, 2);
            encodedText[j] = b;
            j++;

        }
        long end = System.currentTimeMillis();
        //  System.out.println(s);
        // System.out.println(codes);
        // System.out.println(frequencies);
        System.out.println("Encoding message... in " + (end - start) + " milliseconds");


        // String str = s.toString();


    }

    private void writeFiles() {

        long start = System.currentTimeMillis();


        try {
            FileOutputStream outputStream = new FileOutputStream(outputFileName);
            outputStream.write(encodedText);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        byte[] fileOutput = codes.toString().getBytes();


        try {
            FileOutputStream outputStream = new FileOutputStream(codesFileName);
            outputStream.write(fileOutput);
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        //  System.out.println(encodedText[encodedText.length-1]);
        System.out.println("Writing compressed file... " + encodedText.length + " bytes written in " + (end - start) + " milliseconds");

    }


    private class FrequencyNode implements Comparable<FrequencyNode> {
        public Character character;
        public Integer count;

        public FrequencyNode(Character character, Integer count) {
            this.character = character;
            this.count = count;
        }

        public int compareTo(FrequencyNode other) {
            return character.compareTo(other.character);
        }

        public String toString() {
            return character + ":" + count;
        }
    }

    private class HuffmanNode implements Comparable<HuffmanNode> {
        public Character character;
        public Integer weight;


        public HuffmanNode left;
        public HuffmanNode right;

        public HuffmanNode(Character ch, Integer wt) {
            this.character = ch;
            this.weight = wt;

        }

        public HuffmanNode(HuffmanNode left, HuffmanNode right) {
            this.left = left;
            this.right = right;
            weight = left.weight + right.weight;

        }


        public int compareTo(HuffmanNode other) {
            return this.weight.compareTo(other.weight);
        }

        public String toString() {
            return character + ":" + weight;
        }
    }

    private class CodeNode implements Comparable<CodeNode> {
        public Character character;
        public String code;

        public CodeNode(Character character, String code) {
            this.character = character;
            this.code = code;
        }

        public CodeNode() {

        }


        public int compareTo(CodeNode other) {
            return character.compareTo(other.character);
        }

        public String toString() {
            return character + ":" + code;
        }
    }


}
