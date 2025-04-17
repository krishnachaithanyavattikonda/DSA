package Tree;

public class DiameterOfABinaryTree {
//    Input: root = [1,2,3,4,5]
//    Output: 3
//    Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        helper(root);
        return diameter;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
