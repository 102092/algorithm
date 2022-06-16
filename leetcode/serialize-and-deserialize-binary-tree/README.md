```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root) -> str:
        q = collections.deque([root])
        result = []
        
        while q:
            node = q.popleft()
            if node:
                q.append(node.left)
                q.append(node.right)
                result.append(str(node.val))
            else:
                result.append('#')
        return ' '.join(result)
        

    def deserialize(self, data) -> TreeNode:
        # '#'가 나왔다는 의미는 직렬화할 당시 root가 null이 들어왔다는 의미
        if data == '#':
            return None
        
        nodes = data.split()
        
        root = TreeNode(int(nodes[0]))
        q = collections.deque([root])
        index = 1
        
        while q:
            node = q.popleft()
            if nodes[index] is not '#' :
                node.left = TreeNode(int(nodes[index]))
                q.append(node.left)
            index += 1
            
            if nodes[index] is not '#' :
                node.right = TreeNode(int(nodes[index]))
                q.append(node.right)
            index += 1
        return root
        
```


- 아이디어
    - 직렬화, 역직렬화를 어떻게 할 지 포멧은 정해진바가 없는듯. 
    - 이 부분을 내가 정하는게 포인트

- 제한조건
    - root, data가 null 일수도 있겠음.

- 기타
    - 파이썬에서는 `pickle`이라는 직렬화 모듈이 있음.
