/**
 * file: BinaryTree.java
 * language: java
 * author: Adam Wolf
 */

public class BinaryTree<T> {

    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    /**
     * BinaryTree constructor with one parameter. Set value to given value and set right and left trees to null.
     *
     * @param value
     */
    public BinaryTree(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * BinaryTree constructor with three parameters. Set value to given value and right and left trees to given right and left trees.
     *
     * @param value
     * @param left
     * @param right
     */
    public BinaryTree(T value, BinaryTree<T> left, BinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * If both children are not null get the max of each side.
     * If right is null get height of right side.
     * If left is null get height of left side.
     *
     * @return 1
     */
    public int height() {
        if (this.left != null && this.right != null) {
            return Math.max(this.right.height(), this.left.height()) + 1;
        } else if (this.left != null && this.right == null) {
            return this.left.height() + 1;
        } else if (this.left == null && this.right != null) {
            return this.right.height() + 1;
        } else {
            return 1;
        }
    }

    /**
     * If both children are not null recursively call to add up each side.
     * Check if right is null.
     * Check if left is null.
     * @return size of both children + 1.
     * @return size of left side + 1.
     * @return size of right side + 1.
     * @return 1.
     */
    public int size() {
        if (this.left != null && this.right != null) {
            return this.left.size() + this.right.size() + 1;
        } else if (this.left != null && this.right == null) {
            return this.left.size() + 1;
        } else if (this.left == null && this.right != null) {
            return this.left.size() + 1;
        } else {
            return 1;
        }
    }

    /**
     * Value getter.
     * @return value of current "node".
     */
    public T getValue() { return this.value; }

    /**
     * Value setter. Set value to given value.
     * @param value
     * @return new value.
     */
    public T setValue(T value) { return this.value = value; }

    /**
     * Left tree getter.
     * @return left tree.
     */
    public BinaryTree<T> getLeft() { return this.left; }

    /**
     * Left tree setter.
     * @param left
     * @return new left tree.
     */
    public BinaryTree<T> setLeft(BinaryTree<T> left) { return this.left = left; }

    /**
     * Right tree getter.
     * @return right tree.
     */
    public BinaryTree<T> getRight() { return this.right; }

    /**
     * Right tree setter.
     * @param right
     * @return new right tree.
     */
    public BinaryTree<T> setRight(BinaryTree<T> right) { return this.right = right; }
}
