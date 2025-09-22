public class AddTwoMatrix {
    public static void main(String[] args) {
        int A[][] = { { 1, 7, 11 }, { 6, 2, 8 }, { 9, 5, 3 }, { 4, 12, 10 } };
        int B[][] = { { 6, 5 }, { 4, 1 }, { 2, 3 } };

        int r1 = A.length;
        int c1 = A[0].length;

        int r2 = B.length;
        int c2 = B[0].length;

        // We can only multiply two matrix if the c1==r2
        // means the column of first matix and the row of the second matrix should be
        // equal
        if (c1 != r2) {
            return;
        }

        // find the length of the resultant array
        // r1*c2
        int ans[][] = new int[r1][c2];

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {

                int sum = 0;
                for (int k = 0; k < r2; k++) {
                    //
                    sum = sum + A[i][k] * B[k][j];
                }
                ans[i][j] = sum;
            }
        }

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
