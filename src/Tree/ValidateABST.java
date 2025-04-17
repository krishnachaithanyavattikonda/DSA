package Tree;

public class ValidateABST {
    public class Solution {
//        Left subtree has values less than the node’s value.
//        Right subtree has values greater than the node’s value.
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            //An empty tree is a valid BST
            if (root == null) return true;

            //If the current node violates the BST rule (i.e., its value is not strictly within (minVal, maxVal)), return false.
            if (root.val >= maxVal || root.val <= minVal) return false;
            return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
        }
    }
}
