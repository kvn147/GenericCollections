package arraylists;

import java.util.*;

/**
 * This class mimics the built-in ArrayList class in functionality but can only store
 * primitive integers.
 */
public class ArrayIntList implements IntList {
    public static final int DEFAULT_CAPACITY = 10;

    private int[] elementData;
    private int size;


    /**
     * Constructs an array of integers holding default capacity of zeros
     */
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an array of integers holding initialCapacity of zeros,
     *
     * @param initialCapacity (if initialCapacity < 0 throws IllegalArgumentException)
     */
    public ArrayIntList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("capacity: " + initialCapacity);
        }
        elementData = new int[initialCapacity];
        size = 0;
    }

    /**
     * Appends the integer value to the end of the list, resizing
     * the underlying array if necessary
     *
     * @param value integer value to append
     */
    @Override
    public void add(int value) {

        if (size >= elementData.length) {
            elementData = Arrays.copyOf(elementData, 2 * size);
        }

        elementData[size] = value;
        size++;
    }

    /**
     * @return returns the current number of integers in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns the integer value at the given index
     *
     * @param index specified position (if index < 0 or index >= size throws IndexOutOfBoundsException)
     * @return the integer value at index
     */
    @Override
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    /**
     * @param value integer value to find
     * @return the index of the first occurrence of the integer value in this list,
     * or -1 if this list does not contain the value.
     */
    @Override
    public int indexOf(int value) {
        for (int index = 0; index < size; index++) {
            if (elementData[index] == value)
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
    public void add(int index, int value) {

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
    public int remove(int index) {

        checkIndex(index);


        int removed = elementData[index];

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
