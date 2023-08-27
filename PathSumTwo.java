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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        helper(root,new ArrayList<>(),targetSum,0);
        return result;
    }

    public void helper(TreeNode root, List<Integer> path, int targetSum, int sum){
        if(root==null){
            return;
        }

        sum += root.val;
        path.add(root.val);
        
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                result.add(new ArrayList<>(path));
            }
        }
        helper(root.left,path,targetSum,sum);
        helper(root.right,path,targetSum,sum);
        //
        path.remove(path.size()-1);
    }
}
