import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = 1;
        while (a <= 5) {
            System.out.println("Enter the number");

            int num = sc.nextInt();

            if (num % 2 == 0) {
                System.out.println("Number is event");
            } else {
                System.out.println("Number is odd");
            }
            a++;
        }
    }
}
