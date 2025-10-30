public class FriendsPairing {
    public static long countFriendsPairings(int n) {
        // code here
        if (n <= 2) {
            return n;
        }

        // if n=5

        long single = countFriendsPairings(n - 1);// 4=10

        long pairUp = countFriendsPairings(n - 2);// 3=4

        long ans = single + (n - 1) * pairUp;// 10+(4)*4=26

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(countFriendsPairings(4));
    }
}
