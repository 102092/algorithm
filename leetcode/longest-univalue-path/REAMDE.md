```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # 1. 트리 말단 (리프 노드) 까지 내려간다.
    # 2. 백트래킹으로 같은 값의 거리를 쌓아 올린다.
    result: int = 0
    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        def dfs(node: TreeNode) -> int:
            if node is None:
                return 0
            
            left = dfs(node.left)
            right = dfs(node.right)
            
            if node.left and node.left.val == node.val:
                left += 1
            else:
                left = 0
            if node.right and node.right.val == node.val:
                right += 1
            else:
                right = 0
            
            self.result = max(self.result, left + right)
            return max(left, right)
        dfs(root)
        return self.result
            

```
---

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
    
    public int result = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        dfs(root);
        return this.result;
        
    }
    
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        if (node.left != null && node.left.val == node.val) {
            left += 1;
        } else {
            left = 0;
        }
        
        if (node.right != null && node.right.val == node.val) {
            right += 1;
        } else {
            right = 0;
        }
        
        this.result = Math.max(this.result, left + right);
        return Math.max(left, right);
        
    }
}
```

- IDEA
    - 동일한 숫자가 이어진다면, 그 이어지는 거리는 얼마나 되는가.
    - 주어진 사진에서 5-5-5 거리는 2로 측정된다.
    - 그러면 우선 최말단 리프 노드까지 내려간 후에, 하나씩 올라오면서 만약 node.val이 같다면 1씩 더해서 반환해주는 이런 방식을 취하면 될 것 같다.

- 제한사항
    - The number of nodes in the tree is in the range [0, 104].
        - root 가 null이 들어올 수도 있다는 의미인듯.
    - `-1000 <= Node.val <= 1000`
    



    
