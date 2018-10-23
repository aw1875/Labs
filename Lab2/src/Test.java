public class Test
{
    public static void main (String [] args)
    {
        BinarySearchTree b1 = new BinarySearchTree(5);
        b1.add(1);
        b1.add(3);
        b1.add(4);
        b1.add(6);
        b1.add(7);
        b1.add(9);
        System.out.println(b1.size());
        System.out.println(b1.height());
        System.out.println(b1.inOrder());
        System.out.println(b1.preOrder());
        System.out.println(b1.postOrder());
        System.out.println(b1.toString());
        //System.out.println(b1.equals());
        System.out.println(b1.find(5));
        System.out.println(b1.find(1));
        System.out.println(b1.find(3));
        System.out.println(b1.find(4));
        System.out.println(b1.find(0));
        System.out.println(b1.find(10));
    }
}
