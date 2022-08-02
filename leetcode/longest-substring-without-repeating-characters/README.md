```python
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # if s is ""
        if len(s) == 0:
            return 0
        
        seen = {}
        max_length = start = 0
        
        for index, char in enumerate(s):
            if char in seen and start <= seen[char]:
                start = seen[char] + 1
            else:
                max_length = max(max_length, index - start + 1)
            
            seen[char] = index
        
        return max_length
        
```

- 아이디어
    - two pointer

- 제한사항
    - len(s) == 0인 문자가 입력될 수도 있음.