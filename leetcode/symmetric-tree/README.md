> https://leetcode.com/problems/symmetric-tree/

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
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(root.left);
        s2.push(root.right);
        
        while(!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode t1 = s1.pop();
            TreeNode t2 = s2.pop();
            
            if (t1 == null && t2 == null) {
                continue;
            }
            
            if (t1 == null || t2 == null) {
                return false;
            }
            
            if (t1.val != t2.val) {
                return false;
            }
            
            s1.push(t1.left);
            s1.push(t1.right);
            s2.push(t2.right);
            s2.push(t2.left);
        }
        
        return true;
    }
}
```

- 아이디어
    - 재귀 or 반복
    - [재귀 풀이](https://leetcode.com/submissions/detail/703091685/)

- 제한조건
    - root == null인 경우 검증할 필요 없을듯. (그럴 일이 없으므로)
    - root만 있을 경우, 즉 root.left == null && root.right == null 이면 true 반환해야할듯.

