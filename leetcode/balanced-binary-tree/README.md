```python
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def height(root):
            if not root:
                return 0
            
            left = height(root.left)
            right = height(root.right)
            
            if left == -1 or right == -1 or abs(left - right) > 1:
                return -1
            return max(left, right) + 1
        return height(root) != -1
```

- 아이디어
    - 재귀
    - 높이 값을 +1씩 더해가면서 리턴하는 방식
    - 높이 값이 한번 차이가 나면, 즉 -1이면, balance 트리가 아니다.

- 제한조건
    - The number of nodes in the tree is in the range [0, 5000].
        - 노드들이 0, null이 들어올 수도 있을듯.

