public class CountPrimes {

    public static int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isNumPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isNumPrime(int n) {
        if (n == 1) {
            return false;
        }
        boolean isPrime = true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(5));
    }
}
