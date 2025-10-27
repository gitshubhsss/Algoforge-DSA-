public class CointCombinationsProblem {

    public static void coinChangeCombinationMultiple(int coins[], int tar, int idx, String asf) {
        if (tar < 0) {
            return;
        }

        if (tar == 0) {
            System.out.println(asf);
            return;
        }

        if (idx == coins.length) {
            return;
        }

        // coins[idx] said yes and we can use it again
        coinChangeCombinationMultiple(coins, tar - coins[idx], idx, asf + coins[idx] + ",");

        // coints[idx] said no and all the times coins[idx] could've said yes is done
        coinChangeCombinationMultiple(coins, tar, idx + 1, asf);

    }

    public static void coinChangeCombinationMultiple2(int coins[], int tar, int idx, String asf) {
        if (tar < 0)
            return;

        if (tar == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = idx; i < coins.length; i++) {
            coinChangeCombinationMultiple2(coins, tar - coins[i], i, asf + coins[i]);
        }

    }

    public static void main(String[] args) {
        int coins[] = { 2, 3, 4, 5, 6 };
        int tar = 10;
        // coinChangeCombinationMultiple(coins, tar, 0, "");
        coinChangeCombinationMultiple2(coins, tar, 0, "");

    }
}
