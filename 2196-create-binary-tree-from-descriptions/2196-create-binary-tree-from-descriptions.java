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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>(); // child: parent
        Set<Integer> set = new HashSet<>();
        for(int[] desc: descriptions){
            int parent = desc[0];
            int kid = desc[1];
            int side = desc[2];

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(kid, new TreeNode(kid));

            if(side == 1){
                map.get(parent).left = map.get(kid);
            }else{
                map.get(parent).right = map.get(kid);
            }

            set.add(kid);
        }

        // root is the node with no parent
        for(int[] desc: descriptions){
            int parent = desc[0];
            if(!set.contains(parent)){
                // actual return
                return map.get(parent);
            }
        }

        // make compiler happy
        return new TreeNode();
    }
}