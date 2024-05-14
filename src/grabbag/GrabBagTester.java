package grabbag;

import java.util.*;

public class GrabBagTester {
   public static void main(String[] args) {

        // Create a bag to hold characters
        // when we construct a new GrabBag object, we will now have to say what type it is since it is a generic
        GrabBag<Character> bag = new GrabBag<>();


        // Add a to z and A to Z to the bag
        addLetters(bag);

        // Print contents of bag
        System.out.println(bag);


        // Create a bag to hold integers
       GrabBag<Integer> numBag = new GrabBag<>();

       for (int i = 10; i <= 20; i++) {
           numBag.add(i);
       }

       System.out.println(numBag);

       // for index loop iterates through the underlying bag data structure
       // which must implement the list interface for this to work
       for (int i = 0; i < numBag.getBag().size(); i++) {
           System.out.println(numBag.getBag().get(i));
       }

       // we can use for each loops instead, but will need iterators
       Iterator<Integer> it = numBag.iterator();

       while(it.hasNext()) {
           System.out.println(it.next());
       }

       // use a for each loop for each bag
       for (Integer num : numBag) {
           System.out.println(num);
       }

       // use a for each loop for each character
       for (Character letter : bag) {
           System.out.println(letter);
       }

   }
   
   public static void addLetters(GrabBag bag) {
   
        for(char c = 'a'; c <= 'z'; c++) {
            bag.add(c);
        }
        for(char c = 'A'; c <= 'Z'; c++) {
            bag.add(c);
        }
   
   }

}