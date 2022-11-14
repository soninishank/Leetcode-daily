//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
         // We need inOrder indexes
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        // Pre Order - list
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            list.add(preorder[i]);
        }
        return helperTree(list, 0, inorder.length - 1, hashMap);
    }

    private static Node helperTree(List<Integer> preOrderList, int low, int high, HashMap<Integer, Integer> inOrderIndex) {
        if (low > high) {
            return null;
        }
        int root = preOrderList.get(0);// root element
        preOrderList.remove(0);
        int index = inOrderIndex.get(root); // index-1 : left subtree  // index+1 : right subtree

        Node treeNode = new Node(root);
        treeNode.left = helperTree(preOrderList,low, index - 1, inOrderIndex);
        treeNode.right = helperTree(preOrderList, index + 1, high, inOrderIndex);

        return treeNode;
    }
}
