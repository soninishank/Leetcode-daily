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
    HashMap<Integer, Set<Integer>> hashmap = new HashMap<>();
    int count = 0;

    public int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }
        buildTree(root, null);
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int num : hashmap.get(current)) {
                    if (!visited.contains(num)) {
                        visited.add(num);
                        queue.add(num);
                    }
                }
            }
            count++;
        }
        return count-1;
    }

    private void buildTree(TreeNode root, Integer parent) {
        if (root == null) {
            return;
        }
        if (!hashmap.containsKey(root)) {
            hashmap.put(root.val, new HashSet<>());
        }
        Set<Integer> set = hashmap.get(root.val);
        if (parent != null) {
            set.add(parent);
        }
        if (root.left != null) {
            set.add(root.left.val);
        }
        if (root.right != null) {
            set.add(root.right.val);
        }
        buildTree(root.left, root.val);
        buildTree(root.right, root.val);
    }
}
