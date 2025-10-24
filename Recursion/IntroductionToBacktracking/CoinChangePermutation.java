public class CoinChangePermutation {

    // One coin can be used:one coin one time
    public static void coinChangePermutation(int coins[], boolean[] vis, int tar, String asf) {
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
                coinChangePermutation(coins, vis, tar - coins[idx], asf + coins[idx] + ",");
                vis[idx] = false;
            }
        }
    }

    // multiple coins can be used
    public static void coinChangePermutationsMultiple(int coins[], int tar, String asf) {
        if (tar < 0) {
            return;
        }

        if (tar == 0) {
            System.out.println(asf);
            return;
        }

        for (int idx = 0; idx < coins.length; idx++) {
            coinChangePermutationsMultiple(coins, tar - coins[idx], asf + coins[idx] + ",");
        }
    }

    public static void coinChangePermutationSingle(int coins[], int tar, String asf) {
        if (tar < 0) {
            return;
        }

        if (tar == 0) {
            System.out.println(asf);
            return;
        }

        for (int j = 0; j < coins.length; j++) {
            coinChangePermutationSingle(coins, tar - coins[j], asf + coins[j] + ",");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 5, 6 };
        int tar = 10;

        // coinChangePermutationsWithoutBoolean(arr, 10, "");
        boolean vis[] = new boolean[arr.length];
        // coinChangePermutation(arr, vis, tar, "");
        // coinChangePermutationSingle(arr, tar, "");
        coinChangePermutation(arr, vis, tar, "");
    }
}
