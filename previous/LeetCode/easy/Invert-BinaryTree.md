> https://leetcode.com/problems/invert-binary-tree/

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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }
}
```

## 필요개념

- 재귀 (근본 조건에 반드시 걸려야함)
- DFS, Deep First Search 아마도 ?
