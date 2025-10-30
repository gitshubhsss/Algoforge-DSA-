public class JoshephsProblem {

    public static int josephus(int n, int k) {

        if (n == 1) {
            return 0;
        }

        int smallAns = josephus(n - 1, k);

        int ans = (smallAns + k) % n;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(josephus(5, 3));
    }
}
