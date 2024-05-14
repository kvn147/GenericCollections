package arraylists;

/**
 * This interface specifies methods that can be use with an ordered list of integers
 */
public interface IntList {
    /**
     * Appends the specified integer to the end of this list
     * @param value
     */
    public void add(int value);

    /**
     *
     * @return the number of integers in this list.
     */
    public int size();

    /**
     *
     * @param index specified position
     * @return the integer at the specified position in this list.
     */
    public int get(int index);

    /**
     *
     * @param value integer value to find
     * @return the index of the first occurrence of the integer value in this list,
     * or -1 if this list does not contain the value.
     */
    public int indexOf(int value);

    /**
     * inserts the specified value at the specified position in this list
     * @param index position to insert value
     * @param value
     */
    public void add(int index, int value);

    /**
     * Removes the element at the specified position in this list
     * @param index specified position for removal
     * @returns removed element
     */
    public int remove(int index);
}
