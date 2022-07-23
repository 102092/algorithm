```python
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        table = {
            ')' : '(',
            '}' : '{',
            ']' : '['
        }
        
        
        for char in s:
            if char not in table:
                stack.append(char) # if (, {, [ will be pushed
            elif not stack: # if stack is empty. 
                return False
            elif table[char] != stack.pop():
                return False
        
        return len(stack) == 0
```

- 아이디어
    - stack 이용
