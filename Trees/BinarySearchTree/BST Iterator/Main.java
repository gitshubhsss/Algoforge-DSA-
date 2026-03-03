class TreeNode {

  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int data) {
    this.data = data;
  }
}

public class Main {

  public static TreeNode buildBST(int arr[], int si, int ei) {
    if (si >= ei) {
      return null;
    }
    //find the middle wala element

    int mid = (si + ei) / 2;

    //make the new TreeNode
    TreeNode root = new TreeNode(arr[mid]);

    root.left = buildBST(arr, si, mid - 1);
    root.right = buildBST(arr, mid + 1, ei);

    return root;
  }

  public static void display(TreeNode root) {
    if (root == null) {
      return;
    }

    String bstString =
      (root.left == null ? "." : root.left.data) +
      " <-- " +
      root.data +
      " --> " +
      (root.right == null ? "." : root.right.data);

    System.out.println(bstString);

    display(root.left);
    display(root.right);
  }

  public static TreeNode findLeftMost(TreeNode left, TreeNode curr) {
    while (left.left != null && left.left != curr) {
      left = left.left;
    }

    return left;
  }

  ///==================================================================LeetCode 173. Binary Search Tree Iterator ===================================
  class BSTIterator {

    Stack<TreeNode> st;

    public void addTillLeftMost(TreeNode node) {
      while (node != null) {
        st.push(node);
        node = node.left;
      }
    }

    public BSTIterator(TreeNode root) {
      st = new Stack<>();
      addTillLeftMost(root);
    }

    public int next() {
      TreeNode topNode = st.pop();

      if (topNode.right != null) {
        addTillLeftMost(topNode.right);
      }

      return topNode.val;
    }

    public boolean hasNext() {
      return st.size() > 0;
    }
  }

  // https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
  class Solution {

    Node prev;
    Node pred;
    Node succ;

    public void inorderTraverse(Node root, int key) {
      if (root == null) {
        return;
      }

      inorderTraverse(root.left, key);

      if (root.data < key) {
        pred = root;
      } else if (succ == null && root.data > key) {
        succ = root;
        return;
      }

      prev = root;

      inorderTraverse(root.right, key);
    }

    public ArrayList<Node> findPreSuc(Node root, int key) {
      prev = null;
      pred = null;
      succ = null;

      inorderTraverse(root, key);

      ArrayList<Node> ans = new ArrayList<>();
      ans.add(pred);
      ans.add(succ);

      return ans;
    }
  }

  public static Node findRightMost(Node temp) {
    while (temp.right != null) {
      temp = temp.right;
    }
    return temp;
  }

  public static Node findLeftMost(Node temp) {
    while (temp.left != null) {
      temp = temp.left;
    }
    return temp;
  }

  public ArrayList<Node> findPreSuc(Node root, int key) {
    Node pred = null;
    Node succ = null;

    Node curr = root;

    while (curr != null) {
      if (curr.data < key) {
        pred = curr;
        curr = curr.right;
      } else if (curr.data > key) {
        succ = curr;
        curr = curr.left;
      } else {
        if (curr.left != null) {
          pred = findRightMost(curr.left);
        }
        if (curr.right != null) {
          succ = findLeftMost(curr.right);
        }
        break;
      }
    }

    ArrayList<Node> ans = new ArrayList<>();
    ans.add(pred);
    ans.add(succ);

    return ans;
  }

  class Solution {
    Node head;
    Node prev;
    public void inorder(Node root){
        //base case
        if(root==null){
            return
        }
        
        //travel
        inorder(root.left);
        
        if(head==null){
            head=root;
            prev=root;
            root.left=null;
        }else{
            prev.right=root;
            root.left=prev;
            prev= root;
        }
        
        inorder(root.right);
    }
    
    Node bToDLL(Node root) {
        // code here
        inorder(root);
        return head;
    }
}

  public static void main(String args[]) {
    int[] arr = { 1, 2, 3, 5, 8, 10, 12, 13, 15, 18 };

    TreeNode root = buildBST(arr, 0, arr.length - 1);

    display(root);
  }
}
