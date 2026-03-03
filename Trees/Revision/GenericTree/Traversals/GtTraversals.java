import java.util.*;

class TreeNode {

  int data;
  ArrayList<TreeNode> children;

  public TreeNode() {}

  public TreeNode(int data) {
    this.data = data;
    children = new ArrayList<TreeNode>();
  }
}

public class GtTraversals {

  public static TreeNode constructTree(int arr[]) {
    TreeNode root = null;
    Stack<TreeNode> st = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      int data = arr[i];

      if (data == -1) {
        st.pop();
      } else {
        TreeNode newNode = new TreeNode(data);

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

  public static void display(TreeNode root) {
    System.out.print(root.data + " ");

    for (TreeNode child : root.children) {
      System.out.print(child.data + " ");
    }

    System.out.println();

    for (TreeNode child : root.children) {
      display(child);
    }
  }

  ////====================================================PREORDER,INORDER,POSTORDER (TRAVERSALS)========================================================

  public static void traverse(TreeNode root) {
    System.out.println("Preorder ---> " + root.data);
    for (TreeNode child : root.children) {
      System.out.println(
        "Traversing on edge from  " + root.data + " --> " + child.data
      );
      traverse(child);
      System.out.println(
        "Traversing on edge from " + child.data + " --> " + root.data
      );
    }

    System.out.println("PostOrder ----> " + root.data);
  }

  //===============================================================LEVEL ORDER TRAVERLS======================================================================

  // method 1

  public static void levelOrderTraverse1(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<>();
    que.add(root);

    while (que.size() > 0) {
      //remove children
      TreeNode topNode = que.removeFirst();

      //print data
      System.out.print(topNode.data + " ");

      //add children
      for (TreeNode child : topNode.children) {
        que.add(child);
      }
    }
  }

  //method 2 line wise

  public static void levelOrderTraverse2(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<TreeNode>();
    que.add(root);

    while (que.size() > 0) {
      LinkedList<TreeNode> childQ = new LinkedList<TreeNode>();

      while (que.size() > 0) {
        TreeNode topNode = que.removeFirst();
        System.out.print(topNode.data + " ");

        for (TreeNode child : topNode.children) {
          childQ.add(child);
        }
      }

      System.out.println();
      que = childQ;
    }
  }

  //method 3 line wise with single loop
  public static void levelOrderTraverse3(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<TreeNode>();
    LinkedList<TreeNode> childQ = new LinkedList<TreeNode>();
    int level = 0;

    que.add(root);

    while (que.size() > 0) {
      //remove top node
      TreeNode topNode = que.removeFirst();

      System.out.print(topNode.data + " ,");

      //add childrens
      for (TreeNode child : topNode.children) {
        childQ.add(child);
      }

      if (que.size() == 0) {
        level++;
        System.out.println();
        que = childQ;
        childQ = new LinkedList<TreeNode>();
      }
    }
  }

  //method 4 using marker

  public static void levelOrderTraverse4(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<TreeNode>();
    que.add(root);
    que.add(null);

    while (que.size() > 0) {
      TreeNode topNode = que.removeFirst();

      if (topNode == null) {
        if (que.size() > 0) {
          que.add(null);
        }
        System.out.println();
      } else {
        System.out.print(topNode.data + " ");

        for (TreeNode child : topNode.children) {
          que.add(child);
        }
      }
    }
  }

  //method 5
  public static void levelOrderTraverse5(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<TreeNode>();
    que.add(root);

    while (que.size() > 0) {
      int size = que.size();

      while (size > 0) {
        TreeNode topNode = que.removeFirst();

        System.out.print(topNode.data + " ");

        for (TreeNode child : topNode.children) {
          que.add(child);
        }
        size--;
      }

      System.out.println();
    }
  }

  //==============================================================================ZIC ZAC Traversal=====================================================================

  public static void ziczacTraversal(TreeNode root) {
    Stack<TreeNode> st = new Stack<TreeNode>();

    int level = 1;
    st.push(root);

    while (st.size() > 0) {
      Stack<TreeNode> childSt = new Stack<TreeNode>();

      if (level % 2 == 1) {
        while (st.size() > 0) {
          TreeNode topNode = st.pop();

          System.out.print(topNode.data + " ");

          for (int i = topNode.children.size() - 1; i >= 0; i--) {
            childSt.push(topNode.children.get(i));
          }
        }
      } else {
        while (st.size() > 0) {
          TreeNode topNode = st.pop();

          System.out.print(topNode.data + " ");

          for (TreeNode child : topNode.children) {
            childSt.push(child);
          }
        }
      }

      st = childSt;
      level++;
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int arr[] = {
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

    TreeNode root = constructTree(arr);

    // display(root);

    // traverse(root);
    // levelOrderTraverse1(root);
    // levelOrderTraverse2(root);
    // levelOrderTraverse3(root);
    // levelOrderTraverse4(root);
    // levelOrderTraverse5(root);
    //  levelOrderTraverse3(root);
    //  System.out.println("=======================");
    ziczacTraversal(root);
  }
}
