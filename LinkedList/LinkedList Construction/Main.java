class Node {
    int data;
    Node next;

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

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);

        // Head will remains the same the tail will be update as we are creating the new
        // objects

        if (head == null) {// size =0
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        this.size++;
    }

    public void addFirst(int value) {

        Node newNode = new Node(value);

        // tail will remains constanst
        if (head == null) {// size =0
            head = newNode;
            tail = newNode;
        } else if (head == tail) {// size =1
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Traversing the list
    public void display() {

        Node temp = head;// access the first elemt

        while (temp != null) {

            System.out.print(temp.data + " ");

            Node tempKaNext = temp.next;

            temp = tempKaNext;// going to the next address

        }

        System.out.println();
    }

    public void removeLast() {
        if (head == null && tail == null) {// 0 element
            return;
        }
        if (head == tail) {// 1 element
            head = null;
            tail = null;
            return;
        }
        Node temp = head;

        // Go till the last index
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;//

        size--;
        return;
    }

}

class Main {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.addFirst(10);
        ll.addFirst(20);

        ll.removeLast();

        ll.display();

    }
}