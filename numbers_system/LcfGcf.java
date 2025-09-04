import java.util.Scanner;

public class LcfGcf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the a");
        int num1 = sc.nextInt();
        System.out.println("Enter the b");
        int num2 = sc.nextInt();

        int a = num1;
        int b = num2;

        while (num1 != 0) {
            int rem = (num2 % num1);
            System.out.println(rem);
            num2 = num1;
            num1 = rem;
        }

        System.out.println("Lcf = " + num2);

    }
}
