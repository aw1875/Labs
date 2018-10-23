/**
 * file: IQueue.java
 * language: java
 * author: Adam Wolf
 */

public interface IQueue<T> {

    /**
     * Get size of current list
     *
     * @return list.size()
     */
    public int size();

    /**
     * Get first element in the queue
     *
     * @return list.get(0)
     */
    public T front();


    /**
     * Get the last element in the queue
     *
     * @return lst.size() - 1
     */
    public T back();

    /**
     * Remove front element from the queue
     */
    public void dequeue();

    /**
     * Add item to the back of the queue
     *
     * @param item
     */
    public void enqueue(T item);
}
