import java.util.ArrayList;
import java.util.Stack;

class TreeNode {

  int data;
  ArrayList<TreeNode> children;

  public TreeNode(int data) {
    this.data = data;
    children = new ArrayList<>();
  }
}

public class Main {

  public static TreeNode constructTree(int dataArray[]) {
    //why we have used the stack
    Stack<TreeNode> st = new Stack<>();
    TreeNode root = null; //root node

    for (int i = 0; i < dataArray.length; i++) {
      int data = dataArray[i];

      //-1 agar aaya to pop karo
      if (data == -1) {
        st.pop();
      } else {
        //create a newNode
        TreeNode newNode = new TreeNode(data);
        //check if size=0
        if (st.isEmpty()) {
          ///Initialze the root node only first time
          root = newNode;
        } else {
          st.peek().children.add(newNode);
        }
        st.push(newNode);
      }
    }

    return root;
  }

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

  public static int getSize(TreeNode root) {
    int totalSize = 0;

    for (TreeNode child : root.children) {
      ///Recursively calling the funtion
      totalSize = totalSize + getSize(child);
    }

    return totalSize + 1;
  }

  public static int getMaximum(TreeNode root) {
    int treeMax = root.data;

    //faith it will find the max of childen
    for (TreeNode child : root.children) {
      int childMax = getMaximum(child);
      treeMax = Math.max(childMax, treeMax);
    }

    return treeMax;
  }

  public static int getMaxHeight(TreeNode root) {
    if (root == null) {
      return -1;
    }

    int treeHeight = -1;

    for (TreeNode child : root.children) {
      int childHeight = getMaxHeight(child);

      treeHeight = Math.max(childHeight, treeHeight);
    }

    return treeHeight + 1;
  }

  public static void main(String[] args) {
    //data array
    int dataArray[] = {
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

    TreeNode root = constructTree(dataArray);

    System.out.println(getMaximum(root));
    System.out.println(getSize(root));

    System.out.println(getMaxHeight(root));
    // display(root);
    System.out.println("Everything is working fine");
  }
}
