> https://leetcode.com/problems/maximum-depth-of-binary-tree/


```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # 거리값
    longest: int = 0
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        def dfs(node: TreeNode) -> int:
            if not node:
                return -1
            # 상태값
            left = dfs(node.left)
            right = dfs(node.right)
            
            self.longest = max(self.longest, left + right + 2)
            return max(left, right) + 1
        dfs(root)
        return self.longest
        

```

---

```java

class Solution {
    public int longest = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return longest;
    }
    
    public int dfs (TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        longest = Math.max(longest, left + right + 2);
        return Math.max(left, right) + 1;
    }
}
```

- 아이디어
    - dfs
    - 상태값은 리프노드에서, 현재노드까지의 거리
    - 거리값 (longest) 는 왼쪽노드의 상태값과, 오른쪽 노드의 상태값의 합에 2를 더한 값
    - 2를 왜 더하나? 루트를 거쳐 거리값이 측정되기 때문에


- 기타
    - 정 이진트리 : 모든 노드가 0개 혹은 2개의 자식을 가질 때
    - 상태값, 거리값에 대한 개념을 생각해내지 못했음.