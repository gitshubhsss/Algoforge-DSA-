import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        // int i = 1;

        // while (i <= 10) {
        // System.out.println(n + " * " + i + " = " + n * i);
        // i++;
        // }

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + n * i);
        }

    }
}