/**
 * file: MyTreeSet.java
 * language: java
 * author: Adam Wolf
 */

import java.util.Comparator;

public class MyTreeSet<T extends Comparable<T>> {
    private BinaryTree<T> root;
    private Comparator<T> comparator;

    /**
     * MyTreeSet constructor with no parameters. Set root and comparator to null.
     */
    public MyTreeSet() {
        this.root = null;
        this.comparator = null;
    }

    /**
     * MyTreeSet constructor with one parameter. Set root to null and comparator to given comparator.
     *
     * @param comparator
     */
    public MyTreeSet(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    /**
     * Check if root node is null. If it is create a tree at the root.
     * If not, check if the comparator is null or not.
     * If it is, call the natural ordering add function.
     * If not, call the comparator add function.
     * @param item
     * @return
     */
    public boolean add(T item) {
        BinaryTree<T> current = root;
        if (root == null) {
            root = new BinaryTree<T>(item);
            return true;
        } else {
            if (comparator == null) {
                addNatural(current, item);
            } else {
                addComparator(current, comparator, item);
            }
        }
        return false;
    }

    /**
     * Natural ordering add method. Find the proper place for the item using compareTo from comparable interface.
     * @param current
     * @param item
     * @return true if added successfully, false otherwise.
     */
    public boolean addNatural(BinaryTree<T> current, T item) {
        if (current == null) {
            current = new BinaryTree<T>(item);
            return true;
        } else {
            if (current.getValue().compareTo(item) > 0) {
                if (current.getLeft() == null) {
                    BinaryTree<T> left = new BinaryTree<T>(item);
                    current.setLeft(left);
                    return true;
                } else {
                    current = current.getLeft();
                    addNatural(current, item);
                }
            } else if (current.getValue().compareTo(item) < 0) {
                if (current.getRight() == null) {
                    BinaryTree<T> right = new BinaryTree<T>(item);
                    current.setRight(right);
                    return true;
                } else {
                    current = current.getRight();
                    addNatural(current, item);
                }
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Comparator add method.
     * @param current
     * @param comparator
     * @param item
     * @return true if added successfully, false otherwise.
     */
    public boolean addComparator(BinaryTree<T> current, Comparator<T> comparator, T item) {
        return false;
    }

    /**
     * Get size of tree.
     * @return size.
     */
    public int size() {
        return size();
    }

    /**
     * Get the left most node value and set minValue to it.
     * @return minValue.
     */
    public T findMinValue() {
        T minValue = root.getValue();
        BinaryTree<T> current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
            minValue = root.getLeft().getValue();
        }
        return minValue;
    }

    /**
     * Get the right most node value and set maxValue to it.
     * @return maxValue.
     */
    public T findMaxValue() {
        T maxValue = root.getValue();
        BinaryTree<T> current = root;
        while (current.getRight() != null) {
            current = current.getRight();
            maxValue = root.getRight().getValue();
        }
        return maxValue;
    }

    /**
     * Get all the left nodes, then the root node, then the right nodes and add to string "result"
     * @return result.
     */
    public String toString() {
        String result = "";

        if (root.getLeft() != null) {
            result += root.getLeft().getValue().toString();
        }

        result += " " + root.getValue() + " ";

        if (root.getRight() != null) {
            result += root.getRight().getValue().toString();
        }

        return result;
    }
}