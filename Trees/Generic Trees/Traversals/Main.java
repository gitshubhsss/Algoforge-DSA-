import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Collections;
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

  ///code pending
  public static TreeNode makeMirror(TreeNode root) {
    int childrenSize = root.children.size();

    int left = 0;
    int right = childrenSize - 1;

    while (left <= right) {
      TreeNode leftNode = root.children.get(left);
      TreeNode leftMirror = makeMirror(leftNode);

      TreeNode rightNode = root.children.get(right);
      TreeNode rightMirror = left != right ? makeMirror(rightNode) : rightNode;

      root.children.set(left, rightMirror);

      root.children.set(right, leftMirror);

      left++;
      right--;
    }

    return root;
  }

  //Dryrun pending why inorder
  public static void removeLeafNode(TreeNode root) {
    //remove leaf nodes

    for (int i = root.children.size() - 1; i >= 0; i--) {
      TreeNode child = root.children.get(i);

      if (child.children.size() == 0) {
        root.children.remove(i);
      }
    }

    for (TreeNode child : root.children) {
      removeLeafNode(child);
    }
  }

  ///why not post order
  // public static void removeLeafNode(TreeNode root) {
  //   for (TreeNode child : root.children) {
  //     removeLeafNode(child);
  //   }
  //   //remove leaf nodes
  //   for (int i = root.children.size() - 1; i >= 0; i--) {
  //     TreeNode child = root.children.get(i);
  //     //agar woh leaf node hai
  //     if (child.children.size() == 0) {
  //       root.children.remove(i);
  //     }
  //   }
  // }

  public static TreeNode findTail(TreeNode root) {
    TreeNode temp = root;

    while (temp.children.size() > 0) {
      temp = temp.children.get(temp.children.size() - 1);
    }
    return temp;
  }

  public static TreeNode linearizeGT(TreeNode root) {
    for (TreeNode child : root.children) {
      linearizeGT(child);
    }

    while (root.children.size() > 1) {
      int childrenSize = root.children.size();

      TreeNode lastChild = root.children.get(childrenSize - 1);
      TreeNode secondLastChild = root.children.get(childrenSize - 2);

      TreeNode tail = findTail(secondLastChild);

      root.children.remove(lastChild); //remove the last child
      tail.children.add(lastChild); //add last child to the tail of second last
    }

    return root;
  }

  public static TreeNode lineariseGT_better(TreeNode root) {
    //base case
    if (root.children.size() == 0) {
      return root;
    }

    TreeNode lastChildTail = lineariseGT_better(
      root.children.get(root.children.size() - 1)
    );

    while (root.children.size() > 1) {
      int childrenSize = root.children.size();
      TreeNode lastChild = root.children.get(childrenSize - 1);
      TreeNode secondLastChild = root.children.get(childrenSize - 2);
      TreeNode secondLastChildTail = lineariseGT_better(secondLastChild);
      root.children.remove(childrenSize - 1);
      secondLastChildTail.children.add(lastChild);
    }

    return lastChildTail;
  }

  public static boolean find(TreeNode root, int tar) {
    if (root.data == tar) {
      return true;
    }

    for (TreeNode child : root.children) {
      boolean isExists = find(child, tar);

      if (isExists) {
        return true;
      }
    }

    return false;
  }

  public static ArrayList<TreeNode> nodeToRootPath(TreeNode root, int tar) {
    if (root.data == tar) {
      ArrayList<TreeNode> baseAns = new ArrayList<>();
      baseAns.add(root);
      return baseAns;
    }

    for (TreeNode child : root.children) {
      ArrayList<TreeNode> subPath = nodeToRootPath(child, tar);
      if (subPath.size() > 0) {
        subPath.add(root);
        return subPath;
      }
    }
    return new ArrayList<>();
  }

  public static TreeNode findLCA(TreeNode root, int tar1, int tar2) {
    ArrayList<TreeNode> ntrPath1 = nodeToRootPath(root, tar1);
    ArrayList<TreeNode> ntrPath2 = nodeToRootPath(root, tar2);

    int i = ntrPath1.size() - 1;
    int j = ntrPath2.size() - 1;

    while (i >= 0 && j >= 0 && ntrPath1.get(i).data == ntrPath2.get(j).data) {
      i--;
      j--;
    }
    return ntrPath1.get(i + 1); //ntrPath2.get(j);
  }

  public static boolean isMirror(TreeNode n1, TreeNode n2) {
    if (n1.data != n2.data || n1.children.size() != n2.children.size()) {
      return false;
    }

    for (int i = 0, j = n2.children.size() - 1; j >= 0; i++, j--) {
      boolean isChildMirror = isMirror(n1.children.get(i), n2.children.get(j));

      if (isChildMirror == false) {
        return false; //no more child checked
      }
    }

    return true;
  }

  public static boolean isTreeSymmetric(TreeNode root) {
    return isMirror(root, root);
  }

  public static void sortArray(int arr[]) {
    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
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
      80,
      100,
      -1,
      110,
      -1,
      -1,
      90,
      -1,
      -1,
      40,
      120,
      -1,
      -1,
      -1,
    };

    int[] symArra = {
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
      70,
      -1,
      -1,
      20,
      60,
      70,
      -1,
      -1,
      -1,
    };
    // TreeNode root2 = constructTree(symArra);

    // System.out.println(isTreeSymmetric(root2));

    sortArray(symArra);
    // TreeNode lca = findLCA(root2, 80, 90);

    //    System.out.println(lca.data);

    //   display(root2);

    // System.out.println("After removing the  leaf nodes");

    // removeLeafNode(root2);

    // display(root2);

    // System.out.println(find(root2, 120));

    //System.out.println(nodeToRootPath(root2, 120));
  }
}
