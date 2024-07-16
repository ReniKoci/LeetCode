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

    public TreeNode getLCA(TreeNode root, int start, int dest){
        if(root == null ||  root.val == start || root.val == dest){
            return root;
        }

        TreeNode left = getLCA(root.left, start, dest);
        TreeNode right = getLCA(root.right, start, dest);

        // values are on different sides of root
        if(left != null && right != null)
            return root;

        // values on right side
        if(left == null)
            return right;

        return left;
    }

    public boolean traverse(TreeNode root, StringBuilder path, int dest){
        if(root == null)
            return false;

        if(root.val == dest)
            return true;

        // try left side
        path.append("L");
        if(traverse(root.left, path, dest))
            return true;
        
        // remove last cahr from path
        path.deleteCharAt(path.length() - 1);

        // try right siede
        path.append("R");
        if(traverse(root.right, path, dest))
            return true;
        
        // remove last cahr from path
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = getLCA(root, startValue, destValue);

        StringBuilder toStart = new StringBuilder();
        StringBuilder toDest = new StringBuilder();

        traverse(lca, toStart, startValue);
        traverse(lca, toDest, destValue);


        StringBuilder toStartUp = new StringBuilder();
        // transform toStart chars to "U"
        for (int i = 0; i < toStart.length(); i++) {
            toStartUp.append('U');
        }


        return toStartUp.append(toDest).toString();
    }
}