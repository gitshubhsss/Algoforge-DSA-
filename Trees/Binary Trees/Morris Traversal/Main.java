import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {

  int data;
  TreeNode left;
  TreeNode right;

  public TreeNode(int data) {
    this.data = data;
  }
}

class Pair {

  TreeNode node;
  int state;

  public Pair(TreeNode node, int state) {
    this.node = node;
    this.state = state;
  }
}

public class Main {

  public static TreeNode buildTree(Integer[] arr) {
    TreeNode root = null;

    Stack<Pair> st = new Stack<>();

    for (int i = 0; i < arr.length; i++) {
      Integer ele = arr[i];

      if (ele == null) {
        if (st.size() == 0) {
          return null;
        } else if (st.peek().state == 0) {
          //simply increase the state
          st.peek().state++;
        } else {
          //if the state is 1 then pop it from the stack means right is also null
          st.pop();
        }
      } else {
        //making the new node
        TreeNode newNode = new TreeNode(ele);
        if (st.size() == 0) {
          root = newNode;
        } else if (st.peek().state == 0) {
          st.peek().node.left = newNode;
          st.peek().state++;
        } else {
          st.peek().node.right = newNode;
          st.pop();
        }
        st.push(new Pair(newNode, 0));
      }
    }

    return root;
  }

  /// Space O(1) Traversal
  public static TreeNode findRightMost(TreeNode temp, TreeNode curr) {
    while (temp.right != null && temp.right != curr) {
      temp = temp.right;
    }

    return temp;
  }

  public static void morrisTraverse(TreeNode root) {
    TreeNode curr = root;

    while (curr != null) {

      if (curr.left == null) {
        curr = curr.right;
      } else {
        
        TreeNode rightMost = findRightMost(curr.left, curr);
        // create the thread
        if (rightMost.right == null) {
          rightMost.right = curr;
          curr = curr.left;
        } else {
          //break the thread
          rightMost.right=null
          curr=curr.right;
      }
    }
  }

  ///================================================================ Morris Inorder ====================================================================

class Solution {

    public TreeNode rightMost(TreeNode left, TreeNode curr) {
        while (left.right != null && left.right != curr) {
            left = left.right;
        }
        return left;
    }

    public void morrisTraverse(TreeNode root, List<Integer> ans) {

        TreeNode curr = root;

        while (curr != null) {

            if (curr.left == null) {

                ans.add(curr.val);
                //go to right
                curr = curr.right;
            } else {
                //find the rightmost
                TreeNode rightMost = rightMost(curr.left, curr);

                if (rightMost.right == null) {
                    rightMost.right = curr;
                    curr = curr.left;
                } else {
                    ans.add(curr.val);
                    rightMost.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        morrisTraverse(root, ans);
        return ans;
    }
}

  ///======================================================================== Morris Preorder traveral =============================

 class Solution {
    public TreeNode rightMost(TreeNode left, TreeNode curr) {
        while (left.right != null && left.right != curr) {
            left = left.right;
        }

        return left;
    }

    public void morrisTraverse(TreeNode root, List<Integer> ans) {

        TreeNode curr = root;

        while (curr != null) {

            if (curr.left == null) {

                ans.add(curr.val);
                //go to right
                curr = curr.right;
            } else {
                //find the rightmost
                TreeNode rightMost = rightMost(curr.left, curr);

                if (rightMost.right == null) {
                    ans.add(curr.val);
                    rightMost.right = curr;
                    curr = curr.left;
                } else {
                    rightMost.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();

        morrisTraverse(root, ans);

        return ans;
    }
}

  ///======================================================================= Morris PostOrder ==================================================================

 class Solution {

    public TreeNode findLeftMost(TreeNode right, TreeNode curr) {

        while (right.left != null && right.left != curr) {
            right = right.left;
        }

        return right;
    }

    public void morrisTraverse(TreeNode root, List<Integer> ans) {

        TreeNode curr = root;

        while (curr != null) {

            if (curr.right == null) {
                ans.add(curr.val);
                curr = curr.left;
            } else {

                //find the leftMost

                TreeNode leftMost = findLeftMost(curr.right, curr);

                if (leftMost.left == null) {
                    ans.add(curr.val);
                    leftMost.left = curr;
                    curr = curr.right;
                } else {
                    leftMost.left = null;
                    curr = curr.left;
                }
            }
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<Integer>();

        morrisTraverse(root, ans);

        Collections.reverse(ans);

        return ans;
    }
}

  // recover tree

  class Solution {

    public void inorderTraversal(TreeNode root, ArrayList<TreeNode> inorder) {
      if (root == null) {
        return;
      }

      inorderTraversal(root.left, inorder);
      inorder.add(root);
      inorderTraversal(root.right, inorder);
    }

    public void recoverTree(TreeNode root) {
      ArrayList<TreeNode> inorder = new ArrayList<TreeNode>();

      TreeNode a = null,
        b = null;
      inorderTraversal(root, inorder);

      TreeNode prev = inorder.get(0);

      for (int i = 1; i < inorder.length; i++) {
        TreeNode curr = inorder.get(i);

        if (prev.val >= curr.val) {
          b = curr;
          if (a == null) {
            a = curr;
          } else {
            break;
          }
        }
        prev = curr;
      }

      int temp = a.val;
      a.val = b.val;
      b.val = temp;
    }
  }

  public static void main(String[] args) {}
}
