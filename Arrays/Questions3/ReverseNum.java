public class ReverseNum {
    public static void main(String[] args) {
        int num = 123;
        int rev = 0;
        int pow = 0;
        while (num > 0) {
            int last = num % 10;
            rev = rev + (int) Math.pow(10, pow) * last;
            num = num / 10;
            pow++;
        }
        System.out.println(rev);
    }
}
