import java.util.Scanner;

public class DiamondNumbers {
    public static void main(String[] args) {
        System.out.println("Enter the value of n");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int total_number_of_lines = n;

        int current_of_lines = 1;

        int stars = 1;
        int space = n / 2;
        int count = 1;

        while (current_of_lines <= total_number_of_lines) {

            for (int i = 1; i <= space; i++) {
                System.out.print("  ");
            }

            int num = count;// original count
            int temp = count;// temp count
            for (int i = 1; i <= stars; i++) {
                System.out.print(num + " ");
                if (temp <= 1) {
                    num++;
                } else {
                    num--;
                }
                temp--;
            }

            // prepare for the next line
            if (current_of_lines <= n / 2) {
                space--;
                stars += 2;
                count++;
            } else {
                space++;
                stars -= 2;
                count--;
            }
            current_of_lines++;
            System.out.println();

        }
        sc.close();
    }
}
