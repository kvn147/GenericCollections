package arraylists;

import java.util.*;

/**
 * This class mimics the built-in ArrayList class in functionality but can store any Java Object
*/
public class MyArrayList<E> implements MyList<E> { // change #1
    public static final int DEFAULT_CAPACITY = 10;

    private E[] elementData; // change #2
    private int size;


    /**
     * Constructs an array of integers holding default capacity of zeros
     */
    public MyArrayList() {
        // calls the constructor below, passing DEFAULT_CAPACITY for initialCapacity
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an array of integers holding initialCapacity of zeros,
     *
     * @param initialCapacity (if initialCapacity < 0 throws IllegalArgumentException)
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("capacity: " + initialCapacity);
        }
        elementData = (E[]) new Object[initialCapacity]; // Change #3 - E could represent any class
        size = 0;
    }

    /**
     * Appends the integer value to the end of the list, resizing
     * the underlying array if necessary
     *
     * @param value integer value to append
     */
    @Override
    public void add(E value) { // Change #4

        if (size >= elementData.length) {
            elementData = Arrays.copyOf(elementData, 2 * size);
        }

        elementData[size] = value;
        size++;
    }

    /**
     * @return returns the current number of objects in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns the value at the given index
     *
     * @param index specified position (if index < 0 or index >= size throws IndexOutOfBoundsException)
     * @return the value at index
     */
    @Override
    public E get(int index) { // Change #5
        checkIndex(index);
        return elementData[index];
    }

    /**
     * @param value value to find
     * @return the index of the first occurrence of the value in this list,
     * or -1 if this list does not contain the value.
     */
    @Override
    public int indexOf(E value) { // Change #6
        for (int index = 0; index < size; index++) {
            if (elementData[index].equals(value)) // Change #7 way to check contents of objects for generics
                return index;
        }
        return -1;
    }

    /**
     * inserts the specified value at the specified position in this list
     * if index < 0 or index > size() throws IndexOutOfBoundsException
     *
     * @param index position to insert value
     * @param value
     */
    @Override
    public void add(int index, E value) { // Change #8 type of value

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Changed Index " + index + " out of bounds for length " + size);
        }

        if (size >= elementData.length) {
            elementData = Arrays.copyOf(elementData, 2 * size);
        }

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }


    /**
     * Removes value at specified position if given a valid index
     *
     * @param index specified position for removal, if index < 0 or index >= size throw
     *              ArrayIndexOutOfBounds Exception
     * @return value removed from list
     */
    @Override
    public E remove(int index) { // Change #9
        checkIndex(index);

        E removed = elementData[index];

        // shift values to the left to overwrite removed value
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        size--;
        return removed;
    }

    // post condition: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Changed Index " + index + " out of bounds for length " + size);
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        String result = "[" + elementData[0];
        for (int i = 1; i < size; i++) {
            result += ", " + elementData[i];
        }

        return result + "]";

    }
}
