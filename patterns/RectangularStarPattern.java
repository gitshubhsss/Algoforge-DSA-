import java.util.Scanner;

public class RectangularStarPattern {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stars : ");
        int n = sc.nextInt();

        int row = 1;
        while (row <= n) {
            for (int col = 1; col <= n; col++) {
                System.out.print("*");
            }

            // prepare for the next line

            System.out.println();
            row++;
        }
         sc.close();
    }

}

// ****
// ****
// ****
// ****