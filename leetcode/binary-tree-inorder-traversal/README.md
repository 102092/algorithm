> https://leetcode.com/problems/binary-tree-inorder-traversal/

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
    // left -> root -> right
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }
        
        Stack<TreeNode> visited = new Stack<TreeNode>();
        TreeNode curr = root;
        
        
        while (curr != null || visited.size() > 0) {
            while (curr != null) {
                visited.push(curr);
                curr = curr.left;
            }
            
            curr = visited.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        
        return result;
    }
}
```

- 아이디어
    - recursive or iterative

- 제한조건
    - root == null 일 경우, empty list를 반환해줘야할듯

- 기타
    - ![](https://yyc-images.oss-cn-beijing.aliyuncs.com/leetcode_94_using_stack_and_iterative.png)
    - stack에 어떻게 쌓이는지 참고해보면 좋을듯.