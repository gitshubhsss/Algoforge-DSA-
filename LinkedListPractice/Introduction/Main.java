
class Node {
    Node next;
    int data;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }
}

class Main {

    // Linked list is a linear data structure that stores a sequnce of elements
    // called nodes which are linked together by refferences
    public static void main(String[] args) {

        Node n1 = new Node(50);

        Node n2 = new Node(100);

        n1.next = n2;

        System.out.println(n1.next.data);
    }
}