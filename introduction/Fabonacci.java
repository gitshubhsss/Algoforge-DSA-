import java.util.Scanner;

public class Fabonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = sc.nextInt();

        if (number <= 1) {
            System.out.println(0);
        } else {
            int last = 1;
            int slast = 0;
            for (int i = 2; i <= number; i++) {
                int current = slast + last;
                slast = last;
                last = current;
            }
            System.out.println(last);
        }

    }
}
