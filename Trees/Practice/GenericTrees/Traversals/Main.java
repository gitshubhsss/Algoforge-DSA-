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

  //traversing on the tree recursively Preoder //inorder //postorder
  //Approach 1
  public static void traverse(TreeNode root) {
    System.out.println("PreOrder ----> " + root.data);

    for (TreeNode child : root.children) {
      System.out.println(
        "Traversing on edge from " + root.data + " --> " + child.data
      );

      traverse(child);

      System.out.println(
        "Traversing on edge from " + child.data + " --> " + root.data
      );
    }

    System.out.println("PostOrder " + root.data);
  }

  //Approach 2
  public static void levelOrderTraversal(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<>();

    que.add(root);

    while (que.size() > 0) {
      //remove the frontNode
      TreeNode frontNode = que.removeFirst();

      //print the data

      System.out.print(frontNode.data + " ");

      //add children

      for (TreeNode child : frontNode.children) {
        que.add(child);
      }

      System.out.println();
    }
  }

  public static void levelOrderTraversalUsingTwoQue(TreeNode root) {
    LinkedList<TreeNode> mainQ = new LinkedList<>();
    LinkedList<TreeNode> childQ = new LinkedList<>();
    int level = 1;
    mainQ.add(root);

    while (mainQ.size() > 0) {
      //remove the front node
      TreeNode parent = mainQ.removeFirst();

      //print the data
      System.out.print(parent.data + " ");

      //add children to the childQ
      for (TreeNode child : parent.children) {
        childQ.add(child);
      }

      if (mainQ.size() == 0) {
        level++;
        mainQ = childQ;
        childQ = new LinkedList<>();
        System.out.println();
      }
    }
  }

  //using marker
  public static void levelOrderTraversalUsingSingleQue(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<>();
    que.add(root);
    que.add(null);

    while (que.size() > 0) {
      TreeNode frontNode = que.removeFirst();

      if (frontNode == null) {
        System.out.println();
        if (que.size() > 0) {
          que.add(null);
        }
      } else {
        //print the data
        System.out.print(frontNode.data + " ");
        //add the children
        for (TreeNode child : frontNode.children) {
          que.add(child);
        }
      }
    }
  }

  public static void levelOrderTraversalUsingSize(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<>();
    que.add(root);

    while (que.size() > 0) {
      int currentLevelSize = que.size();

      while (currentLevelSize > 0) {
        //remove the frontNode
        TreeNode frontNode = que.removeFirst();

        //print the data

        System.out.print(frontNode.data + " ");

        //add the children

        for (TreeNode child : frontNode.children) {
          que.add(child);
        }
        currentLevelSize--;
      }

      System.out.println();
    }
  }

  public static void printZicZac(TreeNode root) {
    Stack<TreeNode> mainSt = new Stack<>();
    int level = 1;
    mainSt.push(root);

    while (mainSt.size() > 0) {
      Stack<TreeNode> childSt = new Stack<>();

      while (mainSt.size() > 0) {
        //remove the top node
        TreeNode topNode = mainSt.pop();

        //print the data
        System.out.print(topNode.data + " ");

        //add the children

        if (level % 2 == 1) {
          for (TreeNode child : topNode.children) {
            childSt.push(child);
          }
        } else {
          for (int i = topNode.children.size() - 1; i >= 0; i--) {
            TreeNode lastNode = topNode.children.get(i);
            childSt.push(lastNode);
          }
        }
      }

      level++;
      mainSt = childSt;
      System.out.println();
    }
  }

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
    // traverse(node);
    //  levelOrderTraversal(node);

    // levelOrderTraversalUsingTwoQue(node);
    // levelOrderTraversalUsingSingleQue(node);
    // levelOrderTraversalUsingSize(node);

    printZicZac(node);
  }
}
