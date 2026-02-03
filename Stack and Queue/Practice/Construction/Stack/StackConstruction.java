class MyStack {

  final int maxSize = 8;
  private int tos;

  private int data[];

  public MyStack() {
    tos = -1;
    data = new int[maxSize];
  }

  private void resizeData() {
    int newData[] = new int[data.length * 2];

    for (int i = 0; i < data.length; i++) {
      newData[i] = data[i];
    }

    data = newData;
  }

  public void push(int value) {
    //this was for the static data
    // if (tos == maxSize - 1) {
    //   System.out.println("Stack overflow !");
    //   return;
    // }

    if (tos == data.length - 1) {
      resizeData();
    }
    this.tos++;
    data[tos] = value;
  }

  public int pop() {
    if (tos == -1) {
      System.out.println("Stack is empty");
      return -1;
    }
    int topValue = data[tos];
    tos--;
    return topValue;
  }

  public int peek() {
    if (tos == -1) {
      System.out.println("Top of the stack is empty");
      return -1;
    }
    int topValue = data[tos];
    return topValue;
  }

  public int size() {
    return this.tos + 1;
  }

  @Override
  public String toString() {
    String stack = "[";
    for (int i = 0; i <= tos; i++) {
      stack += data[i] + ",";
    }
    stack += "]";
    return stack;
  }
}

public class StackConstruction {

  public static void main(String args[]) {
    MyStack st = new MyStack();

    st.push(1);
    st.push(2);
    st.push(5);
    st.push(54);
    st.push(544);
    st.push(7);
    st.push(75);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);
    st.push(782);

    st.pop();
    System.out.println(st.peek());

    System.out.println(st);
  }
}
