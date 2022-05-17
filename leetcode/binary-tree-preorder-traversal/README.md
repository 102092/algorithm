> https://leetcode.com/problems/binary-tree-preorder-traversal/

```java
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }
        

        Stack<TreeNode> visited = new Stack<TreeNode>();
        visited.push(root);
        
        while(!visited.isEmpty()) {
            TreeNode node = visited.pop();
            result.add(node.val);
            
            if (node.right != null) {
                visited.push(node.right);
            }
            
            if (node.left != null) {
                visited.push(node.left);
            }
        }
        
        return result;
        
    }
}
```

- 아이디어
    - recursive or iterative
    - Stack 자료구조의 특징은, FILO을 이용, preorder의 경우 root 이후에 left의 서브트리를 먼저 탐색해야함.
        - 그러면 Stack에 right가 있을 경우 먼저 넣어놔야할듯.

- 제한조건
    - root == null 일 경우, empty list를 반환해줘야할듯

