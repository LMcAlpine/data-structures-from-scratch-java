public class Main {

    public static void main(String[] args) {
        // write your code here

        MyTrie trie = new MyTrie();
        // myTrie.insert("there");
        //  myTrie.insert("the");

        trie.insert("a");
        trie.insert("an");
        trie.insert("and");
        trie.insert("android");
        trie.insert("androidos");
        System.out.println(trie);
//        myTrie.insert("in");
//        myTrie.insert("inn");
//        myTrie.insert("tea");
//        myTrie.insert("ted");
//        myTrie.insert("ten");
//        myTrie.insert("A");
//        myTrie.insert("Apple");
//        myTrie.insert("to");
//        myTrie.insert("Zebra");
//        //myTrie.insert("");
//        myTrie.insert("zoo");
//        myTrie.insert("boom");
//
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("Apple"));
//        System.out.println("Removing Apple");
//        myTrie.remove("Apple");
//        System.out.println(myTrie);
//
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("Apple"));
//
//        System.out.println("\n");
//        System.out.println(myTrie.find("Zebra"));
//        System.out.println("Removing Zebra");
//        myTrie.remove("Zebra");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("Zebra"));
//
//        System.out.println("\n");
//        System.out.println(myTrie.find("Zoo"));
//        System.out.println("Removing Zoo");
//        myTrie.remove("Zoo");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("Zoo"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("a"));
//        System.out.println("Removing a ");
//        myTrie.remove("a");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("a"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("b"));
//        System.out.println("Removing b");
//        myTrie.remove("b");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("b"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("A"));
//        System.out.println("Removing A");
//        myTrie.remove("A");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("A"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("boom"));
//        System.out.println("Removing boom");
//        myTrie.remove("boom");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("boom"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("boo"));
//        System.out.println("Removing boo");
//        myTrie.remove("boo");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("boo"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("inn"));
//        System.out.println("Removing inn");
//        myTrie.remove("inn");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("inn"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("tea"));
//        System.out.println("Removing tea");
//        myTrie.remove("tea");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("tea"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("ted"));
//        System.out.println("Removing ted");
//        myTrie.remove("ted");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("ted"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("ten"));
//        System.out.println("Removing ten");
//        myTrie.remove("ten");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("ten"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("to"));
//        System.out.println("Removing to");
//        myTrie.remove("to");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("to"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("zoo"));
//        System.out.println("Removing zoo");
//        myTrie.remove("zoo");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("zoo"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("in"));
//        System.out.println("Removing in");
//        myTrie.remove("in");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("in"));
//
//        System.out.println("\n");
//        System.out.println(myTrie);
//        System.out.println(myTrie.find("in"));
//        System.out.println("Removing in");
//        myTrie.remove("in");
//        System.out.println(myTrie);
//        System.out.println("Size " + myTrie.size());
//        System.out.println(myTrie.find("in"));


//        System.out.println(myTrie.find("there"));
//        System.out.println(myTrie.find("they"));
//        myTrie.remove("there");
//        System.out.println(myTrie.find("there"));
         UniqueWords uniqueWords = new UniqueWords();

    }
}
