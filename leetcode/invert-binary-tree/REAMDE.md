```python
# 재귀 사용
# 
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root:
            root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
            return root
        return None
        
            


class Solution:
    # BFS, queue 구조를 사용해서 풀기

    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        queue = collections.deque([root])
        
        while queue:
            # 부모 노드 부터 아래로 내려가면서 스왑한다.
            node = queue.popleft()
            
            if node:
                # swap
                node.left, node.right = node.right, node.left
                queue.append(node.left)
                queue.append(node.right)
                
        return root
```

- IDEA
    - 재귀
    - BFS(queue), DFS(stack)도 가능할듯
    

- 제한사항
    - The number of nodes in the tree is in the range [0, 100]
        - root가 null이 들어올 수 있음을 체크해야함