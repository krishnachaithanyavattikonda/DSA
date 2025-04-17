package Tree;

public class FlattenBinaryTreeToLinkedList {
//    Starting from root 1:
//    Flatten left subtree of 1 → becomes: 2 → 3 → 4.
//    Flatten right subtree of 1 → becomes: 5 → 6.
//    Attach left (now right): 1 → 2 → 3 → 4.
//    Traverse to the end (4) and attach 5 → 6.
//  Input:         1
//                / \
//                2  5
//                /\   \
//                3 4   6
//   O/P: 1--2--3--4--5--6

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }



}
