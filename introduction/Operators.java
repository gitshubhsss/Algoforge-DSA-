public class Operators {
    public static void main(String[] args) {
        int a = 10;

        // System.out.println(a++);// first print and then increment 10
        // System.out.println(a);// 11

        // if (a++ == 10) {
        // System.out.println("value of a is " + a);
        // } else {
        // System.out.println("else vali value is " + a);
        // }

        if (++a == 10) {
            System.out.println("Value of a is " + a);
        } else {
            System.out.println("else part but value of a is " + a);
        }
    }
}
