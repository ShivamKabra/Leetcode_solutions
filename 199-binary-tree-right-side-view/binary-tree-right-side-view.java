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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<Integer> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(root==null){
            return ans;
        }
        q.add(root);
        ans.add(root.val);

        while(!q.isEmpty()){
            int size = q.size();


            
            for(int i=0;i<size;i++){
                TreeNode front = q.remove();
                if(front.left!=null){
                    q.add(front.left);
                    temp.add(front.left.val);
                }
                if(front.right!=null){
                    q.add(front.right);
                    temp.add(front.right.val);
                }
            }

            if(!temp.isEmpty()){
                ans.add(temp.get(temp.size()-1));
            }
            temp.clear();
           
        }

        return ans;
    }
}