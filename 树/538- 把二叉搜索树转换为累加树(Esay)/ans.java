/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        mider(root);
        return root;
    }
    public void mider(TreeNode root){
        if(root == null){
            return;
        }
        mider(root.right);
        root.val = sum + root.val;
        sum = root.val;
        mider(root.left);
    }
}