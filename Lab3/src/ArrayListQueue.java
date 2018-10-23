/**
 * file: ArrayListQueue.java
 * language: java
 * author: Adam Wolf
 */

import java.util.ArrayList;

public class ArrayListQueue<T> implements IQueue<T> {
    private ArrayList<T> myList = new ArrayList<>();

    /**
     * Count each element until the element is null
     *
     * @return counter
     */
    @Override
    public int size() {
        return myList.size();
    }

    /**
     * Get first element in the queue
     *
     * @return first element
     */
    @Override
    public T front() {
        return myList.get(0);
    }

    /**
     * Get last element in the queue
     *
     * @return last element
     */
    @Override
    public T back() {
        return myList.get(myList.size() - 1);
    }

    /**
     * Remove front element in the queue
     */
    @Override
    public void dequeue() {
        myList.remove(0);
    }

    /**
     * Add new element to the back of the queue
     *
     * @param item
     */
    @Override
    public void enqueue(T item) {
        myList.add(item);
    }
}
