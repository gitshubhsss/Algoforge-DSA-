import java.util.Scanner;

public class StarPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines");// 5
        int total_number_of_rows = sc.nextInt();
        int row = 1;
        int initial_spacing = total_number_of_rows - 1;
        int ending_spacing = total_number_of_rows - 1;

        int stars = 1;

        while (row <= total_number_of_rows) {

            // Print initial spacing
            for (int i = 1; i <= initial_spacing; i++) {
                System.out.print(" ");
            }

            // Print stars

            for (int i = 1; i <= stars; i++) {
                System.out.print("*");
            }

            // Print ending spacing
            for (int i = 1; i <= ending_spacing; i++) {
                System.out.print(" ");
            }

            // Prepare for the next line
            System.out.println();
            initial_spacing--;
            ending_spacing--;
            stars = stars + 2;
            row++;

        }
         sc.close();

    }
}

//     *    
//    ***   
//   *****  
//  ******* 
// *********