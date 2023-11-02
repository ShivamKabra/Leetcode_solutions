/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int count=0;

    public int[] helper(TreeNode root){
        if(root==null){
            return new int[]{0, 0};
        }

        int[] leftSubtree = helper(root.left);
        int[] rightSubtree = helper(root.right);

        int sum = leftSubtree[0]+rightSubtree[0]+root.val;
        int num = leftSubtree[1]+rightSubtree[1]+1;

        if(sum/num == root.val){
            count++;
        }

        return new int[]{sum, num};
    }
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return count;
    }
}