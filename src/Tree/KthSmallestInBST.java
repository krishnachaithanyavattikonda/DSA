package Tree;

import java.util.PriorityQueue;

public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        findSmallest(root,minHeap,k);
        int ans=0;
        for (int i = 0; i < k; i++) {
            ans=minHeap.poll();
        }
        return ans;
    }

    private void findSmallest(TreeNode root, PriorityQueue<Integer> minHeap, int k) {
        if(root==null){
            return;
        }
        findSmallest(root.left,minHeap,k);
        minHeap.offer(root.val);
        findSmallest(root.right,minHeap,k);
    }
}
