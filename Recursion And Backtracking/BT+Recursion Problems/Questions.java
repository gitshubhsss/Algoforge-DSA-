public class Questions {

    // https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1

    public static long countFriendsPairings(int n) {
        // code here
        if (n <= 2) {
            return n;
        }

        long single = countFriendsPairings(n - 1);
        long pairUp = countFriendsPairings(n - 2);

        long ans = single + (n - 1) * pairUp;

        return ans;

    }

    // https://www.geeksforgeeks.org/problems/josephus-problem/1

    public static int josephus_rec(int n, int k) {
        // code here
        if (n <= 0) {
            return 0;
        }

        int smallerAns = josephus_rec(n - 1, k);

        int ans = (smallerAns + k) % n;

        return ans;

    }

    public static void solveSudoku(char[][] board) {

    }

    public static void main(String[] args) {
        // System.out.println(countFriendsPairings(4));

        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        solveSudoku(board);

    }
}