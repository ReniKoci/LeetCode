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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode createTree(int[] preorder, int[] inorder, int preorderStartIndex, int inorderStartIndex, int inorderEndIndex){

        if(preorderStartIndex > preorder.length - 1 || inorderStartIndex > inorderEndIndex)
            return null;

        TreeNode node = new TreeNode(preorder[preorderStartIndex]);
        int inorderNodeIndex = 0; // save the index of the node in inorder array
        for(int i = inorderStartIndex; i <= inorderEndIndex; i++){
            if(inorder[i] == node.val)
                inorderNodeIndex = i;
        }

        // explore only the left side of the array until the index of the node
        node.left = createTree(preorder, inorder, preorderStartIndex + 1, inorderStartIndex, inorderNodeIndex - 1);

        int leftSideNodes = inorderNodeIndex - inorderStartIndex + 1;
        node.right = createTree(preorder, inorder, preorderStartIndex + leftSideNodes, inorderNodeIndex + 1, inorderEndIndex);
        
        return node;

    }
}