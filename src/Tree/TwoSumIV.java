package Tree;

import java.util.HashSet;

class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hs=new HashSet<>();
        return findtargetInTree(root, k, hs );
    }

    private boolean findtargetInTree(TreeNode root, int k, HashSet<Integer> hs) {
        if(root==null){
            return false;
        }
        if(hs.contains(k-root.val)){
            return true;
        }
        hs.add(root.val);
        return findtargetInTree(root.left,k,hs) || findtargetInTree(root.right,k,hs);
    }
}