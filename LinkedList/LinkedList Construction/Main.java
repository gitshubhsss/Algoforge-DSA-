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
    Node head;// pointing to the first node
    Node tail;// pointing to the last node
    int size;// maintaining the size

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/1

    public void addLast(int value) {
        Node newNode = new Node(value);

        // Head will remains the same the tail will be update as we are creating the new
        // objects

        // head will remains the constant
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

    // https://www.geeksforgeeks.org/problems/linked-list-insertion-at-beginning/1

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
            temp = temp.next;

        }

        System.out.println();
    }

    public void removeLastWithTail() {
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

    // https://www.geeksforgeeks.org/problems/deletion-at-the-end-of-a-linked-list/1

    public void removeLastWithoutTail() {
        if (head == null) {// invalid index
            System.out.println("Index out of bound");
            return;
        }

        if (head.next == null) {
            removeFirst();
            return;
        }

        Node temp = head;

        // access the second last element
        while (temp.next.next != null) {
            temp = temp.next;
        }

        tail = temp;// shifting tail to second last element
        temp.next = null;// making the next of the tail as null
    }

    // https://www.geeksforgeeks.org/problems/delete-head-of-linked-list/1

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

    // https://www.geeksforgeeks.org/problems/insertion-at-a-given-position-in-a-linked-list/1
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
        Node nextNode = prevNode.next; // getting the next of the prev node

        prevNode.next = null; // disconnecting prev node with the rest of the LL
        prevNode.next = newNode; // connecting prev node with newNode
        newNode.next = nextNode; // connecting newNode with rest of linkedList

        size++;

    }

    // https://www.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1

    public void removeNodeAt(int idx) {
        if (idx < 0 || idx > this.size) {
            System.out.println("galat index");
            return;
        }

        Node prevNode = getNodeAt(idx - 1);
        Node nodeToDelete = prevNode.next;
        Node nextNode = nodeToDelete.next;

        prevNode.next = null;// breaking connection of prev node with the rest of the LinkedList

        prevNode.next = nextNode;// attaching prevNode with next of deletedNode

    }

    public void reverseLinkedListDataIteratively() {
        if (head == null) {
            System.out.println("cant reverse");
            return;
        }
        int i = 0;// start

        int j = size - 1;

        while (i < j) {// O(N)
            Node nodeAtI = getNodeAt(i); // O(N)
            Node nodeAtJ = getNodeAt(j);// O(N)

            int dataAtI = nodeAtI.data;
            int dataAtJ = nodeAtJ.data;

            nodeAtI.data = dataAtJ;
            nodeAtJ.data = dataAtI;

            i++;
            j--;
        }

    }

}

class Main {
    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.addLast(23);
        ll.addLast(43);
        ll.addLast(13);

        ll.display();

        ll.removeLastWithoutTail();

        ll.display();

    }
}