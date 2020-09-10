> https://leetcode.com/problems/symmetric-tree

## 나의풀이

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMatched(root, root);
    }
    public boolean isMatched(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        return (t1.val == t2.val) && isMatched(t1.left, t2.right) && isMatched(t1.right, t2.left);

    }
}
```

## 필요개념
