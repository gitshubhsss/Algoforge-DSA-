import java.util.Scanner;

public class Variables{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the price of pen");
        int penPrice=sc.nextInt();
        System.out.println("Enter the price of pencil");
        int pencilPrice=sc.nextInt();
        System.out.println("Enter the price of notebook");
        int notebookPrice=sc.nextInt();

        int totalPrice=penPrice+pencilPrice+notebookPrice;
        double gst=totalPrice*0.18;
        double finalPrice=totalPrice+gst;

        System.out.println("THis is your total price"+totalPrice);
        System.out.println("Gst "+gst);
        System.out.println("Final price "+finalPrice);






    }
}