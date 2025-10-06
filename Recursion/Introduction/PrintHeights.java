public class PrintHeights {

    public static void printHeights(int heights[], int maxHeight) {

        // solve for the smaller problem

        if (maxHeight == 0) {
            return;
        }

        // solve the whole problem
        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            if (maxHeight <= currentHeight) {
                System.out.print("* ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println();
        // my faith is that it will work properly for the smaller height
        printHeights(heights, maxHeight - 1);
    }

    public static void main(String args[]) {
        int heights[] = { 1, 3, 2, 5, 4, 7, 8, 9, 6 };
        printHeights(heights, 9);
    }
}

/*
 * *
 * *
 * * *
 * * * *
 * * * * *
 * * * * * *
 * * * * * * *
 * * * * * * * *
 * * * * * * * * *
 */