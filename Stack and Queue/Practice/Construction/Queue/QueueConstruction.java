import java.util.LinkedList;

class MyQueue {

  final int maxSize = 7;
  private int data[];
  private int front = 0;
  private int size = 0;

  public MyQueue() {
    data = new int[maxSize];
  }

  public void add(int value) {
    if (size == maxSize) {
      System.out.println("Queue overflow");
      return;
    }

    int idx = (front + size) % data.length;
    data[idx] = value;
    size++;
  }

  public int pop() {
    if (size == 0) {
      System.out.println("Queue is empty");
      return -1;
    }

    int frontEl = data[front];
    //move the front in circular fashion
    front = (front + 1) % data.length;
    size--;

    return frontEl;
  }

  public int peek() {
    if (size == 0) {
      System.out.println("Queue is empty");
      return -1;
    }

    int frontEl = data[front];
    return frontEl;
  }

  public int size() {
    return this.size;
  }

  @Override
  public String toString() {
    String queStr = "[";

    for (int i = 0; i < size; i++) {
     
      queStr += data[] + ",";
    }
    queStr += "]";

    return queStr;
  }
}

public class QueueConstruction {

  public static void main(String[] args) {
    MyQueue que = new MyQueue();

    que.add(10);
    que.add(5);
    que.add(42);

    System.out.println(que.pop());
    System.out.println(que);
  }
}
