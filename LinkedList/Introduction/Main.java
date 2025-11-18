import java.util.Scanner;

class Node {

    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }
}

class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 3 numbers");

        int data1 = sc.nextInt();
        Node n1 = new Node(data1);

        int data2 = sc.nextInt();
        Node n2 = new Node(data2);

        int data3 = sc.nextInt();
        Node n3 = new Node(data3);

        n1.next = n2;
        n2.next = n3;

        /// this is the one way of printing

        // System.out.println(n1.data);
        // System.out.println(n1.next.data);
        // System.out.println(n1.next.next.data);
        // System.out.println(n1.next.next.next.data);

        System.out.println("printing the data");
        Node head = n1;// initiall address of the first node
        // prining with the he
        while (head != null) {

            System.out.println(head.data);

            head = head.next;
        }

        sc.close();

    }
}