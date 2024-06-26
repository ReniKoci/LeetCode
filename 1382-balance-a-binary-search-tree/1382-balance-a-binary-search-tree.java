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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        getSortedValues(root, arr);
        return constructBST(arr, 0, arr.size() - 1);
    }

    public TreeNode constructBST(ArrayList<Integer> arr, int left, int right){
        if (left > right)
            return null;

        int m = (left + right) / 2;
        TreeNode newRoot = new TreeNode(arr.get(m));
        newRoot.left = constructBST(arr, left, m - 1);
        newRoot.right = constructBST(arr, m + 1, right);

        return newRoot;
    }
    
    public void getSortedValues(TreeNode root, ArrayList<Integer> arr){
        if (root == null)
            return;
        getSortedValues(root.left, arr);
        arr.add(root.val);
        getSortedValues(root.right, arr);
    }

    public int getLeftAndRightHeight(TreeNode root){
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return rightHeight - leftHeight;
    }

    public int getHeight(TreeNode root){
        if(root == null)
            return 0;

        return Math.max(1 + getHeight(root.left), 1 + getHeight(root.right));
    }
}