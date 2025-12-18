import java.util.*;

class MyStack {

  private LinkedList<Integer> data;

  public MyStack() {
    data = new LinkedList<>();
  }

  // O(n)
  //   public void push(int val) {
  //     data.addLast(val);
  //   }

  //o(n);
  public void push(int val) {
    LinkedList<Integer> newData = new LinkedList<Integer>();
    newData.addLast(val);
    while (data.size() > 0) {
      newData.addLast(data.removeFirst());
    }
    data = newData;
  }

  //O(n);

  //   public int pop() {
  //     if (data.size() == 0) {
  //       return -1;
  //     }

  //     LinkedList<Integer> newData = new LinkedList<Integer>();

  //     while (data.size() > 1) {
  //       int frontValue = data.removeFirst();
  //       newData.addLast(frontValue);
  //     }

  //     int stackTopValue = data.removeFirst();

  //     data = newData;

  //     return stackTopValue;
  //   }

  //O(1);

  public int pop() {
    if (data.size() == 0) {
      System.out.println("stack is empty");
      return -1;
    }
    return data.removeFirst();
  }

  //   public int peek() {
  //     if (data.size() == 0) {
  //       return -1;
  //     }

  //     LinkedList<Integer> newData = new LinkedList<Integer>();

  //     while (data.size() > 1) {
  //       int frontValue = data.removeFirst();
  //       newData.addLast(frontValue);
  //     }

  //     int stackTopValue = data.removeFirst();

  //     newData.addLast(stackTopValue);

  //     data = newData;

  //     return stackTopValue;
  //   }

  //o(1)
  public int peek() {
    if (data.size() == 0) {
      return -1;
    }

    return data.getFirst();
  }

  public void print() {
    LinkedList<Integer> newData = new LinkedList<Integer>();
    newData = data;

    while (newData.size() > 0) {
      System.out.println(newData.removeFirst());
    }
  }
}

class StackUsingQueuePushEfficient {

  public static void main(String[] args) {
    MyStack st = new MyStack();

    st.push(20);

    st.push(30);

    st.push(10);

    System.out.println(st.peek());
    System.out.println(st.pop());

    st.print();
  }
}
