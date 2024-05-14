package arraylists;

/**
 * This interface specifies methods that can be use with an ordered list of objects
 */
public interface MyList<E> {
    /**
     * Appends the specified object to the end of this list
     * @param value
     */
    public void add(E value);

    /**
     *
     * @return the number of objects in this list.
     */
    public int size();

    /**
     *
     * @param index specified position
     * @return the object at the specified position in this list.
     */
    public E get(int index);

    /**
     *
     * @param value value to find
     * @return the index of the first occurrence of the value in this list,
     * or -1 if this list does not contain the value.
     */
    public int indexOf(E value);

    /**
     * inserts the specified value at the specified position in this list
     * @param index position to insert value
     * @param value
     */
    public void add(int index, E value);

    /**
     * Removes the element at the specified position in this list
     * @param index specified position for removal
     * @returns removed element
     */
    public E remove(int index);
}
