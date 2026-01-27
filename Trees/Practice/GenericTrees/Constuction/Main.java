import java.util.ArrayList;
import java.util.Stack;

class TreeNode {

  int data;
  ArrayList<TreeNode> children;

  TreeNode(int data) {
    this.data = data;
    children = new ArrayList<>();
  }
}

public class Main {

  //constuct the tree
  public static TreeNode constructTree(int dataArray[]) {
    TreeNode root = null; //declaring the root element which is initianlly null

    Stack<TreeNode> st = new Stack<>();

    for (int i = 0; i < dataArray.length; i++) {
      int data = dataArray[i];

      if (data == -1) {
        st.pop();
      } else {
        TreeNode newNode = new TreeNode(data);
        if (st.size() == 0) {
          root = newNode;
        } else {
          TreeNode frontNode = st.peek();
          frontNode.children.add(newNode);
        }
        st.push(newNode);
      }
    }
    return root;
  }

  //display the tree
  public static void display(TreeNode root) {
    System.out.println(root.data + "---> ");

    for (TreeNode child : root.children) {
      System.out.print(child.data + " ");
    }

    System.out.println();

    for (TreeNode child : root.children) {
      display(child);
    }
  }

  //get the size of the tree
  public static int getSize(TreeNode root) {
    int size = 1;

    for (TreeNode child : root.children) {
      size = size + getSize(child);
    }

    return size;
  }

  //get maximum from the tree
  public static int getMaximum(TreeNode root) {
    int treeMax = root.data;

    for (TreeNode child : root.children) {
      int childMax = getMaximum(child);
      treeMax = Math.max(treeMax, childMax);
    }

    return treeMax;
  }

  //get the maximum height of the tree
  public static int getMaxHeight(TreeNode root) {
    int treeMaxHeight = -1;

    for (TreeNode child : root.children) {
      int childMaxHeight = getMaxHeight(child);
      treeMaxHeight = Math.max(childMaxHeight, treeMaxHeight);
    }

    return treeMaxHeight + 1;
  }

  public static void main(String[] args) {
    int[] dataArray1 = {
      10,
      20,
      50,
      -1,
      60,
      -1,
      -1,
      30,
      70,
      -1,
      -1,
      40,
      80,
      -1,
      90,
      110,
      -1,
      120,
      -1,
      -1,
      100,
      -1,
      -1,
      -1,
    };

    TreeNode node = constructTree(dataArray1);

    display(node);

    // System.out.println("Displaying the size of the tree");

    //System.out.println(getSize(node));

    // System.out.println("Displaying the maximum from the node");

    // System.out.println(getMaximum(node));

    System.out.println("Maximum height of the tree is " + getMaxHeight(node));
  }
}
