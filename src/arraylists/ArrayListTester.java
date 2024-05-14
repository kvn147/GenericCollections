package arraylists;

public class ArrayListTester {
    public static void main(String[] args) {

        // create array list with 5 buckets
        ArrayIntList myList = new ArrayIntList(5);
        for (int i = 1; i <= 5; i++) {
            myList.add(i);
        }
        System.out.println(myList);

        // create generice array list with 5 buckets
        MyArrayList<Integer> myGenericList = new MyArrayList<>(5);
        for (int i = 1; i <= 5; i++) {
            myGenericList.add(i);
        }
        System.out.println(myGenericList);

        // create generic array list with 5 buckets
        MyArrayList<Character> myGenericList2 = new MyArrayList<>(5);
        for (char letter = 'a'; letter <= 'z'; letter++) {
            myGenericList2.add(letter);
        }
        System.out.println(myGenericList2);


        MyArrayList<Double> myGenericList3 = new MyArrayList<>();
        myGenericList3.add(56.7);
        System.out.println(myGenericList3.get(0));
    }
}
