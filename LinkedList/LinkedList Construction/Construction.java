
class Node {
    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }
}

// Linked list class created by our own
class LinkedList {
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Function to insert the node at the last
    public void addLast(int data) {
        // create the new node
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // function to insert the node at the start

    public void addFirst(int data) {
        // create the newNode
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (head == tail) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            return;
        } else if (head == tail) {// size 1
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
    }

    public void removeLast() {

        /// agar 1st hi null hai to
        if (head == null) {
            return;
        }

        // agar 1 hi node hai to first vala delete karo
        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        /// go till the second last
        while (temp.next.next != null) {
            temp = temp.next;
        }

        tail = temp;// shifting tail to the second last element
        tail.next = null;// making the next of the tail as null;
        this.size--;
    }

    public Node getNodeAt(int idx) {
        if (idx < 0 || idx >= this.size) {
            System.out.println("galat index");
            return null;
        }

        int i = 0;// starting from the fist node
        Node temp = head;

        while (i < idx) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public void addNodeAt(int idx, int value) {
        if (idx < 0 || idx >= this.size) {
            System.out.println("galat index hai jji");
            return;
        }
        if (idx == 0) {
            addFirst(value);
            return;
        }

        // create new Node
        Node newNode = new Node(value);
        // idx=2
        Node prevNode = getNodeAt(idx - 1);// getting the previos node
        Node nextNode = prevNode.next;// getting the next of the previous node

        prevNode.next = null;// disconnecting prev node with the rest of the LL
        prevNode.next = newNode;// attaching the prev node to the new node
        newNode.next = nextNode;// condeting the new node with rest of the linked list
        size++;
    }

    // 4,5,7,2,3
    public void removeNodeAt(int idx) {
        if (idx < 0 || idx >= this.size) {
            System.out.println("Galat index");
            return;
        }
        if (idx == 0) {
            removeFirst();
        }
        Node prevNode = getNodeAt(idx - 1);
        Node currNode = prevNode.next;
        Node nextNode = currNode.next;

        prevNode.next = null;
        currNode.next = null;
        prevNode.next = nextNode;
        size--;

    }

    // 4,5,7,2,3
    public void reverseLinkedListDataIteratively() {
        if (head == null) {
            System.out.println("cant reverse the ll");
        }

        // initialize the pointers
        int i = 0;
        int j = size - 1;

        while (i < j) {
            Node nodeAtI = getNodeAt(i);
            Node nodeAtJ = getNodeAt(j);

            int dataAtI = nodeAtI.data;
            int dataAtJ = nodeAtJ.data;

            nodeAtI.data = dataAtJ;
            nodeAtJ.data = dataAtI;
            i++;
            j--;
        }

    }

    public void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}

public class Construction {
    public static void main(String[] args) {

        int[] arr = { 15, 20, 25, 26 };

        LinkedList ll = new LinkedList();

        for (int i = 0; i < arr.length; i++) {
            ll.addLast(arr[i]);
        }

        ll.display();
        ll.reverseLinkedListDataIteratively();
        ll.display();
    }
}
