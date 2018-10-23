/**
 * file: IStack.java
 * language: java
 * author: Adam Wolf
 */

public interface IStack<T> {

    /**
     * Get size of list
     *
     * @return list.size()
     */
    public int size();

    /**
     * Get top item in the queue (last)
     *
     * @return list.get(list.size () - 1)
     */
    public T top();

    /**
     * Remove last element from the stack
     */
    public void pop();

    /**
     * Add new item to the beginning of the list
     *
     * @param item
     */
    public void push(T item);
}
