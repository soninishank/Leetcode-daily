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
    int globalSum = 0;
    List<String> list = new ArrayList<>();

    public int pseudoPalindromicPaths(TreeNode root) {
        getTotalSum(root, new HashMap<>());
        return globalSum;
    }

    private boolean countPalindromes(HashMap<Integer,Integer> hashmap) {
        int count = 0;
        for (int ch : hashmap.keySet()) {
            if (hashmap.get(ch) % 2 == 1) {
                count++;
            }
        }
        return count < 2;
    }

    private void getTotalSum(TreeNode root, HashMap<Integer,Integer> hashmap) {
        if (root == null) {
            return;
        }
        hashmap.put(root.val,hashmap.getOrDefault(root.val,0)+1);
        if (root.left == null && root.right == null) {
            if(countPalindromes(hashmap)){
                globalSum++;
            }
            hashmap.put(root.val,hashmap.getOrDefault(root.val,0)-1);
            return;
        }
        getTotalSum(root.left, hashmap);
        getTotalSum(root.right, hashmap);
        
        hashmap.put(root.val,hashmap.getOrDefault(root.val,0)-1);
    }
}


// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     int globalSum = 0;
//     List<String> list = new ArrayList<>();

//     public int pseudoPalindromicPaths(TreeNode root) {
//         getTotalSum(root, "");
//         for (String str : list) {
//             if (countPalindromes(str)) {
//                 globalSum++;
//             }
//         }
//         return globalSum;
//     }

//     private boolean countPalindromes(String str) {
//         HashMap<Character, Integer> hashmap = new HashMap<>();
//         for (int i = 0; i < str.length(); i++) {
//             char c1 = str.charAt(i);
//             hashmap.put(c1, hashmap.getOrDefault(c1, 0) + 1);
//         }
//         int count = 0;
//         for (char ch : hashmap.keySet()) {
//             if (hashmap.get(ch) % 2 == 1) {
//                 count++;
//             }
//         }
//         return count < 2;
//     }

//     private void getTotalSum(TreeNode root, String str) {
//         if (root == null) {
//             return;
//         }
//         str += root.val;
//         if (root.left == null && root.right == null) {
//             list.add(str);
//             return;
//         }
//         getTotalSum(root.left, str);
//         getTotalSum(root.right, str);
//     }
// }
