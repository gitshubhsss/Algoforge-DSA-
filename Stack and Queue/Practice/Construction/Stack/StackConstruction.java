class MyStack {

  private int[] data;
  private int tos;
  private int maxSize = 8;

  // define the constructor

  MyStack() {
    data = new int[maxSize];
    tos = -1;
  }

  // when the capacity of the array gets end we will resize the array

  private void resize() {

    int[] newArray = new int[data.length * 2];

    for (int i = 0; i < data.length; i++) {
      newArray[i] = data[i];
    }

    data = newArray;
  }

  public void push(int val) {

    if (tos == data.length - 1) {
      resize();
    }
    tos++;
    data[tos] = val;

  }

  public int pop() {
    if (tos == -1) {
      System.out.println("stack is empty");
      return -1;
    }
    int topValue = data[tos];
    tos--;
    return topValue;

  }

  public int peek() {

    if (tos == -1) {
      System.out.println("stack is empty");
      return -1;
    }
    int topValue = data[tos];
    return topValue;
  }

  public void print() {
    for (int i = 0; i < data.length; i++) {
      System.out.println(data[i] + "");
    }
  }
}

public class StackConstruction {
  public static void main(String[] args) {

    MyStack st = new MyStack();

    st.push(1);
    st.push(40);
    st.push(85);
    st.push(98);
    st.push(74);
    st.push(45);
    st.push(76);
    st.push(25);
    st.push(12);
    st.push(1212);
    st.push(12124);

    System.out.println(st.peek());
    st.pop();
    st.pop();

    st.print();

  }
}