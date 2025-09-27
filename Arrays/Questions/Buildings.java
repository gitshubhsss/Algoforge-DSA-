package Arrays.Questions;

public class Buildings {
    public static void main(String args[]) {
        int[] heights = { 3, 5, 1, 4, 2, 8, 9 };
        // find the max floor
        int topFloor = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            topFloor = Math.max(topFloor, heights[i]);
        }

        // now go top floor to bottom floor
        while (topFloor > 0) {
            // when do we print stars now we are on the top floor will go to each floor and
            // check whether to print
            // stars or not
            for (int i = 0; i < heights.length; i++) {
                int current_floor = heights[i];
                if (topFloor <= current_floor) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            // prepare for the next line
            topFloor--;
            System.out.println();

        }
    }
}
