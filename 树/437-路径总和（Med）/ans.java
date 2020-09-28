自己的解法一：
class Solution {
    int ans = 0;
    int sum = 0;
    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        preorder(root);
        return ans;
    }
    public void preorder(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root, sum);
        preorder(root.left);
        preorder(root.right);
    }
    public void dfs(TreeNode root, int sum){
        if(root == null){
            return;
        }
        sum -= root.val;
        if(sum == 0) ans++;
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

}
照着别人的解法敲的解法二：
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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum){
        if(node == null){
            return 0;
        }
        int res = 0;
        currSum += node.val;
        res += prefixSumCount.getOrDefault(currSum - target,0);
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0)+1);
        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
        res += recursionPathSum(node.right, prefixSumCount, target, currSum);
        prefixSumCount.put(currSum, prefixSumCount.get(currSum)-1);
        return res;
    }

}