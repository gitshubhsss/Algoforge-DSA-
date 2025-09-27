public class SaddelPointInMatrix {

    public static void findSiddlePoint(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int k = 0;// index of the smallest ement in the row
        int l = 0;// index of the largest element in the col
        for (int row = 0; row < n; row++) {
            int min = Integer.MAX_VALUE;// stores in the minimum element in the row
            for (int col = 0; col < m; col++) {
                if (matrix[row][col] < min) {
                    min = matrix[row][col];
                    k = col;// store the index of the minimun element in the k
                }
            }
            int max = Integer.MIN_VALUE;
            // here we are keeping the the k ie. colum contant and going on each row
            // and finding the maximum element of the colum
            for (int i = 0; i < n; i++) {
                if (matrix[i][k] > max) {
                    max = matrix[i][k];
                    l = i;// on which position the largest element
                }
            }
            if (min >= max) {
                System.out.println("Saddle point exists on " + l + " " + k);
                System.out.println("Saddle point is " + matrix[l][k]);
                return;

            }
        }
        System.out.println("No sadle point");
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 10, 18, 4 } };
        findSiddlePoint(matrix);
    }
}
