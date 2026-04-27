public class GCD {
    class Solution {
        public static int gcd(int a, int b) {
            // code here
            // you have given the two numbers

            while (a != 0) {
                int rem = b % a;
                b = a;
                a = rem;
            }
            return b;
        }
    }

}
