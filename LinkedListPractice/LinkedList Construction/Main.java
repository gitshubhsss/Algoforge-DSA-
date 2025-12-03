
class Node {
    Node next;
    int data;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {

    Node head;
    Node tail;
    int size;

    // we are just initializing the variables
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // now we are going to create our own data structure

    public void addLast(int value) {

        // create a new node with the values passed in the fuction

        Node newNode = new Node(value);

        // size=0
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (head == tail) {// size=1

            tail.next = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }

    public void addFirst(int value) {
        // create a new node
        Node newNode = new Node(value);

        // size=0
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (head == tail) {// size=0
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void removeLast() {
        Node temp = head;

        if (temp == null) {
            System.out.println("invalid size out their");
            return;
        }

        if (temp.next == null) {
            head = null;
            return;
        }

        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public void printLL() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    

}

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(45);
        ll.addLast(10);
        ll.addLast(7);
        ll.addLast(18);

        ll.printLL();

        ll.removeLast();
        ll.printLL();;
    }
}
