
public class Questions {

    // one coin used single time
    public static void coinChangePermutationOneCoinSingleTime(int coins[], boolean vis[], int tar, String asf) {
        if (tar < 0) {
            return;
        }
        if (tar == 0) {
            System.out.println(asf);
            return;
        }

        for (int idx = 0; idx < coins.length; idx++) {
            if (vis[idx] == false) {
                vis[idx] = true;
                coinChangePermutationOneCoinSingleTime(coins, vis, tar - coins[idx], asf + coins[idx]);
                vis[idx] = false;
            }

        }
    }

    // One coin used multiple times
    public static void coinChangePermutationOneCoinMultipleTime(int coins[], int tar, String asf) {
        if (tar < 0) {
            return;
        }
        if (tar == 0) {
            System.out.println(asf);
            return;
        }

        for (int idx = 0; idx < coins.length; idx++) {

            coinChangePermutationOneCoinMultipleTime(coins, tar - coins[idx], asf + coins[idx]);

        }

    }

    // 2,3,5
    // 4,6
    public static void coinChangeCombinationSingle(int coins[], int tar, String asf, int idx) {

        if (tar < 0) {
            return;
        }

        if (tar == 0) {
            System.out.println(asf);
            return;
        }

        for (int j = idx; j < coins.length; j++) {
            coinChangeCombinationSingle(coins, tar - coins[j], asf + coins[j], j + 1);
        }

    }

    public static void coinChangeCombinationMultiple(int coins[], int tar, String asf, int idx) {

        if (tar < 0) {
            return;
        }

        if (tar == 0) {
            System.out.println(asf);
            return;
        }

        for (int j = idx; j < coins.length; j++) {
            coinChangeCombinationMultiple(coins, tar - coins[j], asf + coins[j], j);
        }
    }

    public static void main(String[] args) {
        int coins[] = { 2, 3, 4, 6, 5 };
        boolean vis[] = new boolean[coins.length];
        int tar = 10;

        // coinChangePermutationOneCoinSingleTime(coins, vis, tar, "");
        // coinChangePermutationOneCoinMultipleTime(coins, tar, "");
        // coinChangeCombinationSingle(coins, tar, "", 0);
        coinChangeCombinationMultiple(coins, tar, "", 0);
    }
}
