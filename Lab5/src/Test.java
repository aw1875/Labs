public class Test {
    public static void main (String [] args) {
        MyTreeSet test = new MyTreeSet();
        test.add(5);
        test.add(3);
        test.add(7);
        test.add(4);
        System.out.println(test.findMinValue());
        System.out.println(test.findMaxValue());
        System.out.println(test.size());
        System.out.println(test.toString());
    }
}