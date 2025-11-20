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
        } else if (head == tail) {// size 1
            tail.next = newNode;
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

        // Go till the last tail
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;//

        size--;
        return;
    }

    public void removeFirst() {
        if (head == null) { /// sise 0
            System.out.println("LinkedList is empty");
            return;
        } else if (head == tail) {// size 1 //means head.next==null
            head = null;
            tail = null;
        } else {// size n
            // Node temp = head;
            // head = temp.next;
            // temp = null;

            head = head.next;
        }
        this.size--;
    }

    public Node getNodeAt(int idx) {
        if (idx < 0 || idx >= this.size) {
            System.out.println("galat index");
            return null;
        }
        Node temp = head;
        int i = 0;// starting from the first node
        while (i < idx) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public void addNodeAt(int idx, int value) {
        if (idx < 0 || idx > this.size) {
            System.out.println("galat index");
            return;
        }

        if (idx == 0) {
            addFirst(value);
            return;
        }
        if (idx == size) {
            addLast(value);
            return;
        }

        Node newNode = new Node(value);// new node

        Node prevNode = getNodeAt(idx - 1);// getting the previes node

        Node nextOfprevNode = prevNode.next; // getting the next of the prev node

        prevNode.next = newNode; // previos ke next mein new node

        newNode.next = nextOfprevNode; // new node ke next me next of prev

        size++;

    }

    public void removeNodeAt(int idx) {
        if (idx < 0 || idx > this.size) {
            System.out.println("galat index");
            return;
        }

        Node currNode = getNodeAt(idx);// 9k

        Node nextNode = currNode.next;// 8k

        Node prevNode = getNodeAt(idx - 1);// 7k

        prevNode.next = null;// disconnect

        prevNode.next = nextNode;// 7k.next=8k

        size--;

    }

    public void reverseLinkedList() {
        if (head == null) {
            System.out.println("cant reverse");
            return;
        }
        int start = 0;// start
        int end = size / 2;
        while (start < end) {
            Node firstNode = getNodeAt(start);
            Node lastNode = getNodeAt(size - 1 - start);

            // swap the data only
            int temp = firstNode.data;
            firstNode.data = lastNode.data;
            lastNode.data = temp;
            start++;
        }
    }

}

class Main {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.addLast(23);
        ll.addLast(43);
        ll.addLast(13);

        System.out.println("printing the oute");

        ll.display();

        ll.reverseLinkedList();

        ll.display();

    }
}