/**
 * file: ArrayListStack.java
 * language: java
 * author: Adam Wolf
 */

import java.util.ArrayList;

public class ArrayListStack<T> implements IStack<T> {
    private ArrayList<T> myList = new ArrayList<>();

    /**
     * Use built in size function for ArrayList
     *
     * @return counter
     */
    @Override
    public int size() {
        return myList.size();
    }

    /**
     * Get the top  in the stack (last element)
     *
     * @return last element
     */
    @Override
    public T top() {
        return myList.get(myList.size() - 1);
    }

    /**
     * Remove last element from the stack
     */
    @Override
    public void pop() {
        myList.remove(myList.get(myList.size() - 1));
    }

    /**
     * Add new item to the beginning of the list
     *
     * @param item
     */
    @Override
    public void push(T item) {
        myList.add(item);
    }
}
