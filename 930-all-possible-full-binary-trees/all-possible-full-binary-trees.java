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
    ArrayList<TreeNode> result = new ArrayList<>();
    public List<TreeNode> solve(int n) {
    if (n % 2 == 0) {
        return new ArrayList<>();
    }
    if (n == 1) {
        TreeNode root = new TreeNode(0);
        return new ArrayList<>(List.of(root));
    }

    List<TreeNode> currentResult = new ArrayList<>(result);  // Create a copy of the result list

    for (int i = 1; i < n; i = i + 2) {
        List<TreeNode> leftFBT = solve(i);
        List<TreeNode> rightFBT = solve(n - i - 1);

        for (TreeNode left : leftFBT) {
            for (TreeNode right : rightFBT) {
                TreeNode root = new TreeNode(0);
                root.left = left;
                root.right = right;
                currentResult.add(root);
            }
        }
    }
    return currentResult;
}


    public List<TreeNode> allPossibleFBT(int n) {
        return solve(n);
    }
}
