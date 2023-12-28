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
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> resultList = new ArrayList<>();
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            resultList.add(new ArrayList<>(list));
        }
        if(resultList.size() > 0){
            List<Integer> list = resultList.get(resultList.size()-1);
            for(int i = 0 ; i < list.size(); i++){
                sum += list.get(i);
            }
        }
        return sum;
    }
}
