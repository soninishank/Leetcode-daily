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
    boolean flag =false;

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        inOrder(root, k);
        return flag;
    }

    private void inOrder(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        inOrder(root.left, target);
        int diff = target - root.val;
        if (hashmap.contains(diff)) {
            flag = true;
        }
        hashmap.add(root.val);
        inOrder(root.right, target);
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
