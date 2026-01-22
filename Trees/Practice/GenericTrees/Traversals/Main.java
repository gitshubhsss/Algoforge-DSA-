import java.util.ArrayList;
import java.util.LinkedList;
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

  public static TreeNode constructTree(int dataArray[]) {
    TreeNode root = null;

    Stack<TreeNode> st = new Stack<>();

    for (int i = 0; i < dataArray.length; i++) {
      int data = dataArray[i];
      if (data == -1) {
        st.pop();
      } else {
        //make a tree node
        TreeNode node = new TreeNode(data);

        //If size is zero then assing to the root node
        if (st.size() == 0) {
          root = node;
        } else {
          //add the new element as the children
          st.peek().children.add(node);
        }
        //push the element in the stack
        st.push(node);
      }
    }

    return root;
  }

  public static void display(TreeNode root) {
    System.out.print(root.data + " ---> ");

    //Loop is for printing the data
    for (TreeNode child : root.children) {
      System.out.print(child.data + " ");
    }
    //printing the new line
    System.out.println();

    //making hte recursinve call
    for (TreeNode child : root.children) {
      display(child);
    }
  }

  public static void traverse(TreeNode root) {
    System.out.println("PreOrder ----> " + root.data);

    for (TreeNode child : root.children) {
      System.out.println(
        "Traversing on the edge from " + root.data + " to " + child.data
      );
      traverse(child);
      System.out.println(
        "Traversing on the edge from " + child.data + " to " + root.data
      );
    }
    System.out.println("Post order ----->" + root.data);
  }

  ///Approch 1
  public static void levelOrderTraversal(TreeNode node) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(node);

    while (queue.size() > 0) {
      //remove node
      TreeNode frontNode = queue.removeFirst();

      //print node ka data
      System.out.print(frontNode.data + " ");

      //add children
      for (TreeNode child : frontNode.children) {
        queue.add(child);
      }
      System.out.println();
    }
  }

  //Approch 2
  //Using 2 queue
  public static void levelOrderTraverselLineWise(TreeNode root) {
    LinkedList<TreeNode> mainQ = new LinkedList<>();
    mainQ.add(root);

    while (mainQ.size() > 0) {
      LinkedList<TreeNode> childQ = new LinkedList<TreeNode>();

      while (mainQ.size() > 0) {
        //remove first node
        TreeNode frontNode = mainQ.removeFirst();

        //print node
        System.out.print(frontNode.data + " ");

        //add children to child queue
        for (TreeNode child : frontNode.children) {
          childQ.add(child); //20,30,40
        }
      }

      mainQ = childQ;
      System.out.println();
    }
  }

  public static void levelOrderTraverselLineWise2(TreeNode root) {
    //Maintain 2 queue

    LinkedList<TreeNode> mainQ = new LinkedList<>();
    LinkedList<TreeNode> childQ = new LinkedList<>();
    mainQ.add(root);
    int level = 1;

    while (mainQ.size() > 0) {
      //remove front node
      TreeNode frontNode = mainQ.removeFirst();
      //print the node
      System.out.print(frontNode.data + " ");

      for (TreeNode child : frontNode.children) {
        childQ.add(child);
      }

      ///agar kisi din mainQ khali ho gaya
      if (mainQ.size() == 0) {
        level++;
        System.out.println();
        mainQ = childQ;
        childQ = new LinkedList<>();
      }
    }
  }

  ///using the marker
  public static void levelOrderTraverselUsingMarker(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null); //marker

    //10,null,20,30,40,null
    //=>10,
    while (queue.size() > 0) {
      TreeNode frontNode = queue.removeFirst();

      if (frontNode == null) {
        if (queue.size() > 0) {
          queue.add(null);
          System.out.println();
        }
      } else {
        //print the data
        System.out.print(frontNode.data + " ");
        for (TreeNode child : frontNode.children) {
          queue.add(child); //20,30,40
        }
      }
    }
  }

  //usint the currrent size

  public static void main(String[] args) {
    // int[] dataArray1 = {
    //   10,
    //   20,
    //   50,
    //   -1,
    //   60,
    //   -1,
    //   -1,
    //   30,
    //   -1,
    //   40,
    //   80,
    //   -1,
    //   90,
    //   -1,
    //   100,
    //   -1,
    //   -1,
    //   -1,
    // };
    int[] dataArray2 = {
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

    TreeNode node = constructTree(dataArray2);
    //display(node);
    // traverse(node);
    //levelOrderTraversal(node);
    // levelOrderTraverselLineWise(node);
    // levelOrderTraverselLineWise2(node);
    levelOrderTraverselUsingMarker(node);
  }
}
