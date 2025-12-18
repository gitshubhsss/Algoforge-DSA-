
class MyQueue {

    final int maxSize = 7;
    private int front;
    private int size;

    int data[];

    public MyQueue() {
        data = new int[maxSize];
        front=0;
        size=0;
    }

    public void add(int val) {

        if (size == maxSize) {
            System.out.println("queue is full");
        }
        
        int idx=(front+size)%data.length;
        data[idx]=val;

        size++;
        
    }

    public int pop() {

        if(size==0){
            
        }
    }

    public int peek() {
    }

    public int size() {
    }
}

class QueueConstruction {

    public static void main(String[] args) {
      //  MyQueue que = new MyQueue();

        // que.add(10);
        // que.add(20);
        // que.add(30);
        // que.add(40);
        System.out.println("hellow java");

    }
}
