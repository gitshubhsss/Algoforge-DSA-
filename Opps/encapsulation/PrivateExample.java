import java.util.Scanner;

class Vehicle {
    public String color;
    private int price;

    public void changePrice() {
        price = 90;// within the class you can access private
    }
}

class Student {
    private int marks;

    private String password = "123";

    public void setMarks(int marks, String pass) {
        if (password.equals(pass)) {
            this.marks = marks;
        }
    }

    public int getMarks() {
        return marks;
    }
}

public class PrivateExample {
    public static void main(String args[]) {
        Vehicle v = new Vehicle();
        v.color = "red";
        // v.price=100;//error price has private asse
        System.out.println(v.color);

    }
}
