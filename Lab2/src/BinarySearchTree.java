/**
 * file: BinarySearchTree.java
 * language: java
 * author: Adam Wolf
 */

public class BinarySearchTree
{
    private int value;
    private BinarySearchTree leftChild;
    private BinarySearchTree rightChild;

    public BinarySearchTree (int value) { this.value = value; }

    public BinarySearchTree (int value, BinarySearchTree leftChild, BinarySearchTree rightChild)
    {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    /**
     * If both children are not null recursively call to add up each side.
     * Check if right is null
     * Check if left is null
     * @return size of both children + 1
     * @return size of left side + 1
     * @return size of right side + 1
     * @return 1
     */
    public int size()
    {
        if (this.leftChild != null && this.rightChild != null)
        {
            return this.leftChild.size() + this.rightChild.size() + 1;
        }
        else if (this.leftChild != null && this.rightChild == null)
        {
            return this.leftChild.size() + 1;
        }
        else if (this.leftChild == null && this.rightChild != null)
        {
            return this.rightChild.size() + 1;
        }
        else
        {
            return 1;
        }
    }

    /**
     * If both children are not null get the max of each side
     * If right is null get height of right side
     * If left is null get height of left side
     * @return max of both sides + 1
     * @return left side + 1
     * @return right side + 1
     * @return 1
     */
    public int height()
    {
        if (this.leftChild != null && this.rightChild != null)
        {
            return Math.max(this.rightChild.height(), this.leftChild.height()) + 1;
        }
        else if (this.leftChild != null && this.rightChild == null)
        {
            return this.leftChild.height() + 1;
        }
        else if (this.leftChild == null && this.rightChild != null)
        {
            return this.rightChild.height() + 1;
        }
        else
        {
            return 1;
        }
    }

    /**
     * In-order traversal of BinarySearchTree
     *
     * @return string comprised of left child, value, right child
     */
    public String inOrder()
    {
        String result = "";

        if (leftChild != null)
        {
            result += leftChild.inOrder();
        }

        result += value + " ";

        if (rightChild != null)
        {
            result += rightChild.inOrder();
        }

        return result;
    }
    /**
     * Pre-order traversal of BinarySearchTree
     *
     * @return string comprised of value, left child, right child
     */
    public String preOrder()
    {
        String result = "";

        result += value + " ";

        if (leftChild != null)
        {
            result += leftChild.inOrder();
        }

        if (rightChild != null)
        {
            result += rightChild.inOrder();
        }

        return result;
    }

    /**
     * Post-order traversal of BinarySearchTree
     *
     * @return string comprised of left child, right child, value
     */
    public String postOrder()
    {
        String result = "";

        if (leftChild != null)
        {
            result += leftChild.inOrder();
        }

        if (rightChild != null)
        {
            result += rightChild.inOrder();
        }

        result += value + " ";

        return result;
    }

    /**
     * Convert values in BinarySearchTree to a string
     *
     * @return string of in-order traversal
     */
    @Override
    public String toString()
    {
        String result = inOrder();
        return result;
    }

    /**
     * Check if two binary trees are equal to each other by comparing the string returned by toString
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof BinarySearchTree))
        {
            return false;
        }
        BinarySearchTree ob = (BinarySearchTree) o;
        return this.toString().equals(o.toString());
    }

    /**
     * Check if value inputted is leaf value
     * Check if its higher or lower and check the correct side based on result
     * @param value
     * @return boolean
     */
    public boolean find(int value)
    {
        if (value == this.value)
        {
            return true;
        }
        else if (value < this.value)
        {
            if (leftChild == null)
            {
                return false;
            }
            return leftChild.find(value);
        }
        else if (value > this.value)
        {
            if (rightChild == null)
            {
                return false;
            }
            return rightChild.find(value);
        }
        return false;
    }

    /**
     * If inputted value is less than or equal to the leaf node value then check for null right child
     * If it is null create new one, if not add to the correct spot
     * Then check if left child is null, if it is create a new one or if not add it to the correct spot
     * @param value
     */
    public void add(int value)
    /* To the SLI reading this. For whatever reason I cannot get this to look like the example when I add everything to it.
     * All my other functions work but may have slightly different results due to this error.
     */
    {
        if (this.value <= value)
        {
            if (this.rightChild != null)
            {
                this.rightChild.add(value);
            }
            else
            {
                this.rightChild = new BinarySearchTree(value, null, null);
            }
        }
        else
        {
            if (this.leftChild != null)
            {
                this.leftChild.add(value);
            }
            else
            {
                this.leftChild = new BinarySearchTree(value, null, null);
            }
        }
    }
}