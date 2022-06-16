```python
class Solution:
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
        # not roo1 and root2 라면, 존재하는 노드만 리턴
        # 어느 한쪽도 존재하지 않는다면, None 리턴
        if root1 and root2:
            node = TreeNode(root1.val + root2.val)
            node.left = self.mergeTrees(root1.left, root2.left)
            node.right = self.mergeTrees(root1.right, root2.right)
            return node
        else:
            return root1 or root2
```

```java
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        
        if(t2 == null) {
            return t1;
        }
        
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}

```

- 아이디어
    - 두 이진 트리를 병합하는 중복되는 노드, 그러니까 같은 위치에 있는 도느의 값은 합산.
    - 재귀를 사용할 수 있겠음.

- 제한조건
    - The number of nodes in both trees is in the range [0, 2000].
        - 노드들이 0, 그러니까 null이 들어올 수도 있을듯.

