> https://leetcode.com/problems/maximum-depth-of-binary-tree/

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return Math.max(left, right) + 1;
        
    }
}
```

- 아이디어
    - 재귀

- 제한조건
    - root == null인 경우
    - 그리고 최종적으로 max()로 리턴해주는 값에 1을 더해줘야함.
        - 왜? `left`, `right` 로 넘어왔다는 건 어떤 값이 있다는 뜻이고 그 이야기는 1 depth는 된다는 뜻.



- 시간복잡도
    - O(N), 모든 노드를 다 돌아볼듯.

