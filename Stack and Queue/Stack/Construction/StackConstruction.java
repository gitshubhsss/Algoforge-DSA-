class MyStack {

  private final int maxSize = 8;
  private int data[];
  private int tos;

  MyStack() {
    data = new int[maxSize];
    tos = -1;
  }

  public void push(int value) {
    if (tos == data.length - 1) {
      System.out.println("Stack overflow");
      return;
    }
    tos++;
    data[tos] = value;
  }
  // public int pop() {

  // }

  // public int peek() {

  // }

  // public int size() {
  //     return tos + 1;
  // }

}

class StackConstruction {

  public static void main(String[] args) {
    MyStack st = new MyStack();
    // MyStack st = new MyStack();

    st.push(2);
    st.push(3);
    st.push(4);
    st.push(5);
    // System.out.println(st.pop());
    // System.out.println(st.peek());
    // System.out.println(st.size());
    // System.out.println(st);
  }
}
