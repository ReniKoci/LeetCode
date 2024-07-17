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

    List<TreeNode> res;
    Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        set = new HashSet<>();
        for(int to_del: to_delete)
            set.add(to_del);
        helper(root, true);
        
        return res;
    }

    public TreeNode helper(TreeNode root, boolean isRoot){
        if(root == null)
            return null;

        boolean toDel = set.contains(root.val);
        // isRoot references the previous node technically, showing that the previous node was deleted or not
        // toDel checks if the current node should be deleted, add to list if node is not to be deleted 
        if(isRoot && !toDel)
            res.add(root);

        // toDel shows if the previous node was deleted or not
        root.left = helper(root.left, toDel);
        root.right = helper(root.right, toDel);

        if(toDel)
            return null;

        return root;
    }
}