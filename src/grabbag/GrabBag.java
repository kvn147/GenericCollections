package grabbag;

import java.util.*;

/**
 * This class holds a collection of objects that can be randomly selected
 * similar in concept to a grab bag of gifts
 */
public class GrabBag<E> implements Iterable<E> {

   private List<E> bag;

   /**
    * Construct a collection of ojbects
    */
   public GrabBag() {

      bag = new ArrayList<>();
   }

   public List<E> getBag() {
      return bag;
   }

   /**
    *
    * @param data item to add to the bag
    */
   public void add(E data) {

      bag.add(data);
   }

   /**
    *
    * @return a random item from the bag
    */
   public E grab() {
      Random r = new Random();
      return bag.remove(r.nextInt(bag.size()));
   }

   /**
    *
    * @return true if not items are in the bag
    */
   public boolean isEmpty() {

      return bag.size() == 0;
   }

   /**
    *
    * @return a String of bracketed comma delimited list of items in bag
    */
   public String toString() {

      return bag.toString();
   }

   @Override
   public Iterator<E> iterator() {
      return new GrabBagIterator();
   }

   // create inner class called GrabBagIterator
   private class GrabBagIterator implements Iterator<E> {

      int position = 0; // treat as an index
      boolean removeOK = false;

      @Override
      public boolean hasNext() {
         return position < bag.size();
      }

      @Override
      public E next() {
         removeOK = true;
         E obj = bag.get(position); // temp
         position++; // temp->next check if at end of linked list
         return obj;

         // or
         // return bag.get(position++);
      }
   }

}