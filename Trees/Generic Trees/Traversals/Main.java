import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class TreeNode {

  int data;
  ArrayList<TreeNode> children;

  public TreeNode(int data) {
    this.data = data;
    children = new ArrayList<>();
  }
}

class Main {

  public static TreeNode constructTree(int[] dataArray) {
    Stack<TreeNode> st = new Stack<>();
    TreeNode root = null;

    for (int i = 0; i < dataArray.length; i++) {
      if (dataArray[i] == -1) {
        st.pop();
      } else {
        TreeNode newNode = new TreeNode(dataArray[i]);
        if (st.size() == 0) {
          root = newNode;
        } else {
          st.peek().children.add(newNode);
        }

        st.push(newNode);
      }
    }

    return root;
  }

  // Traversing tree recursively ====================
  public static void traverse(TreeNode root) {
    System.out.println("Preorder -> " + root.data);

    for (TreeNode child : root.children) {
      System.out.println(
        "Traversing on edge from " + root.data + " -> " + child.data
      );

      traverse(child);

      System.out.println(
        "Traversing on edge from " + child.data + " -> " + root.data
      );
    }

    System.out.println("Postorder -> " + root.data);
  }

  // Level order traversal
  public static void levelOrderTraversal(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();

    queue.add(root);

    while (queue.size() > 0) {
      //remove front node
      TreeNode frontNode = queue.removeFirst();

      //print node data
      System.out.print(frontNode.data + " ,");

      //add node.children
      for (TreeNode child : frontNode.children) {
        queue.add(child);
      }
    }
  }

  //level order linevise
  // 10 ,
  // 20 ,30 ,40 ,
  // 50 ,60 ,70 ,80 ,90 ,100 ,
  // 110 ,120 ,

  //Approch 1
  public static void levelOrderLineWise(TreeNode root) {
    LinkedList<TreeNode> mainQ = new LinkedList<>();

    mainQ.add(root);

    while (mainQ.size() > 0) {
      //remove everything from mainQ ,then print and add children in childQ
      LinkedList<TreeNode> childQ = new LinkedList<>();

      while (mainQ.size() > 0) {
        TreeNode parent = mainQ.removeFirst();

        System.out.print(parent.data + " ,");

        //add its childere to child queue

        for (TreeNode child : parent.children) {
          childQ.add(child);
        }
      }

      mainQ = childQ;

      System.out.println();
    }
  }

  ///Approch 2
  public static void levelOrderLineWise2(TreeNode root) {
    LinkedList<TreeNode> mainQ = new LinkedList<>();
    LinkedList<TreeNode> childQ = new LinkedList<>();
    int level = 0;
    mainQ.add(root);

    while (mainQ.size() > 0) {
      TreeNode parent = mainQ.removeFirst();

      System.out.print(parent.data + " ");

      for (TreeNode child : parent.children) {
        childQ.add(child);
      }

      if (mainQ.size() == 0) {
        System.out.println();
        level++;
        mainQ = childQ;
        childQ = new LinkedList<>();
      }
    }
  }

  // Approch 3 using marker
  public static void levelOrderLineWiseWithSingleQueue(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();

    queue.add(root);
    queue.add(null);

    int level = 0;

    while (queue.size() > 0) {
      TreeNode frontNode = queue.removeFirst();

      if (frontNode != null) {
        //print node data
        System.out.print(frontNode.data + " ");
        //add its children to the que
        for (TreeNode child : frontNode.children) {
          queue.add(child);
        }
      } else {
        level++;
        System.out.println();
        if (queue.size() > 0) {
          //adding the marker
          queue.add(null);
        }
      }
    }
  }

  ///Approch 4
  public static void levelOrderLineWiseUsingQueSize(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    int level = 1;
    queue.add(root);

    while (queue.size() > 0) {
      System.out.print("Level " + level + " => ");
      int currentLevelSize = queue.size();

      while (currentLevelSize > 0) {
        TreeNode frontNode = queue.removeFirst();

        System.out.print(frontNode.data + " ");

        for (TreeNode child : frontNode.children) {
          queue.add(child);
        }
        currentLevelSize--;
      }
      level++;
      System.out.println();
    }
  }

  public static void printZicZac(TreeNode root) {
    Stack<TreeNode> mainSt = new Stack<>();
    Stack<TreeNode> childSt = new Stack<>();
    int level = 0;
    while (mainSt.size() > 0) {
      //odd level goes left to right

      TreeNode topNode = mainSt.pop();

      System.out.print(topNode.data + " ");

      if (level % 2 == 1) {
        for (int i = 0; i < topNode.children.size(); i++) {
          TreeNode child = topNode.children.get(i);
          childSt.push(child);
        }
      } else {
        for (int i = topNode.children.size() - 1; i >= 0; i--) {
          TreeNode child = topNode.children.get(i);
          childSt.push(child);
        }
      }

      if (mainSt.size() == 0) {
        level++;
        System.out.println();
        mainSt = childSt;
        childSt = new Stack<>();
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("Everything is fine");
    // int[] dataArray1 = {10,20,50,-1,60,-1,-1,30,-1,40,80,-1,90,-1,100,-1,-1,-1};
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

    // TreeNode root = constructTree(dataArray1);
    TreeNode root2 = constructTree(dataArray2);

    //  traverse(root2);

    // levelOrderTraversal(root2);

    // levelOrderTraversal(root2);
    // levelOrderLineWise(root2);
    // levelOrderLineWise2(root2);
    // levelOrderLineWiseWithSingleQueue(root2);
    // levelOrderLineWiseUsingQueSize(root2);
    printZicZac(root2);
  }
}
