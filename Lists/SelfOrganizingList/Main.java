public class Main {

    public static void main(String[] args) {
        // write your code here

//        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
//        System.out.println(myLinkedList);
//        myLinkedList.addBefore(1);
//        System.out.println(myLinkedList);
//        myLinkedList.addBefore(2);
//        System.out.println(myLinkedList);
//        myLinkedList.addBefore(3);
//        System.out.println(myLinkedList);
//        System.out.println("First " + myLinkedList.first());
//        myLinkedList.addAfter(4);
//        System.out.println(myLinkedList);
//        System.out.println("Current " + myLinkedList.current());
//        System.out.println("Next " + myLinkedList.next());
//        System.out.println(myLinkedList);
//        System.out.println("Current " + myLinkedList.current());


        MTFList<Integer> mtfList = new MTFList<Integer>();
        mtfList.add(1);
        mtfList.add(2);
        mtfList.add(3);
        mtfList.add(4);
        mtfList.add(5);
        mtfList.add(6);
        System.out.println(mtfList);

        mtfList.find(5);
        System.out.println(mtfList);
        mtfList.find(5);
        System.out.println(mtfList);

        TransposeList<Integer> transposeList = new TransposeList<Integer>();

//        transposeList.add(1);
//        transposeList.add(2);
//        transposeList.add(5);
//        transposeList.add(4);
//        transposeList.add(3);
//        transposeList.add(6);
//        System.out.println(transposeList);
//        transposeList.find(0);
//        System.out.println(transposeList);

        transposeList.add(1);
        transposeList.add(2);
        transposeList.add(3);
        transposeList.add(4);
        transposeList.add(5);
        transposeList.add(6);

        System.out.println(transposeList);

        transposeList.find(5);
        System.out.println(transposeList);
        transposeList.find(5);
        System.out.println(transposeList);
        transposeList.find(4);
        System.out.println(transposeList);
        transposeList.find(1);
        System.out.println(transposeList);
        transposeList.find(0);

//        MTFList<Integer> mtfList = new MTFList<Integer>();
////        mtfList.add(3);
////        System.out.println(mtfList);
////        mtfList.add(4);
////        System.out.println(mtfList);
////        mtfList.add(6);
////        System.out.println(mtfList);
//////        mtfList.find(4);
//////        System.out.println(mtfList);
////        mtfList.remove(4);
////        System.out.println(mtfList);
////        mtfList.find(3);
////        System.out.println(mtfList);
//        System.out.println("Size " + mtfList.size());
//        mtfList.add(1);
//        System.out.println("Size " + mtfList.size());
//        mtfList.add(2);
//        System.out.println("Size " + mtfList.size());
//        mtfList.add(3);
//        System.out.println("Size " + mtfList.size());
//        mtfList.add(4);
//        System.out.println("Size " + mtfList.size());
//        mtfList.add(5);
//        System.out.println("Size " + mtfList.size());
//        mtfList.add(6);
//        System.out.println("Size " + mtfList.size());
//        System.out.println(mtfList);
//
//        mtfList.find(5);
//
//        System.out.println(mtfList);
//        System.out.println("Size " + mtfList.size());
//        mtfList.find(4);
//        System.out.println(mtfList);
//        mtfList.find(1);
//        System.out.println(mtfList);
//        System.out.println(mtfList.find(0));
//        System.out.println(mtfList);
//        System.out.println("Size before remove " + mtfList.size());
//        System.out.println(mtfList.remove(2));
//        System.out.println("Size after remove " + mtfList.size());
//        System.out.println(mtfList);
//        System.out.println("Size before remove " + mtfList.size());
//        System.out.println(mtfList.remove(0));
//        System.out.println("Size after remove " + mtfList.size());
//        System.out.println(mtfList);
//
//        System.out.println(mtfList.find(3));
//        System.out.println(mtfList);
//
//        System.out.println(mtfList.find(6));
//        System.out.println(mtfList);
//
//        System.out.println("Size before remove " + mtfList.size());
//        mtfList.remove(6);
//        System.out.println(mtfList);
//        System.out.println("Size after remove " + mtfList.size());
//
//        System.out.println("\n");
//
//        System.out.println(mtfList);
//        System.out.println("Size before remove " + mtfList.size());
//        mtfList.remove(3);
//        System.out.println(mtfList);
//        System.out.println("Size after remove " + mtfList.size());
//
//        System.out.println("\n");
//
//        System.out.println(mtfList);
//        System.out.println("Size before remove " + mtfList.size());
//        mtfList.remove(2);
//        System.out.println(mtfList);
//        System.out.println("Size after remove " + mtfList.size());
//
//        System.out.println("\n");
//
//        System.out.println(mtfList);
//        System.out.println("Size before remove " + mtfList.size());
//        mtfList.remove(1);
//        System.out.println(mtfList);
//        System.out.println("Size after remove " + mtfList.size());
//
//        System.out.println("\n");
//
//        System.out.println(mtfList);
//        System.out.println("Size before remove " + mtfList.size());
//        mtfList.remove(4);
//        System.out.println(mtfList);
//        System.out.println("Size after remove " + mtfList.size());
//
//        System.out.println(mtfList);
//        System.out.println("\n");
//
//        System.out.println("Size before remove " + mtfList.size());
//        System.out.println(mtfList.remove(5));
//        System.out.println(mtfList);
//        System.out.println("Size after remove " + mtfList.size());
//
//        System.out.println("\n");
//
//        System.out.println(mtfList);
//        System.out.println("Size before remove " + mtfList.size());
//        mtfList.remove(4);
//        System.out.println(mtfList);
//        System.out.println("Size after remove " + mtfList.size());
//
//        System.out.println(mtfList.isEmpty());

//        System.out.println("\n");
//        TransposeList<Integer> transposeList = new TransposeList<Integer>();
//        System.out.println(transposeList);
//        System.out.println("Size " + transposeList.size());
//        transposeList.add(1);
//
//        System.out.println(transposeList);
//        System.out.println("Size " + transposeList.size());
//        transposeList.add(2);
//        System.out.println(transposeList);
//        System.out.println("Size " + transposeList.size());
//        for (int i = 3; i < 10; i++) {
//            transposeList.add(i);
//        }
//        System.out.println(transposeList);
//        System.out.println("Size " + transposeList.size());
//        transposeList.remove(5);
//        System.out.println(transposeList);
//        System.out.println("Size " + transposeList.size());
//
//        System.out.println("Finding 3");
//        transposeList.find(3);
//        System.out.println(transposeList);
//        System.out.println("Finding 3 ");
//        transposeList.find(3);
//        System.out.println(transposeList);
//        System.out.println("Finding 9");
//        transposeList.find(9);
//        System.out.println(transposeList);
//        transposeList.find(4);
//        System.out.println(transposeList);
//
//        transposeList.find(80);
//        System.out.println(transposeList);
//
//        System.out.println("Size " + transposeList.size());
//        System.out.println("\n");
//
//        transposeList.remove(3);
//        System.out.println("Size " + transposeList.size());
//        System.out.println(transposeList);
//
//        System.out.println("\n");
//
//        transposeList.remove(1);
//        System.out.println("Size " + transposeList.size());
//        System.out.println(transposeList);
//
//        System.out.println("\n");
//
//        transposeList.remove(4);
//        System.out.println("Size " + transposeList.size());
//        System.out.println(transposeList);
//
//        System.out.println("\n");
//
//        transposeList.remove(2);
//        System.out.println("Size " + transposeList.size());
//        System.out.println(transposeList);
//
//        System.out.println("\n");
//
//        transposeList.remove(100);
//        System.out.println("Size " + transposeList.size());
//        System.out.println(transposeList);
//
//        System.out.println("\n");
//
//        transposeList.remove(6);
//        System.out.println("Size " + transposeList.size());
//        System.out.println(transposeList);
//
//        System.out.println("\n");
//
//        transposeList.remove(7);
//        System.out.println("Size " + transposeList.size());
//        System.out.println(transposeList);
//
//        System.out.println("\n");
//
//        System.out.println(transposeList.isEmpty());
//
//        transposeList.remove(9);
//        System.out.println("Size " + transposeList.size());
//        System.out.println(transposeList);
//
//        System.out.println("\n");
//
//        transposeList.remove(8);
//        System.out.println("Size " + transposeList.size());
//        System.out.println(transposeList);
//
//        System.out.println(transposeList.isEmpty());


    }
}
