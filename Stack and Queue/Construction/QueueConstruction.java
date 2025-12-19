class MyQueue {

  final int maxSize = 7;
  private int[] data;
  //to keep the track of the front eleent
  private int front;
  private int size;

  MyQueue() {
    data = new int[maxSize]; //[0,0,0,0,0,0,0]
    size = 0;
    front = 0;
  }

  public void add(int value) {
    if (size >= maxSize) {
      System.out.println("Queue overflow");
      return;
    }

    ///making it circulater
    int idx = (front + size) % data.length;

    data[idx] = value;
    size++;
  }

  public int pop() {
    if (size == 0) {
      System.out.println("Queue overflow");
      return -1;
    }

    int firstEle = data[front];

    front = (front + 1) % data.length;

    size--;

    return firstEle;
  }

  public int peek() {
    if (size == 0) {
      return -1;
    }

    return data[front];
  }

  public int size() {
    return size;
  }
}

public class QueueConstruction {

  public static void main(String args[]) {
    MyQueue queue = new MyQueue();

    queue.add(50);
    queue.add(100);
    queue.add(150);

    System.out.println(queue.pop()); //100,150

    System.out.println(queue.peek());

    System.out.println(queue.peek());
  }
}
