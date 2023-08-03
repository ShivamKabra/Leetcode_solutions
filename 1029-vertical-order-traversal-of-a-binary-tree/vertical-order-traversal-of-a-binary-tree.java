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

class Pair{
    TreeNode node;
    int row;
    int col;
    public Pair(TreeNode node, int col, int row){
        this.node = node;
        this.col = col;
        this.row = row;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.add(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int x = p.col;
            int y = p.row;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }

            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).add(node.val);

            if(node.left!=null){
                q.add(new Pair(node.left, x-1, y+1));
            }

            if(node.right!=null){
                q.add(new Pair(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : ys.values()){
                while(!pq.isEmpty()){
                    ans.get(ans.size()-1).add(pq.remove());
                }
            }
        }

        return ans;

    }
}