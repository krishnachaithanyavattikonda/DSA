package Tree;

import java.util.HashMap;

class BTFromInOrderPreOrder {

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        int[] index = {0};
        return helper(preOrder, inOrder, 0, preOrder.length-1, map, index);
    }
    public TreeNode helper(int[] preOrder, int[] inOrder, int left, int right, HashMap<Integer, Integer> map, int[] index) {
        if (left > right) {
            return null;
        }
        int current = preOrder[index[0]];
        index[0]++;
        TreeNode node = new TreeNode(current);
        if (left == right) {
            return node;
        }
        int inOrderIndex=map.get(current);
        node.left = helper(preOrder, inOrder, left, inOrderIndex - 1, map, index);
        node.right = helper(preOrder, inOrder, inOrderIndex + 1, right, map, index);
        return node;
    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }