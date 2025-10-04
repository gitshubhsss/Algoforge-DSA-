public class ZigZac {

    public static void printZigZag(int n) {

        if (n <= 0) {
            return;
        }
        // pre-area (before any recursive calls made)
        System.out.println("pre area " + n);

        printZigZag(n - 1);

        // in-area(between any two recursive calls)
        System.out.println("inner area " + n);

        printZigZag(n - 1);

        // post-are (after all the recursive calls are made)
        System.out.println("post area " + n);

    }

    public static void main(String[] args) {
        printZigZag(3);
    }
}
