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
    HashSet<Integer> hashmap = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return inOrder(root, k);
    }

    private boolean inOrder(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if(inOrder(root.left, target)){
            return true;
        }
        int diff = target - root.val;
        if (hashmap.contains(diff)) {
           return true;
        }
        hashmap.add(root.val);
        return inOrder(root.right, target);
    }
}
// HashMap<Integer, Integer> hashmap = new HashMap<>();
//     public int[] twoSum(int[] nums, int target) {
//         for (int i = 0; i < nums.length; i++) {
//             int diff = target - nums[i];
//             if (hashmap.containsKey(diff)) {
//                 return new int[] { hashmap.get(diff), i };
//             }
//             hashmap.put(nums[i], i);
//         }
//         throw new IllegalArgumentException();
//     }
